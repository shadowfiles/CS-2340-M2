package cs2340.android.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TransactionAbstract {


	private String dateMade;
	private String currentDate;
	private String category;
	private double amount;
	private Account account;
	
	public TransactionAbstract(String dateMade, String currentDate, String source,
			double amount, Account account) {
		this.currentDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		this.dateMade = dateMade;
		this.category = source;
		this.amount = amount;
		this.account = account;

		account.changeBalance(amount);
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
