package android.cs2340.presenters;

import android.cs2340.model.UserModel;
import android.cs2340.persistence.UserDataTable;
import android.cs2340.persistence.UserDataSource;
import android.cs2340.views.UserPageView;

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
     * The model used.
     */
    private UserModel model;

    /**
     * The source used.
     */
    private UserDataSource source;

    /**
     * The constructor for the user page.
     * @param id The model used.
     * @param v The view used.
     */
    public UserPagePresenter(long id, UserPageView v) {
        source = UserDataTable.getSource();
        view = v;
        model = source.getUser(id);
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
        view.goToCreateSpendingReport(model.getId());
    }
    
    /**
     * What happens when someone clicks the add account button.
     */
    public void onClickAddAccount() {
        view.goToAddAccount(model.getId());
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
        view.goToAccount(model.getAccount(name).getId());
    }
}