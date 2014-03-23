package cs2340.android.Presenters;

import java.io.Serializable;

import android.content.Intent;
import cs2340.android.Activities.AccountActivity;
import cs2340.android.Model.AccountModel;
import cs2340.android.Views.SpendingReportParametersView;

public class SpendingReportParametersPresenter {

	AccountModel model;
	SpendingReportParametersView view;
	
	public SpendingReportParametersPresenter(AccountModel model, SpendingReportParametersView view) {
		this.model = model;
		this.view = view;
	}
	
	public void goToReport() {
		view.goToReport(model);
	}
	
	public void back() {
		view.goToAccount(model);
	}
}
