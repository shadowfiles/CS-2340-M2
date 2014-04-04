package android.cs2340.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawal implements TransactionModel, Serializable{
	private static final long serialVersionUID = 1; 
	
	private long id;
	private String dateMade;
	private String currentDate;
	private String category;
	private double amount;
	private AccountModel account;

	public Withdrawal(long id, String dateMade, String source,
			double amount, AccountModel account) {
		this.id = id;
		this.currentDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		this.dateMade = dateMade;
		this.category = source;
		this.amount = -amount;
		this.account = account;
	}
	
	public String getDateMade() {
		return dateMade;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public String getCategory() {
		return category;
	}

	public double getAmount() {
		return amount;
	}

	public String getWritable() {
		return dateMade + ": " + category + ", " + amount;
	}
}
