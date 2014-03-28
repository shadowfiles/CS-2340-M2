package cs2340.android.Model;

import java.util.Collection;

public interface UserModel  {
	 
	 int getPassword();
	 String getUsername();
	 void addAccount(String name, String displayName, double balance, double intrest);
	 Collection<AccountModel> getAccounts();
	 AccountModel getAccount(String name);
	 String GetWritable();
	 Collection<String> getAccountWriteables();
	 ReportModel getReport(String dateStart, String dateEnd);
}