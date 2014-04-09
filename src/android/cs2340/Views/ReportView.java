package android.cs2340.Views;

import android.cs2340.Model.UserModel;

/**
 * The view for the report page.   
 * @author tiff
 *
 */
public interface ReportView {
    /**
     * Goes back to the user page. 
     * @param user The user model used to populate the view.
     */
    void goToUserPage(UserModel user);

    /**
     * Draws a report based on a String.  
     * @param writtenReport The String for the written report.
     */
    void drawReport(String writtenReport);

}
