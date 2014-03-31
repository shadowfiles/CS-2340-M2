package cs2340.android.Presenters;

import cs2340.android.Model.UserListModel;
import cs2340.android.Views.LoginPageView;

public class LoginPagePresenter {

	private LoginPageView view;
	private UserListModel model;
	private int counter = 0;
	
	public LoginPagePresenter (UserListModel m, LoginPageView v) {
		view = v;
		model = m;
	}
	
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

	public void onClickBack() {
		view.goToIntro();
	}

}
