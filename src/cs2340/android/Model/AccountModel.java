package cs2340.android.Model;

import java.util.Collection;


public interface AccountModel {

	UserModel getOwner();
	String getName();
	double getBalance();
	double getIntrest();
	String getDisplayName();
	void changeBalance(double amount);
	void makeWithdrawl(String dateMade, String currentDate, String source,
			double amount, Account account);
	void makeDeposit(String dateMade, String currentDate, String source,
			double amount, Account account);
	String getWritable();
	Collection<String> getTransactionWritables();
	Collection<TransactionAbstract> getTransactions();
}
