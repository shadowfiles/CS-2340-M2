package android.cs2340.views;

import android.cs2340.model.ReportModel;

/**
 * The spending report view.   
 * @author tiff
 *
 */
public interface SpendingReportParametersView {

    /**
     * Goes back to the user page.
     * @param userId UserModel to populate the page.
     */
    void goToUserPage(long userId);

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
