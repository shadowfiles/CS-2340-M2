package cs2340.android.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements AccountModel, Serializable {

	private static final long serialVersionUID = 1;
	private long id;
	private String displayName;
	private String name;
	private double balance;
	private double interest;
	private UserModel owner;
	private Collection<TransactionAbstract> transactions = new ArrayList<TransactionAbstract>();
	
	public Account(long id, String name, String displayName, double balance,
			double interest, UserModel owner) {
		
		this.id = id;
		this.owner = owner;
		this.displayName = displayName;
		this.name = name;
		this.balance = balance;
		this.interest = interest;
		//this.makeDeposit(new SimpleDateFormat("MM/dd/yyyy").format(new Date()), null, "Account Created", balance, this);
	}
	
	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public UserModel getOwner() {
		return owner;
	}
	
	@Override
	public String getName(){
		return name;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public double getInterest() {
		return interest;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}
	
	@Override
	public void addTransaction(TransactionAbstract t) {
		transactions.add(t);
	}
	
	@Override
	public void addTransactions(Collection<TransactionAbstract> t) {
		transactions.addAll(t);
	}
/*
	@Override
	public void makeWithdrawal(String dateMade, String currentDate, 
			String source, double amount, Account account) {
		transactions.add(new Withdrawal(dateMade, currentDate, source, amount, this));
		//balance manipulation in Withdraw
	}

	@Override
	public void makeDeposit(String dateMade, String currentDate, String source,
			double amount, Account account) {
		transactions.add(new Deposit(dateMade, currentDate, source, amount, this));	
		//balance manipulation in Deposit
	}
*/
	@Override
	public void changeBalance(double amount) {
		balance += amount;
	}

	@Override
	public String getWritable() {
		return name;
	}

	@Override
	public Collection<String> getTransactionWritables() {
		Collection<String> writeables = new ArrayList<String>();
		for (TransactionAbstract t : transactions) {
			writeables.add(t.getWritable());
		}
		return writeables;
	}
	
	public Collection<TransactionAbstract> getTransactions() {
		return transactions;
	}
	
}
