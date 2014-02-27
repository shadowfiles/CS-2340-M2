package cs2340.android.Presenters;

import cs2340.android.Model.UserModel;
import cs2340.android.Views.AddAccountPageView;

public class AddAccountPresenter implements PresenterInterface{
	UserModel model; 
	AddAccountPageView view;
	
	public AddAccountPresenter(UserModel m, AddAccountPageView v) {
		model = m;
		view = v;
	}
	
	//onClickOne - BackButton (just goes to UserPage, and does not create account
	public void onClickOne() {
		view.backButton();
	}
	
	//onClickTwo - Create Account, and return to UserPage
	public void onClickTwo() {
		model.addAccount(view.getFullName(), view.getDisplayName(), view.getBalance(), view.getInterest());
		view.createButton();
	}
}
