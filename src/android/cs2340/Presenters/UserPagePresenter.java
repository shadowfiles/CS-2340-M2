package android.cs2340.Presenters;

import android.cs2340.Model.UserModel;
import android.cs2340.Views.UserPageView;

/**
 * The presenter for the user page.
 * @author tiff
 *
 */
public class UserPagePresenter {

    /**
     * The view used.
     */
    private UserPageView view;
    
    /**
     * Ter
     * he moddel used.
     */
    private UserModel model;

    /**
     * The constructor for the user page.
     * @param m The model used.
     * @param v The view used.
     */
    public UserPagePresenter(UserModel m, UserPageView v) {
        view = v;
        model = m;
    }

    /**
     * Draws the user's accounts owned.
     */
    public void drawAccounts() {
        view.drawAccounts(model.getAccountWriteables());
    }

    /**
     * Goes to the spending report.
     */
    public void goToCreateSpendingReport() {
        view.goToCreateSpendingReport(model);
    }
    
    /**
     * What happens when someone clicks the add account button.
     */
    public void onClickAddAccount() {
        view.goToAddAccount(model);
    }

    /**
     * The logout button is clicked.
     */
    public void onClickLogout() {
        view.goToIntro();
    }

    /**
     * An account is clicked.  
     * @param name The name of the account.
     */
    public void onClickAccount(String name) {
        view.goToAccount(model.getAccount(name));
    }
}