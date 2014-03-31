package cs2340.android.Presenters;

import cs2340.android.Activities.TransactionActivity;
import cs2340.android.Model.AccountModel;
import cs2340.android.Persistence.AccountDataSource;

public class TransactionPresenter {

	private AccountModel model;
	private TransactionActivity view;
	private AccountDataSource dataSource;
	
	public TransactionPresenter(AccountModel model, TransactionActivity view) {
		this.model = model;
		this.view = view;
		this.dataSource = new AccountDataSource(view);
	}
	
	public void submit() {
		if (view.withdrawalRadioSet() && view.depositRadioSet()) {
			//error message
		} else if (!view.withdrawalRadioSet() && !view.depositRadioSet() ) {
			// error
		} else {
			// Success
			boolean isDeposit = view.depositRadioSet();
			dataSource.createTransaction(view.getDate(), view.getCategory(), 
					view.getAmount(), model, isDeposit);
			view.goToAccount(model);
		} 
		
		
	}
	
	public void back() {
		view.goToAccount(model);
	}
	
	
}
