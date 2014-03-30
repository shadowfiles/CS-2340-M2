package cs2340.android.Activities;

import java.io.Serializable;

import cs2340.android.R;
import cs2340.android.R.layout;
import cs2340.android.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import cs2340.android.Model.UserList;
import cs2340.android.Model.UserModel;
import cs2340.android.Presenters.AddAccountPresenter;
import cs2340.android.Views.AddAccountPageView;

public class AddAccountActivity extends Activity implements AddAccountPageView {
	
	private AddAccountPresenter presenter;
	private EditText fullName;
	private EditText displayName;
	private EditText balance;
	private EditText interest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_acount);
		
		presenter = new AddAccountPresenter((UserModel) getIntent().getExtras().getSerializable("theUser"), this);
		//display accounts
		
		fullName = (EditText)findViewById(R.id.fullNameAddAccount);
		displayName = (EditText)findViewById(R.id.displayNameAddAccount);
		balance = (EditText)findViewById(R.id.balanceAddAccount);
		interest = (EditText)findViewById(R.id.interestAddAccount);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_acount, menu);
		return true;
	}

	public String getFullName() {
		return fullName.getText().toString();
	}

	public String getDisplayName() {
		return displayName.getText().toString();
	}

	public double getBalance() {
		return Double.parseDouble(balance.getText().toString());
	}

	public double getInterest() {
		return Double.parseDouble(interest.getText().toString());
	}

	public void goToUserPage(UserModel theUser) {
		Intent intent = new Intent(AddAccountActivity.this, UserPageActivity.class);
		intent.putExtra("theUser", (Serializable) theUser);
		startActivity(intent);
	}

	public void createButton(View view) {
		presenter.onClickCreate();
	}

	public void backButton(View view) {
		presenter.onClickBack();
	}

}
