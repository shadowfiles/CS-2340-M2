package android.cs2340.Views;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.UserModel;

public interface ReportView {

	void goToUserPage(UserModel user);
	void DrawReport(String writenReport);
	
}
