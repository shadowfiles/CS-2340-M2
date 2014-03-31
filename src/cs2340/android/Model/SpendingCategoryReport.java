package cs2340.android.Model;

import java.io.Serializable;
import java.security.cert.CollectionCertStoreParameters;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import android.util.Log;

public class SpendingCategoryReport implements ReportModel, Serializable {

	private static final long serialVersionUID = 1; 
	UserModel theUser;
	String startDate;
	String endDate;
	HashMap<String, Double> report = new HashMap<String, Double>();
	String writenReport = "";

	public UserModel getUser(){
		return theUser;
	}
	
	public SpendingCategoryReport(UserModel user, String startDate,
			String endDate) {
		this.theUser = user;
		this.startDate = startDate;
		this.endDate = endDate;

		makeReport();
	}

	@Override
	public void makeReport() {
		Collection<AccountModel> accounts = theUser.getAccounts();
		for (AccountModel a : accounts) {
			Collection<TransactionAbstract> trans = a.getTransactions();
			for (TransactionAbstract t : trans) {
				// this could be error (how to check if t is a withdrawal?)
				if (goodDate(t.getDateMade(), startDate, endDate)) {
					if (t.getAmount() < 0) {
						if (!report.containsKey(t.getCategory())) {
							report.put(t.getCategory(), -t.getAmount());
						} else {
							double currentVal = report.get(t.getCategory());
							report.remove(t.getCategory());
							currentVal -= t.getAmount();
							report.put(t.getCategory(), currentVal);
						}
					}
				}
			}
		}
		
	}

	@Override
	public String getWritenReport() {
		double total = 0;
		writenReport += "Spending Catagory Report for " + theUser.getUsername()
				+ "\n";
		writenReport += "\tReport from " + startDate + " - " + endDate + "\n";
		for (String s : report.keySet()) {
			writenReport += "\t" + s + ":\t\t" + report.get(s) + "\n";
			total += report.get(s);
		}
			writenReport += "Total:\t" + total;
		return writenReport;
	}

	// be weary
	@Override
	public boolean goodDate(String transactionDate, String startDate,
			String endDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date transDate;
		try {
			transDate = sdf.parse(transactionDate);

			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			if (start.compareTo(transDate) <= 0
					&& end.compareTo(transDate) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
