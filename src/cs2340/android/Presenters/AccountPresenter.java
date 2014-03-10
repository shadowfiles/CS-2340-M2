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
		view.setamount("" + model.getBalance());
	}
	
	public void goToTransaction() {
		view.goToTransaction(model);
	}
	
	public void back() {
		view.goBack(model.getOwner());
	}
}
