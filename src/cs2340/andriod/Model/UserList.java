package cs2340.andriod.Model;

import java.util.ArrayList;
import java.util.Collection;

public class UserList implements Model {

	private static UserList INSTANCE = new UserList();
	private ArrayList<User> Users;

	private UserList() {
		Users = new ArrayList<User>();
		Users.add(new User ("admin", "pass123"));
	}

	public static UserList getInstance() {
		return INSTANCE;
	}
	
	public boolean goodPass(String user, String pass) {

		for (User u : Users) {
			if(u.getUsername().equals(user) && u.getPassword().equals(pass)) {
					return true;
			}
		} 
		return false;
	}

	public void addUser(String user, String passone, String passtwo) {
		if (passone.equals(passtwo)) {
			Users.add(new User(user, passone));
		}
	}
	
	public Collection<User> getUsers() {
		return Users;
	}

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		
	}

}
