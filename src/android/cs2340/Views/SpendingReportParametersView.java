package android.cs2340.Views;

import android.cs2340.Model.ReportModel;
import android.cs2340.Model.UserModel;

/**
 * The spending report view.   
 * @author tiff
 *
 */
public interface SpendingReportParametersView {

    /**
     * Goes back to the user page.
     * @param user UserModel to populate the page.
     */
    void goToUserPage(UserModel user);

    /**
     * Gets the starting date for the transactions. 
     * @return String for the starting date entered.
     */
    String getStartDate();

    /**
     * Gets the end date for the transactions.
     * @return String for the ending date entered.
     */
    String getEndDate();

    /**
     * Goes to the report.  
     * @param report A Model for the report being used. 
     */
    void goToReport(ReportModel report);

}
