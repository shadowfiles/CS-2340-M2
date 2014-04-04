package android.cs2340.Activities;

import java.io.Serializable;
import java.util.Collection;

import android.cs2340.R;
import android.cs2340.R.layout;
import android.cs2340.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.cs2340.Model.AccountModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Presenters.AccountPresenter;
import android.cs2340.Views.AccountPageView;
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
public class AccountActivity extends Activity implements AccountPageView {

    AccountPresenter presenter;
    private TextView amount;
    private LinearLayout transactionlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        presenter = new AccountPresenter((AccountModel) getIntent().getExtras()
                .getSerializable("theAccount"), this);
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

    @Override
    public void makeTransaction(View view) {
        presenter.goToTransaction();
    }

    @Override
    public void goBack(View view) {
        presenter.back();
    }

    @Override
    public void setAmount(String balance) {
        amount.setText(balance);
    }

    @Override
    public void goToTransaction(AccountModel account) {
        Intent intent = new Intent(this, TransactionActivity.class);
        intent.putExtra("theAccount", (Serializable) account);
        startActivity(intent);
    }

    @Override
    public void goBack(UserModel user) {
        Intent intent = new Intent(this, UserPageActivity.class);
        intent.putExtra("theUser", (Serializable) user);
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
