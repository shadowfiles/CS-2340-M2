package cs2340.android.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;

public class UserList implements ListModel {

	private static UserList INSTANCE = new UserList();
	private HashMap<Integer, UserModel> Users;

	//ask
	private UserList() {
		Users = new HashMap<Integer, UserModel>();
		Users.put("admin".hashCode(), new User("admin", "pass123"));
	}

	public static UserList getInstance() {
		return INSTANCE;
	}

	
	//INTERFACE METHODS
	
	public UserModel getUser(String user, String pass) {
		return Users.get(user.hashCode());
	}
	
	public boolean goodPass(String user, String pass) {
		return getUser(user, pass).getPassword() == pass.hashCode();
	}

	public void addUser(String user, String passone, String passtwo) {
		if (passone.equals(passtwo) && !Users.containsKey(user.hashCode())) {
			Users.put("user".hashCode(), new User(user, passone));
		}
		//ELSE RETURN ERROR
	}

	//USER THIS FOR PRESISTENCE?! 
	public Collection<UserModel> getUsers() {
		return Users.values();
	}

}
