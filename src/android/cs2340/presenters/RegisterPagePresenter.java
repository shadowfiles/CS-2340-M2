package android.cs2340.presenters;

import android.cs2340.views.RegisterPageView;
import android.cs2340.persistence.UserDataSource;
import android.cs2340.persistence.UserDataTable;

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
     * The user data source.
     */
    private UserDataSource source;

    /**
     * The constructor for the register page. 
     * @param v The view used. 
     */
    public RegisterPagePresenter(RegisterPageView v) {
        view = v;
        source = UserDataTable.getSource();
    }

    /**
     * Clicking the register button. 
     */
    public void onClickReg() {
        if (!view.getPassOne().equals(view.getPassTwo())) {
            //error
            view.setInfoErrorMessage("Your passwords aren't equal! ");
        } else if (source.getUser(view.getUsername()) != null) {
            //error
            view.setInfoErrorMessage("The username you picked is already taken! ");
        } else {
            source.createUser(view.getUsername(), view.getPassOne());
            view.goToIntro();
        }
    }

    /**
     * Clicking the back button.
     */
    public void onClickBack() {
        view.goToIntro();
    }

}
