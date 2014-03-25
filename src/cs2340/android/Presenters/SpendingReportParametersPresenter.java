package cs2340.android.Presenters;

import java.io.Serializable;
import android.content.Intent;
import cs2340.android.Activities.AccountActivity;
import cs2340.android.Model.AccountModel;
import cs2340.android.Model.ReportModel;
import cs2340.android.Model.UserModel;
import cs2340.android.Views.SpendingReportParametersView;

public class SpendingReportParametersPresenter {


	UserModel model;
	SpendingReportParametersView view;
	
	public SpendingReportParametersPresenter(UserModel model, SpendingReportParametersView view) {
		this.model = model;
		this.view = view;
	}
	
	public void goToReport() {
		ReportModel repmod= model.getReport(view.getStartDate(), view.getEndDate());
		view.goToReport(repmod);
	}
	
	public void back() {
		view.goToUserPage(model);
	}
}
