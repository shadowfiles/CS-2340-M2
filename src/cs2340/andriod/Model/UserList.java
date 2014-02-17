package cs2340.andriod.Model;

import java.util.ArrayList;
import java.util.Collection;

public class UserList implements Model {

	private ArrayList<User> Users;

	public UserList() {
		Users = new ArrayList<User>();
		Users.add(new User ("admin", "pass123"));
	}

	public boolean goodPass(String name, String key) {

		for (User u : Users) {
			if(u.getUsername().equals(name) && u.getPassword().equals(key)) {
					return true;
			}
		} 
		return false;
	}

	public void addUser(String user, String key) {
		Users.add(new User(user, key));
	}
	
	public Collection<User> getUsers() {
		return Users;
	}

}
