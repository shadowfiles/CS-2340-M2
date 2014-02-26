package cs2340.android.Presenters;

import cs2340.android.Model.Model;
import cs2340.android.Views.LoginPageView;

public class LoginPagePresenter implements PresenterInterface {

	private LoginPageView view;
	private Model model;
	private int counter = 0;
	
	public LoginPagePresenter (Model m, LoginPageView v) {
		view = v;
		model = m;
		view.attemptLoginCallback(this);
	}
	
	@Override
	public void onClickOne() {
		counter++;
		if (model.goodPass(view.getUsername(), view.getPassword()) == true) {
			view.goToSuccess();
		} else {
			if (counter == 1) {
				view.setErrorMessage("Incorrect login info, please try again.");
			} else if (counter == 2) {
				view.setErrorMessage("One more time maybe?");
			} else if (counter == 3) {
				view.setErrorMessage("Common man...");
			} else {
				view.setErrorMessage("You should just contact your admin now");
			}
	
		
		}
	}

	@Override
	public void onClickTwo() {}

}
