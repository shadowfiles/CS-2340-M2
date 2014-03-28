package cs2340.android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.jar.Attributes.Name;

import org.apache.http.impl.conn.Wire;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements UserModel, Serializable{
	
	//HASH THE PASSWORD
	private String username;
	private int password;
	private ArrayList<AccountModel> Accounts = new ArrayList<AccountModel>();
	
	public User(String username, String password) {
		this.username = username;
		this.password = password.hashCode();
	}
	
	public int getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void addAccount(String name, String displayName, 
					double balance, double intrest) {
		Accounts.add(new Account(name, displayName, balance, intrest, this));
	}
	
	public AccountModel getAccount(String name) {
		for(AccountModel a: Accounts) {
			if (a.getName().equals(name)) {
				return a;
			}				
		}
		return null;
	}
	
	public Collection<AccountModel> getAccounts() {
		return Accounts;
	}
	
	public Collection<String> getAccountWriteables() {
		Collection<String> writeables = new ArrayList<String>();
		for (AccountModel a : Accounts) {
			writeables.add(a.getWritable());
		}
		return writeables;
	}

	@Override
	public String GetWritable() {
		return username;
	}

	@Override
	public ReportModel getReport(String dateStart, String dateEnd) {
		return new SpendingCategoryReport(this, dateStart, dateEnd);
	}

	//add other user stuff?
}
