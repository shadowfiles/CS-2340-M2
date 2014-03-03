package cs2340.android.Model;

import java.util.Collection;

public interface ListModel {
	
	User goodPass(final String user, final String pass);
	void addUser(final String user, final String pass, final String name);
	Collection<User> getUsers();
	User getUser(String user, String pass);
	
}
