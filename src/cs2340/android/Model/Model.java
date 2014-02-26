package cs2340.android.Model;

import java.util.Collection;

public interface Model {
	
	
	
	boolean goodPass(final String user, final String pass);
	void addUser(final String user, final String pass, final String name);
	Collection<User> getUsers();
	
	
	//STUFF TO DO FOR M5
	void addAccount();
	//must create accountClass and add it to UserClass
}
