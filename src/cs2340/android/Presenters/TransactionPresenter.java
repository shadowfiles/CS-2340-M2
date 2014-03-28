package cs2340.android.Presenters;

import cs2340.android.Activities.TransactionActivity;
import cs2340.android.Model.AccountModel;

public class TransactionPresenter {

	private AccountModel model;
	private TransactionActivity view;
	
	public TransactionPresenter(AccountModel model, TransactionActivity view) {
		this.model = model;
		this.view = view;
	}
	
	public void submit() {
		if (view.withdrawlRadioSet() && view.depositlRadioSet()) {
			//error message
		} //FIX DATE
		else if (view.withdrawlRadioSet()) {
			model.makeWithdrawl(view.getDate(), view.getDate(), view.getCatagory(),
					view.getAmount(), null);
			view.goToAccount(model);
		} else if (view.depositlRadioSet()) {
			model.makeDeposit(view.getDate(), view.getDate(), view.getCatagory(),
					view.getAmount(), null);
			view.goToAccount(model);
		} else {
			//error message
		}
		
		
	}
	
	public void back() {
		view.goToAccount(model);
	}
	
	
}
