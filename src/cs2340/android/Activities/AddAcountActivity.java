package cs2340.android.Activities;

import cs2340.andriod.cs_2340_water_s_warriors.R;
import cs2340.andriod.cs_2340_water_s_warriors.R.layout;
import cs2340.andriod.cs_2340_water_s_warriors.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;
import cs2340.android.Presenters.PresenterInterface;
import cs2340.android.Views.AddAccountPageView;

public class AddAcountActivity extends Activity implements AddAccountPageView {
	
	private PresenterInterface listener;
	private EditText fullName;
	private EditText displayName;
	private EditText balance;
	private EditText interest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_acount);
		
		fullName = (EditText)findViewById(R.id.fullNameAddAccount);
		displayName = (EditText)findViewById(R.id.displayNameAddAccount);
		balance = (EditText)findViewById(R.id.balanceAddAccount);
		interest = (EditText)findViewById(R.id.interestAddAccount);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_acount, menu);
		return true;
	}

	public String getFullName() {
		return fullName.toString();
	}

	public String getDisplayName() {
		return displayName.toString();
	}

	public double getBalance() {
		return Double.parseDouble(balance.toString());
	}

	public double getInterest() {
		return Double.parseDouble(interest.toString());
	}

	public void attemptAddAccountCallback(PresenterInterface listener) {
		this.listener = listener;
	}

	//change dis pls
	//no is work yet
	public void goToUserPage() {
		Intent intent = new Intent(AddAcountActivity.this, FullscreenActivity.class);
		startActivity(intent);
	}

	public void createButton() {
		listener.onClickTwo();
	}

	@Override
	public void backButton() {
		listener.onClickOne();
	}

}
