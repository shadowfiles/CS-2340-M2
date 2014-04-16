package android.cs2340.presenters;

import android.cs2340.model.UserModel;
import android.cs2340.views.AddAccountPageView;
import android.cs2340.persistence.AccountDataSource;
import android.cs2340.persistence.AccountDataTable;
import android.cs2340.persistence.UserDataSource;
import android.cs2340.persistence.UserDataTable;

/**
 * Presenter for adding an account. 
 * @author tiff
 *
 */
public class AddAccountPresenter {
    /**
     * The model for the presenter.
     */
    private UserModel model;
    
    /**
     * The view used by the presenter.
     */
    private AddAccountPageView view;

    /**
     * The data source for the accounts.
     */
    private AccountDataSource accountSource;
    
    /**
     * The data source for the users.
     */
    private UserDataSource userSource;

    /**
     * The constructor for adding an account. 
     * @param id The model used.
     * @param v The view used.
     */
    public AddAccountPresenter(long id, AddAccountPageView v) {
        userSource = UserDataTable.getSource();
        model = userSource.getUser(id);
        view = v;
    }

    /**
     * What happens when someone clicks back.
     */
    public void onClickBack() {
        view.goToUserPage(model.getId());
    }

    /**
     * What happens when someone clicks to create an account.
     */
    public void onClickCreate() {
        // CODE TO CHECK IF THERE ARE INPUTS IN THE EDITTEXT's
        // CHECK IF ACCOUNT NAME IS ALREADY USED
        if (view.getFullName().equals("TETRIS")) {
            view.goToTetris();
        } else {
            accountSource = AccountDataTable.getSource();
            accountSource.createAccount(view.getFullName(), view.getDisplayName(),
                    view.getBalance(), view.getInterest(), model);
            view.goToUserPage(model.getId());
        }
    }
}
