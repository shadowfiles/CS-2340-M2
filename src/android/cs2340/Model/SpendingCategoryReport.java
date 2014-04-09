package android.cs2340.Model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 * Implementation of ReportModel.
 * @author Team 42
 *
 */
public class SpendingCategoryReport implements ReportModel, Serializable {

    /**
     * Android required serialization ID.
     */
    private static final long serialVersionUID = 1;
    
    /**
     * The owner of the accounts being reported on.
     */
    UserModel theUser;
    
    /**
     * Starting date for the reports. 
     */
    String startDate;
    
    /**
     * Ending date for the reports.
     */
    String endDate;
    
    /**
     * A Map of the report with transactions linked to spending. 
     */
    HashMap<String, Double> report = new HashMap<String, Double>();
    
    /**
     * The String form of the report.
     */
    String writenReport = "";

    @Override
    public UserModel getUser() {
        return theUser;
    }

    /**
     * Constructor for the report.
     * @param user The user who's requesting the report.
     * @param theStartDate The starting date of the report.
     * @param theEndDate
     */
    public SpendingCategoryReport(UserModel user, String theStartDate,
            String theEndDate) {
        this.theUser = user;
        this.startDate = theStartDate;
        this.endDate = theEndDate;

        makeReport();
    }

    /**
     * Makes the report.
     */
    private void makeReport() {
        Collection<AccountModel> accounts = theUser.getAccounts();
        for (AccountModel a : accounts) {
            Collection<TransactionModel> trans = a.getTransactions();
            for (TransactionModel t : trans) {
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
    public boolean goodDate(String transactionDate, String theStartDate,
            String theEndDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date transDate;
        try {
            transDate = sdf.parse(transactionDate);

            Date start = sdf.parse(theStartDate);
            Date end = sdf.parse(theEndDate);
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