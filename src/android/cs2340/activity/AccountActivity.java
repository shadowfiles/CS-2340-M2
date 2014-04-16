package android.cs2340.activity;

import java.util.Collection;

import android.cs2340.R;
import android.os.Bundle;
import android.content.Intent;
import android.cs2340.presenters.AccountPresenter;
import android.cs2340.views.AccountPageView;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * This class describes the methods needed for the activity of account page.
 * 
 * @author Team 42
 */
public class AccountActivity extends AbstractActivityFactory implements AccountPageView {

    /**
     * Presenter used by the view. 
     */
    AccountPresenter presenter;

    /**
     * Amount of balance displayed. 
     */
    private TextView amount;
    
    /**
     * List of all of the transactions in an account.
     */
    private LinearLayout transactionlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        presenter = new AccountPresenter(getExtras().getLong(ACCOUNT_SERIAL_ID), this);
        amount = (TextView) findViewById(R.id.amount_in_account);
        transactionlist = (LinearLayout) findViewById(R.id.transaction_activity);

        presenter.setbalance();
        presenter.drawTransactions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.account, menu);
        return true;
    }

    /**
     * Hook for when the user clicks the button to make a Transaction.
     * Goes to TransactionActivity.
     * @param view This view.
     */
    public void makeTransaction(View view) {
        presenter.goToTransaction();
    }

    /**
     * Hook for when the user clicks the back button.
     * @param view This view.
     */
    public void goBack(View view) {
        presenter.back();
    }

    @Override
    public void setAmount(String balance) {
        amount.setText(balance);
    }

    @Override
    public void goToTransaction(long accountId) {
        Intent intent = new Intent(this, TransactionActivity.class);
        intent.putExtra(ACCOUNT_SERIAL_ID, accountId);
        startActivity(intent);
    }

    @Override
    public void goBack(long userId) {
        Intent intent = new Intent(this, UserPageActivity.class);
        intent.putExtra(USER_SERIAL_ID, userId);
        startActivity(intent);
    }

    @Override
    public void drawTransactions(Collection<String> writable) {
        for (String s : writable) {
            final TextView text = new TextView(this);
            text.setText(s);
            transactionlist.addView(text, 0);
        }
    }

}
