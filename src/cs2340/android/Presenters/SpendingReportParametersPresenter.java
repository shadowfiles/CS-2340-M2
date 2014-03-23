package cs2340.android.Presenters;

import java.io.Serializable;

import android.content.Intent;
import cs2340.android.Activities.AccountActivity;
import cs2340.android.Model.AccountModel;
<<<<<<< HEAD
import cs2340.android.Model.UserModel;
=======
>>>>>>> a2095b34a50a043a082734626db958a9a807da5e
import cs2340.android.Views.SpendingReportParametersView;

public class SpendingReportParametersPresenter {

<<<<<<< HEAD
	AccountModel account;
	UserModel user;
	SpendingReportParametersView view;
	
	public SpendingReportParametersPresenter(AccountModel accountModel, UserModel userModel, SpendingReportParametersView view) {
		this.account = accountModel;
		this.user = userModel;
=======
	AccountModel model;
	SpendingReportParametersView view;
	
	public SpendingReportParametersPresenter(AccountModel model, SpendingReportParametersView view) {
		this.model = model;
>>>>>>> a2095b34a50a043a082734626db958a9a807da5e
		this.view = view;
	}
	
	public void goToReport() {
<<<<<<< HEAD
		view.goToReport(user);
	}
	
	public void back() {
		view.goToAccount(account);
=======
		view.goToReport(model);
	}
	
	public void back() {
		view.goToAccount(model);
>>>>>>> a2095b34a50a043a082734626db958a9a807da5e
	}
}
