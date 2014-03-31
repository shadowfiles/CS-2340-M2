package cs2340.android.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface TransactionModel {

	String getDateMade();
	String getCurrentDate();
	String getCategory();
	double getAmount();
	String getWritable();
}
