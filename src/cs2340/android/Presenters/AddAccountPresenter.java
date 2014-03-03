package cs2340.android.Presenters;

import cs2340.android.Model.UserModel;
import cs2340.android.Views.AddAccountPageView;

public class AddAccountPresenter implements ListenerPresenterInterface{
	UserModel model; 
	AddAccountPageView view;
	
	public AddAccountPresenter(UserModel m, AddAccountPageView v) {
		model = m;
		view = v;
		
		view.attemptAddAccountCallback(this);
	}
	
	//onClickOne - BackButton (just goes to UserPage, and does not create account
	public void onClickOne() {
		view.goToUserPage(model);
	}
	
	//onClickTwo - Create Account, and return to UserPage
	public void onClickTwo() {
		//CODE TO CHECK IF THERE ARE INPUTS IN THE EDITTEXT's
		model.addAccount(view.getFullName(), view.getDisplayName(), view.getBalance(), view.getInterest());
		view.goToUserPage(model);
	}
}
