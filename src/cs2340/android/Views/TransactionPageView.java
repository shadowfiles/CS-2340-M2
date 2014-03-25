package cs2340.android.Views;

import java.util.Collection;

import cs2340.android.Model.AccountModel;

public interface TransactionPageView {

	double getAmount();
	String getCatagory();
	String getDate();
	boolean withdrawlRadioSet();
	boolean depositlRadioSet();
	void goToAccount(AccountModel acount);
	void setExpandableViewValues(Collection<String> catagories);
	
}
