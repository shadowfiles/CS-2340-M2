package android.cs2340.Presenters;

import android.cs2340.Model.UserListModel;
import android.cs2340.Views.LoginPageView;

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
     * The model used by the login page.
     */
    private UserListModel model;
    
    /**
     * The counter for how many times someone has tried to login.
     */
    private int counter = 0;

    /**
     * The constructor for the presenter. 
     * @param m The model used.
     * @param v The view used.
     */
    public LoginPagePresenter(UserListModel m, LoginPageView v) {
        view = v;
        model = m;
    }

    /**
     * Login for what happens when someone tries to login.
     */
    public void onClickLogin() {
        counter++;
        if (model.goodPass(view.getUsername(), view.getPassword())) {
            view.goToSuccess(model.getUser(view.getUsername()));
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
