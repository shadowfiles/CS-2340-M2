package android.cs2340.Model;

import java.text.ParseException;

public interface ReportModel {

    void makeReport();

    String getWritenReport();

    boolean goodDate(String transactionDate, String startDate, String endDate);

    UserModel getUser();

}
