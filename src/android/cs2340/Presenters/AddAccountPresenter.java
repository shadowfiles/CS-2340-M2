package android.cs2340.Presenters;

import android.cs2340.Model.UserListModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Views.AddAccountPageView;

public class AddAccountPresenter {
    UserModel model;
    AddAccountPageView view;
    UserListModel list;

    public AddAccountPresenter(UserModel m, UserListModel l,
            AddAccountPageView v) {
        model = m;
        view = v;
        list = l;
    }

    // onClickOne - BackButton (just goes to UserPage, and does not create
    // account
    public void onClickBack() {
        view.goToUserPage(model);
    }

    // onClickTwo - Create Account, and return to UserPage
    public void onClickCreate() {
        // CODE TO CHECK IF THERE ARE INPUTS IN THE EDITTEXT's
        // CHECK IF ACCOUNT NAME IS ALREADY USED
        model = list.createAccount(view.getFullName(), view.getDisplayName(),
                view.getBalance(), view.getInterest(), model);
        view.goToUserPage(model);
    }
}
