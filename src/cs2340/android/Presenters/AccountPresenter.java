package cs2340.android.Presenters;

import cs2340.android.Activities.AccountActivity;
import cs2340.android.Model.AccountModel;

public class AccountPresenter {

	AccountModel model;
	AccountActivity view;
	
	public AccountPresenter(AccountModel model, AccountActivity view) {
		this.model = model;
		this.view = view;
	}
	
	public void setbalance() {
		double amount = model.getBalance();
		view.setamount("" + amount);
	}
	
	public void goToTransaction() {
		view.goToTransaction(model);
	}
	
	public void goToCreateSpendingReport() {
		view.goToCreateSpendingReport();
	}
	
	public void back() {
		view.goBack(model.getOwner());
	}
}
