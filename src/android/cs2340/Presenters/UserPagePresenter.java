package android.cs2340.Presenters;

import android.cs2340.Model.UserModel;
import android.cs2340.Views.UserPageView;

public class UserPagePresenter {

    private UserPageView view;
    private UserModel model;

    public UserPagePresenter(UserModel m, UserPageView v) {
        view = v;
        model = m;
    }

    public void drawAccounts() {
        view.drawAccounts(model.getAccountWriteables());
    }

    public void goToCreateSpendingReport() {
        view.goToCreateSpendingReport(model);
    }

    public void onClickAddAccount() {
        view.goToAddAccount(model);
    }

    public void onClickLogout() {
        view.goToIntro();
    }

    public void onClickAccount(String name) {
        view.goToAccount(model.getAccount(name));
    }
}