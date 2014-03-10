package cs2340.android.Model;

import java.io.Serializable;

public class Withdrawl implements TransactionInterface, Serializable{

	private String dateMade;
	private String currentDate;
	private String source;
	private double amount;
	private Account account;
	
	public String getDateMade() {
		return dateMade;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public String getSource() {
		return source;
	}
	public double getAmount() {
		return amount;
	}
	public Withdrawl(String dateMade, String currentDate, String source,
			double amount, Account account) {

		this.dateMade = dateMade;
		this.currentDate = currentDate;
		this.source = source;
		this.amount = -amount;
		this.account = account;
		
		account.changeBalance(-amount);

	}
	
}
