package cs2340.android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements AccountModel, Serializable {

	private String displayName;
	private String name;
	private double balance;
	private double intrest;
	private User owner;
	private Collection<TransactionInterface> transactions = new ArrayList<TransactionInterface>();
	
	public Account(String name, String displayName, double balance,
			double intrest, User owner) {
		
		this.owner = owner;
		this.displayName = displayName;
		this.name = name;
		this.balance = balance;
		this.intrest = intrest;
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
		return intrest;
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
	
}
