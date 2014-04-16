package android.cs2340.presenters;

import android.cs2340.activity.AccountActivity;
import android.cs2340.model.AccountModel;
import android.cs2340.persistence.AccountDataSource;
import android.cs2340.persistence.AccountDataTable;


/**
 * The presenter for accounts.
 * @author tiff
 *
 */
public class AccountPresenter {

    /**
     * The model used by the presenter.
     */
    AccountModel model;
    
    /**
     * The view used by the presenter.
     */
    AccountActivity view;

    /**
     * The data source.
     */
    AccountDataSource source;

    /**
     * The constructor for the presenter. 
     * @param id The model used.
     * @param v The view used.
     */
    public AccountPresenter(long id, AccountActivity v) {
        this.source = AccountDataTable.getSource();
        this.model = source.getAccount(id);
        this.view = v;
    }

    /**
     * Sets the balance of the view based on the model.  
     */
    public void setbalance() {
        String amount = model.showBalance();
        view.setAmount(amount);
    }

    /**
     * Changes the page to a transaction based on the model. 
     */
    public void goToTransaction() {
        view.goToTransaction(model.getId());
    }

    /**
     * Goes back based on the model.
     */
    public void back() {
        view.goBack(model.getOwner().getId());
    }

    /**
     * Shows transactions based on the model.
     */
    public void drawTransactions() {
        view.drawTransactions(model.getTransactionWritables());

    }
}
