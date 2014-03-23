package cs2340.android.Activities;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import cs2340.andriod.cs_2340_water_s_warriors.R;
import cs2340.android.Model.AccountModel;
import cs2340.android.Presenters.AccountPresenter;
import cs2340.android.Presenters.TransactionPresenter;
import cs2340.android.Views.TransactionPageView;

public class TransactionActivity extends Activity implements TransactionPageView {

	EditText amount;
	EditText source;
	EditText date;
	RadioButton deposit;
	RadioButton withdrawl;	
	TransactionPresenter presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transaction);
		
		presenter = new TransactionPresenter((AccountModel) getIntent().getExtras().getSerializable("theAccount"), this);
		amount = (EditText) findViewById(R.id.transaction_amount_field);
		source = (EditText) findViewById(R.id.transaction_source_field);
		date = (EditText) findViewById(R.id.transaction_date_field);
		deposit = (RadioButton) findViewById(R.id.deposit_radio);
		withdrawl = (RadioButton) findViewById(R.id.withdraw_radio);
		
		
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
	public String getSource() {
		return source.getText().toString();
	}

	@Override
	public String getDate() {
		return date.getText().toString();
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
	
}
