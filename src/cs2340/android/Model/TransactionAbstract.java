package cs2340.android.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TransactionAbstract {

	private long id;
	private String dateMade;
	private String currentDate;
	private String category;
	private double amount;
	private AccountModel account;

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
