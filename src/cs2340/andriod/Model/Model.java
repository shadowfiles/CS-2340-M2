package cs2340.andriod.Model;

import java.util.Collection;

public interface Model {
	boolean goodPass(final String user, final String pass);
	void addUser(final String user, final String pass);
	Collection<User> getUsers();
	
}
