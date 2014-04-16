package android.cs2340.Activities;

import java.io.Serializable;
import java.util.Collection;

import android.app.Activity;
import android.content.Intent;
import android.cs2340.Model.AccountModel;
import android.cs2340.Presenters.TransactionPresenter;
import android.cs2340.Views.TransactionPageView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.cs2340.R;

/**
 * This class construct the process of transaction.
 * 
 * @author Team 42
 * 
 */
public class TransactionActivity extends AbstractActivityFactory implements
        TransactionPageView {

    /**
     * User input for the amount of transaction.
     */
    EditText amount;
    
    /**
     * User input for a custom category for the transaction.
     */
    EditText other;
    
    /**
     * User input for one of the default categories.
     */
    RadioGroup category;
    
    /**
     * User input for the date of the transaction.
     */
    DatePicker date;
    
    /**
     * User input specifying the transaction is a deposit.
     */
    RadioButton deposit;
    
    /**
     * User input specifying the transaction is a withdrawal.
     */
    RadioButton withdrawal;
    
    /**
     * Presenter used by the view. 
     */
    TransactionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        presenter = new TransactionPresenter((AccountModel) getIntent()
                .getExtras().getSerializable(ACCOUNT_SERIAL_ID), this);
        amount = (EditText) findViewById(R.id.transaction_amount_field);
        category = (RadioGroup) findViewById(R.id.catagory_selector);
        date = (DatePicker) findViewById(R.id.transaction_date_field);
        deposit = (RadioButton) findViewById(R.id.deposit_radio);
        withdrawal = (RadioButton) findViewById(R.id.withdraw_radio);
        other = (EditText) findViewById(R.id.other);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.account, menu);
        return true;
    }

    /**
     * The hook for when the user clicks the make transaction button.
     * @param view This view.
     */
    public void makeTransaction(View view) {
        presenter.submit();
    }

    /**
     * The hook for when the user clicks the go back button.
     * @param view This view.
     */
    public void goBack(View view) {
        presenter.back();
    }

    @Override
    public double getAmount() {
        return Double.parseDouble(amount.getText().toString());
    }

    @Override
    public String getCategory() {
        String ret = ((RadioButton) findViewById(category
                .getCheckedRadioButtonId())).getText().toString();
        if (ret.equals("Other")) {
            ret = other.getText().toString();
        }
        return ret;
    }

    @Override
    public String getDate() {
        String dateFormat = "%d/%d/%d";
        return String.format(dateFormat, (1 + date.getMonth()),
                date.getDayOfMonth(), date.getYear());
    }

    @Override
    public boolean withdrawalRadioSet() {
        return withdrawal.isChecked();
    }

    @Override
    public boolean depositRadioSet() {
        return deposit.isChecked();
    }

    @Override
    public void goToAccount(AccountModel acount) {
        Intent intent = new Intent(this, AccountActivity.class);
        intent.putExtra(ACCOUNT_SERIAL_ID, (Serializable) acount);
        startActivity(intent);
    }

    @Override
    public void setExpandableViewValues(Collection<String> catagories) {

    }

}
