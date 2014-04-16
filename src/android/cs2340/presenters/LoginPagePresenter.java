package android.cs2340.presenters;

import android.cs2340.persistence.UserDataSource;
import android.cs2340.persistence.UserDataTable;
import android.cs2340.views.LoginPageView;
import android.cs2340.model.UserModel;

/**
 * The presenter for the login page. 
 * @author tiff
 *
 */
public class LoginPagePresenter {

    /**
     * The view used by the login page.
     */
    private LoginPageView view;

    /**
     * The counter for how many times someone has tried to login.
     */
    private int counter = 0;
    
    /**
     * The data source for users. 
     */
    private UserDataSource source; 

    /**
     * The constructor for the presenter. 
     * @param v The view used.
     */
    public LoginPagePresenter(LoginPageView v) {
        view = v;
        source = UserDataTable.getSource();
    }

    /**
     * Login for what happens when someone tries to login.
     */
    public void onClickLogin() {
        counter++;
        UserModel user = source.getUser(view.getUsername());
        if (user.verifyPassword(view.getPassword())) {
            view.goToSuccess(user.getId());
        } else {
            if (counter == 1) {
                view.setErrorMessage("Incorrect login info, please try again.");
            } else if (counter == 2) {
                view.setErrorMessage("One more time maybe?");
            } else if (counter == 3) {
                view.setErrorMessage("C'mon man...");
            } else {
                view.setErrorMessage("You should just contact your admin now");
            }
        }
    }

    /** 
     * Login for what happens when someone clicks the back button.
     */
    public void onClickBack() {
        view.goToIntro();
    }

}
