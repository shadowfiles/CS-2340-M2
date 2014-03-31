package cs2340.android.Model;

import cs2340.android.Persistence.AccountDataSource;
import cs2340.android.Persistence.UserDataSource;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;

import android.content.Context;

public class UserList implements UserListModel {

	private static UserList INSTANCE;
	private HashMap<String, UserModel> Users;
	private UserDataSource dataSource;
	private AccountDataSource accountDataSource;

	//ask
	private UserList(Context c) {
		dataSource = new UserDataSource(c);
		Users = dataSource.getAllUsers();
		accountDataSource = new AccountDataSource(c);
	}

	public static UserList getInstance(Context c) {
		if (INSTANCE == null) {
			INSTANCE = new UserList(c);
		}
		return INSTANCE;
	}
	
	//INTERFACE METHODS
	public UserModel getUser(String username) {
		UserModel user = Users.get(username);
		return user;
	}
	
	public boolean goodPass(String username, String pass) {
		UserModel user = getUser(username);
		return user != null && user.verifyPassword(pass);
	}
	
	public UserModel createAccount(String fullName, String accountName,
			double balance, double interest, UserModel owner) {
		UserModel user = getUser(owner.getUsername());
		AccountModel account = accountDataSource.createAccount(fullName, accountName, 
				balance, interest, user);
		user.addAccount(account);
		return user;
	}

	public void addUser(String username, String passone, String passtwo) {
		if (passone.equals(passtwo) && !Users.containsKey(username.hashCode())) {
			// Add the user to the database
			UserModel user = dataSource.createUser(username, passone);

			// Then put them in the UserList
			Users.put(username, user);
		}
		//ELSE RETURN ERROR
	}

}
