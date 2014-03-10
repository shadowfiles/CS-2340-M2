package cs2340.android.Model;

import java.util.Collection;

public interface ListModel {
	
	boolean goodPass(final String user, final String pass);
	void addUser(final String name, final String passone, final String passtwo);
	Collection<User> getUsers();
	User getUser(String user, String pass);
	
}
