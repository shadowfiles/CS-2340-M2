package cs2340.android.Activities;

import java.io.Serializable;
import java.util.Collection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cs2340.android.R;
import cs2340.android.Model.AccountModel;
import cs2340.android.Presenters.AccountPresenter;
import cs2340.android.Presenters.TransactionPresenter;
import cs2340.android.Views.TransactionPageView;

public class TransactionActivity extends Activity implements TransactionPageView {

	EditText amount;
	EditText other;
	RadioGroup catagory;
	DatePicker date;
	RadioButton deposit;
	RadioButton withdrawl;	
	TransactionPresenter presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transaction);
		
		presenter = new TransactionPresenter((AccountModel) getIntent().getExtras().getSerializable("theAccount"), this);
		amount = (EditText) findViewById(R.id.transaction_amount_field);
		catagory = (RadioGroup) findViewById(R.id.catagory_selector);
		date = (DatePicker) findViewById(R.id.transaction_date_field);
		deposit = (RadioButton) findViewById(R.id.deposit_radio);
		withdrawl = (RadioButton) findViewById(R.id.withdraw_radio);
		other = (EditText) findViewById(R.id.other);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}

	public void makeTransaction (View view) {
		presenter.submit();
	}
	
	public void goBack (View view) {
		presenter.back();
	}
	
	@Override
	public double getAmount() {
		return Double.parseDouble(amount.getText().toString());
	}

	@Override
	public String getCatagory() {
		String ret = ((RadioButton) findViewById(catagory.getCheckedRadioButtonId())).getText().toString();
		if (ret.equals("Other")) {
			ret = other.getText().toString();
		}
		return ret;
	}

	@Override
	public String getDate() {
		return (date.getMonth()+1) + "/" + date.getDayOfMonth() + "/" + date.getYear();
	}

	@Override
	public boolean withdrawlRadioSet() {
		return withdrawl.isChecked();
	}

	@Override
	public boolean depositlRadioSet() {
		return deposit.isChecked();
	}

	@Override
	public void goToAccount(AccountModel acount) {
		Intent intent = new Intent(this, AccountActivity.class);
		intent.putExtra("theAccount",(Serializable)acount);
		startActivity(intent);			
	}

	@Override
	public void setExpandableViewValues(Collection<String> catagories) {

	}
	
}
