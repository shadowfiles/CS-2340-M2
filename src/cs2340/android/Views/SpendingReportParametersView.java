package cs2340.android.Views;

import cs2340.android.Model.AccountModel;
import cs2340.android.Model.ReportModel;
import cs2340.android.Model.UserModel;

public interface SpendingReportParametersView {

	void goToUserPage(UserModel user);
	public String getStartDate();
	public String getEndDate();
	void goToReport(ReportModel report);
	
}

