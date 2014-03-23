package cs2340.android.Views;

import java.util.Collection;

import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;

public interface AccountPageView {

	void goBack(UserModel user);
	void goToCreateSpendingReport(AccountModel account);
	void goToTransaction(AccountModel account);
	void drawTransations(Collection<String> writable);
}
