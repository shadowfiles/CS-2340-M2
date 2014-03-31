package cs2340.android.Activities;

import java.io.Serializable;
import java.util.Collection;

import cs2340.android.R;
import cs2340.android.R.layout;
import cs2340.android.R.menu;
import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;
import cs2340.android.Presenters.AccountPresenter;
import cs2340.android.Views.AccountPageView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 * This class describes the methods needed for the 
 * activity of account page. 
 * 
 * @author Team 42
 */
public class AccountActivity extends Activity implements AccountPageView{

	AccountPresenter presenter;
	private TextView amount;
	private LinearLayout transactionlist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
	
		presenter = new AccountPresenter((AccountModel) getIntent().getExtras().getSerializable("theAccount"), this);
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

	public void makeTransaction(View view) {
		presenter.goToTransaction();
	}
	
	public void goBack(View view) {
		presenter.back();
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

	@Override
	public void goBack(UserModel user) {
		Intent intent = new Intent(this, UserPageActivity.class);
		intent.putExtra("theUser", (Serializable)user);
		startActivity(intent);		
	}

	public void drawTransations(Collection<String> writable) {
		for (String s : writable) {
			final TextView text = new TextView(this);
			text.setText(s);
			transactionlist.addView(text, 0);
		}
	}

}
