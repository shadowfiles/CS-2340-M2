package cs2340.android.Model;

import java.util.ArrayList;
import java.util.Collection;

public class User implements UserModel{
	
	private String username;
	private String password;
	private Collection<Account> Accounts = new ArrayList<Account>();
	
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
		Accounts.add(new Account(name, displayName, balance, intrest));
	}
	//add other user stuff
}
