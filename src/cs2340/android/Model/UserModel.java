package cs2340.android.Model;

import java.util.Collection;

public interface UserModel  {
	 
	 String getPassword();
	 String getUsername();
	 void addAccount(String name, String displayName, double balance, double intrest);
	 Collection<Account> getAccounts();
	 Account getAccount(String name);
}