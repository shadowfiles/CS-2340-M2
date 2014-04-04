package android.cs2340.Views;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.ReportModel;
import android.cs2340.Model.UserModel;

public interface SpendingReportParametersView {

	void goToUserPage(UserModel user);
	public String getStartDate();
	public String getEndDate();
	void goToReport(ReportModel report);
	
}

