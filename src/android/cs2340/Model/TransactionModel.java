package android.cs2340.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface TransactionModel {

    String getDateMade();

    String getCurrentDate();

    String getCategory();

    double getAmount();

    String getWritable();
}
