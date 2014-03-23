package cs2340.android.Activities;

import java.io.Serializable;

import cs2340.andriod.cs_2340_water_s_warriors.R;
import cs2340.andriod.cs_2340_water_s_warriors.R.layout;
import cs2340.andriod.cs_2340_water_s_warriors.R.menu;
import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;
import cs2340.android.Presenters.AccountPresenter;
import cs2340.android.Views.AccountPageView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AccountActivity extends Activity implements AccountPageView{

	AccountPresenter presenter;
	private TextView amount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
	
		presenter = new AccountPresenter((AccountModel) getIntent().getExtras().getSerializable("theAccount"), this);
		amount = (TextView) findViewById(R.id.amount_in_account);
		
		presenter.setbalance();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}

	public void makeTransaction(View view) {
		presenter.goToTransaction();
	}
	
	public void goBack(View view) {
		presenter.back();
	}
	
	public void createSpendingReport(View view) {
		presenter.goToCreateSpendingReport();
	}
	
	public void setamount(String balance) {
		amount.setText(balance);
	}
	
	@Override
	public void goToTransaction(AccountModel account) {
		Intent intent = new Intent(this, TransactionActivity.class);
		intent.putExtra("theAccount", (Serializable)account);
		startActivity(intent);		
	}
	
	public void goToCreateSpendingReport() {
		Intent intent = new Intent(this, SpendingReportParametersActivity.class);
		startActivity(intent);		
	}

	@Override
	public void goBack(UserModel user) {
		Intent intent = new Intent(this, UserPageActivity.class);
		intent.putExtra("theUser", (Serializable)user);
		startActivity(intent);		
	}

}
