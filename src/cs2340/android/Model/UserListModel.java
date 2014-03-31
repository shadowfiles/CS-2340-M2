package cs2340.android.Model;

public interface UserListModel {
	
	boolean goodPass(final String user, final String pass);
	void addUser(final String name, final String passone, final String passtwo);
	UserModel createAccount(String fullName, String accountName,
			double balance, double interest, UserModel owner);
	UserModel getUser(String user);
}
