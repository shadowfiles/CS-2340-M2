package cs2340.android.Presenters;

import cs2340.android.Model.UserModel;
import cs2340.android.Views.AddAccountPageView;

//onClickOne - BackButton (just goes to UserPage, and does not create account
//onClickTwo - Create Account, and return to UserPage
public class AddAccountPresenter implements PresenterInterface{
	UserModel model; 
	AddAccountPageView view;
	
	public AddAccountPresenter(UserModel m, AddAccountPageView v) {
		model = m;
		view = v;
	}
	
	public void onClickOne() {
		view.backButton();
	}
	
	public void onClickTwo() {
		model.addAccount(view.getFullName(), view.getDisplayName(), view.getBalance(), view.getInterest());
		view.createButton();
	}
}
