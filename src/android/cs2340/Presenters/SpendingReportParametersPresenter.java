package android.cs2340.Presenters;

import java.io.Serializable;

import android.content.Intent;
import android.cs2340.Activities.AccountActivity;
import android.cs2340.Model.AccountModel;
import android.cs2340.Model.ReportModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Views.SpendingReportParametersView;

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
