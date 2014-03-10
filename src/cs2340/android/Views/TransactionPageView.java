package cs2340.android.Views;

import cs2340.android.Model.AccountModel;

public interface TransactionPageView {

	double getAmount();
	String getSource();
	String getDate();
	boolean withdrawlRadioSet();
	boolean depositlRadioSet();
	void goToAccount(AccountModel acount);
	
}
