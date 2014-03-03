package cs2340.android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements UserModel, Serializable{
	
	private String username;
	private String password;
	private ArrayList<Account> Accounts = new ArrayList<Account>();
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void addAccount(String name, String displayName, 
					double balance, double intrest) {
		Accounts.add(new Account(name, displayName, balance, intrest, this));
	}
	
	public ArrayList<Account> getAccounts() {
		return Accounts;
	}
	//add other user stuff

	
}
