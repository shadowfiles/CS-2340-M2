package android.cs2340.Presenters;

import android.cs2340.Activities.AccountActivity;
import android.cs2340.Model.AccountModel;

public class AccountPresenter {

    AccountModel model;
    AccountActivity view;

    public AccountPresenter(AccountModel model, AccountActivity view) {
        this.model = model;
        this.view = view;
    }

    public void setbalance() {
        double amount = model.getBalance();
        view.setAmount("" + amount);
    }

    public void goToTransaction() {
        view.goToTransaction(model);
    }

    public void back() {
        view.goBack(model.getOwner());
    }

    public void drawTransactions() {
        view.drawTransactions(model.getTransactionWritables());

    }
}
