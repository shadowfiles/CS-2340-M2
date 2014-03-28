package cs2340.android.Presenters;

import cs2340.android.Model.AccountModel;
import cs2340.android.Model.ReportModel;
import cs2340.android.Model.UserModel;
import cs2340.android.Views.ReportView;

public class ReportPresenter {
	ReportModel model;
	ReportView view;
	
	public ReportPresenter(ReportModel model, ReportView view) {
		this.model = model;
		this.view = view;
	}
	
	public void back() {
		view.goToUserPage(model.getUser());
	}
	
	public void drawWritenReport() {
		view.DrawReport(model.getWritenReport());
	}
}
