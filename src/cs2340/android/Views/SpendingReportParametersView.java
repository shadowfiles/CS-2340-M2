package cs2340.android.Views;

import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;

public interface SpendingReportParametersView {

	void goToAccount(AccountModel account);
	void goToReport(UserModel user);
}
