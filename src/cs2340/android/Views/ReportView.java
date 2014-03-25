package cs2340.android.Views;

import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;

public interface ReportView {

	void goToUserPage(UserModel user);
	void DrawReport(String writenReport);
	
}
