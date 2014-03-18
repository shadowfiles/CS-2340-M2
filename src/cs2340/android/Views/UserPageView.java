package cs2340.android.Views;

import java.util.Collection;

import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;

public interface UserPageView {
	
	
	void goToAddAccount(UserModel theUser);
	void goToIntro();
	void goToAccount(AccountModel account);
	void drawAccounts(Collection<String> writable);


}
