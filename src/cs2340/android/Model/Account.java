package cs2340.android.Model;

import java.util.ArrayList;
import java.util.Collection;

public class Account {

	String displayName;
	String Name;
	double balance;
	double intrest;
	Collection<Transaction> transactions = new ArrayList<Transaction>();
	
	public Account(String name, String displayName, double balance,
			double intrest) {
		this.displayName = displayName;
		Name = name;
		this.balance = balance;
		this.intrest = intrest;
	}
	
	
}
