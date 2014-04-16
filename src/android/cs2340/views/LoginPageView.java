package android.cs2340.views;

/**
 * The view for the login page.   
 * @author tiff
 *
 */
public interface LoginPageView {
    /**
     * Gets the username entered.
     * @return String for the username entered.
     */
    String getUsername();

    /**
     * Gets the password entered.
     * @return String for the password entered. 
     */
    String getPassword();

    /**
     * Changes the error message displayed for the user. 
     * @param text The error message shown.
     */
    void setErrorMessage(String text);

    /**
     * Goes to the main page of the app on success.  
     * @param userId The UserModel used to populate the next view.
     */
    void goToSuccess(long userId);

    /**
     * Goes back to the intro page.
     */
    void goToIntro();
}
