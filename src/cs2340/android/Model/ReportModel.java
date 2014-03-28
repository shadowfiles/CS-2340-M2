package cs2340.android.Model;

import java.text.ParseException;

public interface ReportModel {
	
	void makeReport();
	String getWritenReport();
	boolean goodDate(String transactionDate, String startDate, String endDate);
	UserModel getUser();
	
}
