package cs2340.android.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends TransactionAbstract implements Serializable{

	private String dateMade;
	private String currentDate;
	private String catagory;
	private double amount;
	private Account account;
	
	public Deposit(String dateMade, String currentDate, String source,
			double amount, Account account) {

		this.dateMade = dateMade;
		this.currentDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		this.catagory = source;
		this.amount = amount;
		this.account = account;
		
		account.changeBalance(amount);
	}
	@Override
	public String getDateMade() {
		return dateMade;
	}
	@Override
	public String getCurrentDate() {
		return currentDate;
	}
	@Override
	public String getCatagory() {
		return catagory;
	}
	@Override
	public double getAmount() {
		return amount;
	}
	
	
	@Override
	public String getWritable() {
		return dateMade + ": " + catagory + ", " + amount;
	}
	
}
