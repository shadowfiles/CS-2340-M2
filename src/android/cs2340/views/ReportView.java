package android.cs2340.views;

/**
 * The view for the report page.   
 * @author tiff
 *
 */
public interface ReportView {
    /**
     * Goes back to the user page. 
     * @param userId The user id used to populate the view.
     */
    void goToUserPage(long userId);

    /**
     * Draws a report based on a String.  
     * @param writtenReport The String for the written report.
     */
    void drawReport(String writtenReport);

}
