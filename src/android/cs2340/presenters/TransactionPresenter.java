package android.cs2340.presenters;

import android.cs2340.activity.TransactionActivity;
import android.cs2340.model.AccountModel;
import android.cs2340.persistence.AccountDataTable;
import android.cs2340.persistence.AccountDataSource;

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
    private AccountDataSource source;

    /**
     * The constructor for the presenter.
     * @param m The model being used.
     * @param v The view being used.
     */
    public TransactionPresenter(long id, TransactionActivity v) {
        this.source = AccountDataTable.getSource();
        this.model = source.getAccount(id);
        this.view = v;
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
            
            // Adds the transaction to the database
            source.createTransaction(view.getDate(), view.getCategory(),
                    view.getAmount(), model, isDeposit);
            
            view.goToAccount(model.getId());
        }
    }

    /**
     * Going back to the account page.
     */
    public void back() {
        view.goToAccount(model.getId());
    }

}
