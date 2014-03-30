package cs2340.android.Model;

import cs2340.android.Persistence.UserDataSource;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;

import android.content.Context;

public class UserList implements ListModel {

	private static UserList INSTANCE = new UserList();
	private HashMap<String, UserModel> Users;
	private UserDataSource dataSource;

	//ask
	private UserList() {
		//Users.put("admin".hashCode(), new User("admin", "pass123"));
		dataSource = new UserDataSource();
		Users = dataSource.getAllUsers();
	}

	public static UserList getInstance() {
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
