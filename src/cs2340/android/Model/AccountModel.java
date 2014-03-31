package cs2340.android.Model;

import java.util.Collection;


public interface AccountModel {

	UserModel getOwner();
	long getId();
	String getName();
	double getBalance();
	double getInterest();
	String getDisplayName();
	void changeBalance(double amount);
	void addTransaction(TransactionAbstract t);
	void addTransactions(Collection<TransactionAbstract> t);
	/*
	void makeWithdrawl(String dateMade, String currentDate, String source,
			double amount, Account account);
	void makeDeposit(String dateMade, String currentDate, String source,
			double amount, Account account);
	*/
	String getWritable();
	Collection<String> getTransactionWritables();
	Collection<TransactionAbstract> getTransactions();
}
