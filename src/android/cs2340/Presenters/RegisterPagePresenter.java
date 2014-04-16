package android.cs2340.Presenters;

import android.cs2340.Model.UserListModel;
import android.cs2340.Views.RegisterPageView;

/**
 * The presenter for the register page.
 * @author tiff
 *
 */
public class RegisterPagePresenter {

    /**
     * The view used.
     */
    private RegisterPageView view;
    
    /**
     * The model used.
     */
    private UserListModel model;

    /**
     * The constructor for the register page. 
     * @param m The model used.
     * @param v The view used. 
     */
    public RegisterPagePresenter(UserListModel m, RegisterPageView v) {
        view = v;
        model = m;
    }

    /**
     * Clicking the register button. 
     */
    public void onClickReg() {
        model.addUser(view.getUsername(), view.getPassOne(), view.getPassTwo());
        view.goToIntro();
    }

    /**
     * Clicking the back button.
     */
    public void onClickBack() {
        view.goToIntro();
    }

}
