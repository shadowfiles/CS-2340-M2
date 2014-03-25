package cs2340.android.Model;

public abstract class TransactionAbstract {


	private String dateMade;
	private String currentDate;
	private String catagory;
	private double amount;
	private Account account;
	
	public String getDateMade() {
		return dateMade;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public String getCatagory() {
		return catagory;
	}
	public double getAmount() {
		return amount;
	}
	public String getWritable() {
		return dateMade + ": " + catagory + ", " + amount;
	}
}
