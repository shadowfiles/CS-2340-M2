package android.cs2340.model;

/**
 * Interface for Reports. 
 * @author Team 42
 *
 */
public interface ReportModel {

    /**
     * Gets the owner of the accounts being reported on.
     * @return UserModel object for the owner of the accounts/ 
     */
    UserModel getUser();

    /**
     * Gets the report in String form.
     * @return String for the report.
     */
    String getWrittenReport();

    /**
     * Checks to see if a date is valid in side of a range. 
     * @param transactionDate The date of the transaction.
     * @param startDate The starting date in the range.
     * @param endDate The ending date in the range. 
     * @return boolean for if the date fits between start and end date.
     */
    boolean goodDate(String transactionDate, String startDate, String endDate);
    /**
     * get list of string percentages.
     * @return strings of percentages
     */
    public String[] getVpercent();
    /**
     * get list of categories.
     * @return list of categories
     */
    public String[] getHcatigories();
    /**
     * get list of values.
     * @return list of values
     */
    public float[] getValues();
    
}
