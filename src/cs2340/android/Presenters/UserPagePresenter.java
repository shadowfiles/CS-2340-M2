package cs2340.android.Presenters;
import cs2340.android.Model.Account;
import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;
import cs2340.android.Views.UserPageView;

public class UserPagePresenter {
	
	private UserPageView view;
	private UserModel model;
	
	
	public UserPagePresenter (UserModel m, UserPageView v) {
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