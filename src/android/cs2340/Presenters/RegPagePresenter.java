package android.cs2340.Presenters;

import android.cs2340.Model.UserListModel;
import android.cs2340.Views.RegisterPageView;

public class RegPagePresenter {

    private RegisterPageView view;
    private UserListModel model;

    public RegPagePresenter(UserListModel m, RegisterPageView v) {
        view = v;
        model = m;
    }

    // SUPPORT ERROR MESSAGE
    public void onClickReg() {
        model.addUser(view.getUsername(), view.getPassOne(), view.getPassTwo());
        view.goToIntro();
    }

    public void onClickBack() {
        view.goToIntro();
    }

}
