package cs2340.android.Presenters;

import cs2340.android.Persistence.AccountDataSource;
import cs2340.android.Model.UserModel;
import cs2340.android.Views.AddAccountPageView;

public class AddAccountPresenter {
	UserModel model;
	AddAccountPageView view;
	AccountDataSource dataSource;
	
	public AddAccountPresenter(UserModel m, AddAccountPageView v, AccountDataSource d) {
		model = m;
		view = v;
		dataSource = d;
	}
	
	//onClickOne - BackButton (just goes to UserPage, and does not create account
	public void onClickBack() {
		view.goToUserPage(model);
	}
	
	//onClickTwo - Create Account, and return to UserPage
	public void onClickCreate() {
		//CODE TO CHECK IF THERE ARE INPUTS IN THE EDITTEXT's
		//CHECK IF ACCOUNT NAME IS ALREADY USED
		model.addAccount(dataSource.createAccount(view.getFullName(), view.getDisplayName(), 
				view.getBalance(), view.getInterest(), model));
		
		view.goToUserPage(model);
	}
}
