package android.cs2340.views;

/**
 * The view for the register page.
 * @author tiff
 *
 */
public interface RegisterPageView {

    /**
     * Gets the username entered in the register page. 
     * @return String for the username entered.
     */
    String getUsername();

    /**
     * Gets the first password entered in the page. 
     * @return String for the password entered.
     */
    String getPassOne();

    /**
     * Gets the second password entered in the page.
     * @return String for the second password.  
     */
    String getPassTwo();

    /**
     * Changes the error message.  
     * @param text String for the new error message. 
     */
    void setInfoErrorMessage(String text);

    /**
     * Goes back to the intro page. 
     */
    void goToIntro();

    /**
     * Gets rid of the info entered.    
     */
    void clearInfo();

}
