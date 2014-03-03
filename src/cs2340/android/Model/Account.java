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
	private Collection<Transaction> transactions = new ArrayList<Transaction>();
	
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
}
