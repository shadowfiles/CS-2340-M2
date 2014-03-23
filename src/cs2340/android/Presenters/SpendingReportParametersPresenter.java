package cs2340.android.Presenters;

import java.io.Serializable;

import android.content.Intent;
import cs2340.android.Activities.AccountActivity;
import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;
import cs2340.android.Views.SpendingReportParametersView;

public class SpendingReportParametersPresenter {

	AccountModel account;
	UserModel user;
	SpendingReportParametersView view;
	
	public SpendingReportParametersPresenter(AccountModel accountModel, UserModel userModel, SpendingReportParametersView view) {
		this.account = accountModel;
		this.user = userModel;
		this.view = view;
	}
	
	public void goToReport() {
		view.goToReport(user);
	}
	
	public void back() {
		view.goToAccount(account);
	}
}
