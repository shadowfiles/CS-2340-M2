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
     * @param graph values
     * @param graph categories
     * @param graph percents
     */
	void drawReport(String writtenReport, float[] values, String[] hcatigories,
			String[] vpercent);
}
