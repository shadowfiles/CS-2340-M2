package android.cs2340.Presenters;

import android.cs2340.Activities.TransactionActivity;
import android.cs2340.Model.AccountModel;
import android.cs2340.Persistence.AccountDataTable;

/**
 * Presenter for the page to view transactions. 
 * @author tiff
 *
 */
public class TransactionPresenter {

    /**
     * The model being used.
     */
    private AccountModel model;
    
    /**
     * The view being used.
     */
    private TransactionActivity view;
    
    /**
     * The data source for accounts.
     */
    private AccountDataTable dataSource;

    /**
     * The constructor for the presenter.
     * @param m The model being used.
     * @param v The view being used.
     */
    public TransactionPresenter(AccountModel m, TransactionActivity v) {
        this.model = m;
        this.view = v;
        this.dataSource = new AccountDataTable(view);
    }

    /**
     * What happens when you submit the new transaction. 
     */
    public void submit() {
        if (view.withdrawalRadioSet() && view.depositRadioSet()) {
            
        } else if (!(view.withdrawalRadioSet() || view.depositRadioSet())) {
            // error
        } else {
            // Success
            boolean isDeposit = view.depositRadioSet();
            dataSource.createTransaction(view.getDate(), view.getCategory(),
                    view.getAmount(), model, isDeposit);
            view.goToAccount(model);
        }
    }

    /**
     * Going back to the account page.
     */
    public void back() {
        view.goToAccount(model);
    }

}
