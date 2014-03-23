package cs2340.android.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements AccountModel, Serializable {

	private String displayName;
	private String name;
	private double balance;
	private double interest;
	private User owner;
	private Collection<TransactionInterface> transactions = new ArrayList<TransactionInterface>();
	
	public Account(String name, String displayName, double balance,
			double interest, User owner) {
		
		this.owner = owner;
		this.displayName = displayName;
		this.name = name;
		this.balance = 0;
		this.interest = interest;
		this.makeDeposit(new SimpleDateFormat("MM/dd/yyyy").format(new Date()), null, "Account Created", balance, this);
	}

	@Override
	public User getOwner() {
		return owner;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public double getIntrest() {
		return interest;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public void makeWithdrawl(String dateMade, String currentDate, 
			String source, double amount, Account account) {
		transactions.add(new Withdrawl(dateMade, currentDate, source, amount, this));
		//balance manipulation in Withdraw
	}

	@Override
	public void makeDeposit(String dateMade, String currentDate, String source,
			double amount, Account account) {
		transactions.add(new Deposit(dateMade, currentDate, source, amount, this));	
		//balance manipulation in Deposit
	}
	
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
		for (TransactionInterface t : transactions) {
			writeables.add(t.getWritable());
		}
		return writeables;
	}
	
	public Collection<TransactionInterface> getTransactions() {
		return transactions;
	}
	
}
