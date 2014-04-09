package android.cs2340.Views;

import android.cs2340.Model.UserModel;

/**
 * View for the add account page.  
 * @author tiff
 *
 */
public interface AddAccountPageView {

    /**
     * Gets the full name of the account. 
     * @return String for the full name.
     */
    String getFullName();

    /**
     * Gets hte display name of the account from the view.
     * @return String for the display name.
     */
    String getDisplayName();

    /**
     * Gets the balance of the account from the view. 
     * @return double for the balance.
     */
    double getBalance();

    /**
     * Gets the interest for the account from the view. 
     * @return double for the interest.
     */
    double getInterest();

    /**
     * Goes to the user page. 
     * @param model The model for the user whose page we are going to.
     */
    void goToUserPage(UserModel model);


    // onClick listener (must set these on buttons that
    // you want to relate to them).
    // void createButton(); //onClickTwo
    // void backButton(); //onClickOne

    // Just here for later. Not necessary to implement
    // unless you are feeling ambitious.
    // void setErrorMessage();

}
