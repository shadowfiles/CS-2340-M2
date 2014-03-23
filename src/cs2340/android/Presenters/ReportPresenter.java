package cs2340.android.Presenters;

import cs2340.android.Model.AccountModel;
import cs2340.android.Views.ReportView;

public class ReportPresenter {
	AccountModel model;
	ReportView view;
	
	public ReportPresenter(AccountModel model, ReportView view) {
		this.model = model;
		this.view = view;
	}
	
	public void back() {
		view.goToAccount(model);
	}
}
