package android.cs2340.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;

import android.cs2340.persistence.UserDataSource;
import android.cs2340.persistence.UserDataTable;

/**
 * Implementation of ReportModel.
 * @author Team 42
 *
 */
public class Report implements ReportModel, Serializable {
    /**
     * Serial version.
     */
    private static final long serialVersionUID = 1;
    
    /**
     * The owner of the accounts being reported on.
     */
    long userId;
    
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
    String writtenReport = "";
   
    /**
     * stuff for graphing
     */
    String[] Vprecent = {"0%", "50%", "100%"};
    /**
     * stuff for graphing
     */
    String[] Hcatigories = {"Food", "Clothing", "Other"};
    /**
     * stuff for graphing
     */
    float[] Values = new float[3];
    /**
     * get Vprecent.
     */
    public String[] getVpercent(){
    	return Vprecent;
    }
    /**
     * get Hcatigories.
     */
    public String[] getHcatigories(){
    	return Hcatigories;
    }
    /**
     * get Values.
     */
    public float[] getValues(){
    	return Values;
    }
    
    /**
     * Constructor for the report.
     * @param theUser The user who's requesting the report.
     * @param theStartDate The starting date of the report.
     * @param theEndDate The date the transaction ends. 
     */
    public Report(UserModel theUser, String theStartDate,
            String theEndDate) {
        this.userId = theUser.getId();
        this.startDate = theStartDate;
        this.endDate = theEndDate;

        makeReport();
    }

    @Override
    public UserModel getUser() {
        UserDataSource source = UserDataTable.getSource();
        return source.getUser(userId);
    }

    @Override
    public String getWrittenReport() {
        double total = 0;
        writtenReport += "Spending Catagory Report for " + getUser().getUsername()
                + "\n ";
        writtenReport += "\tReport from " + startDate + " - " + endDate + "\n";
        for (String s : report.keySet()) {
            writtenReport += "\t" + s + ":\t\t" + report.get(s) + "\n";
            total += report.get(s);
        }
        writtenReport += "Total:\t" + total;
        return writtenReport;
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
            return start.compareTo(transDate) <= 0 && end.compareTo(transDate) >= 0;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Makes the report.
     */
    private void makeReport() {
    	int total = 0;
        Collection<AccountModel> accounts = getUser().getAccounts();
        for (AccountModel a : accounts) {
            Collection<TransactionModel> trans = a.getTransactions();
            for (TransactionModel t : trans) {
                // this could be error (how to check if t is a withdrawal?)
                if (goodDate(t.getDateMade(), startDate, endDate)) {
                    if (t.getAmount() < 0) {
                    	
                    	if(t.getCategory() == "Food"){
                    		Values[0] += t.getAmount();
                    		total += t.getAmount();
                    	}
                    	else if(t.getCategory() == "Clothing"){
                    		Values[1] += t.getAmount();
                    		total += t.getAmount();
                    	}
                    	else {
                    		Values[2] += t.getAmount();
                    		total += t.getAmount();
                    	}
                    	
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
        for(int i = 0; i<Values.length;i++) {
        	Values[i] = Values[i]/total;
        }
    }

}
