package android.cs2340.Presenters;

import android.cs2340.Model.UserListModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Views.AddAccountPageView;

/**
 * Presenter for adding an account. 
 * @author tiff
 *
 */
public class AddAccountPresenter {
    /**
     * The model for the presenter.
     */
    UserModel model;
    
    /**
     * The view used by the presenter.
     */
    AddAccountPageView view;
    
    /**
     * The list of users used by the presenter. 
     */
    UserListModel list;

    /**
     * The constructor for adding an account. 
     * @param m The model used.
     * @param l The list used.
     * @param v The view used.
     */
    public AddAccountPresenter(UserModel m, UserListModel l,
            AddAccountPageView v) {
        model = m;
        view = v;
        list = l;
    }

    /**
     * What happens when someone clicks back.
     */
    public void onClickBack() {
        view.goToUserPage(model);
    }

    /**
     * What happens when someone clicks to create an account.
     */
    public void onClickCreate() {
        // CODE TO CHECK IF THERE ARE INPUTS IN THE EDITTEXT's
        // CHECK IF ACCOUNT NAME IS ALREADY USED
        model = list.createAccount(view.getFullName(), view.getDisplayName(),
                view.getBalance(), view.getInterest(), model);
        view.goToUserPage(model);
    }
}
