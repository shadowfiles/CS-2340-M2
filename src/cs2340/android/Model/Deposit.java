package cs2340.android.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends TransactionAbstract implements Serializable{
	private static final long serialVersionUID = 1; 

	public Deposit(String dateMade, String currentDate, String source,
			double amount, Account account) {
		super(dateMade, currentDate, source, amount, account);
	}
}
