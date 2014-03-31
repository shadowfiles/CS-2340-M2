package cs2340.android.Views;

import java.util.Collection;

import cs2340.android.Model.AccountModel;

public interface TransactionPageView {

	double getAmount();
	String getCategory();
	String getDate();
	boolean withdrawalRadioSet();
	boolean depositRadioSet();
	void goToAccount(AccountModel acount);
	void setExpandableViewValues(Collection<String> categories);
	
}
