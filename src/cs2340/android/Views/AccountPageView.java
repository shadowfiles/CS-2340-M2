package cs2340.android.Views;

import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;

public interface AccountPageView {

	void goBack(UserModel user);
	void goToCreateSpendingReport();
	void goToTransaction(AccountModel account);
	
}
