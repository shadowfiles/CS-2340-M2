package cs2340.android.Model;

public interface UserModel {
	 
	 String getPassword();
	 String getUsername();
	 void addAccount(String name, String displayName, double balance, double intrest);
}