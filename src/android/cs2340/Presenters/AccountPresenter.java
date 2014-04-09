package android.cs2340.Presenters;

import android.cs2340.Activities.AccountActivity;
import android.cs2340.Model.AccountModel;

/**
 * The presenter for acounts.
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
     * The constructor for the presenter. 
     * @param m The model used.
     * @param v The view used.
     */
    public AccountPresenter(AccountModel m, AccountActivity v) {
        this.model = m;
        this.view = v;
    }

    /**
     * Sets the balance of the view based on the model.  
     */
    public void setbalance() {
        double amount = model.getBalance();
        view.setAmount("" + amount);
    }

    /**
     * Changes the page to a transaction based on the model. 
     */
    public void goToTransaction() {
        view.goToTransaction(model);
    }

    /**
     * Goes back based on the model.
     */
    public void back() {
        view.goBack(model.getOwner());
    }

    /**
     * Shows transactions based on the model.
     */
    public void drawTransactions() {
        view.drawTransactions(model.getTransactionWritables());

    }
}
