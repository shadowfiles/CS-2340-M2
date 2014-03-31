package cs2340.android.Model;

import java.util.Collection;

public interface UserModel  {
	 
	 int getPassword();
	 String getUsername();
	 boolean verifyPassword(String password);
	 void addAccounts(Collection<AccountModel> accounts);
	 void addAccount(AccountModel account);
	 long getId();
	 Collection<AccountModel> getAccounts();
	 AccountModel getAccount(String name);
	 String GetWritable();
	 Collection<String> getAccountWriteables();
	 ReportModel getReport(String dateStart, String dateEnd);
}