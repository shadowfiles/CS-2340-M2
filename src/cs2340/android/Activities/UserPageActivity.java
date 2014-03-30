package cs2340.android.Activities;

import java.io.Serializable;
import java.util.Collection;

import cs2340.android.R;

import cs2340.android.Activities.UserPageActivity;
import cs2340.android.Model.Account;
import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;
import cs2340.android.Presenters.UserPagePresenter;
import cs2340.android.Views.UserPageView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class UserPageActivity extends Activity implements UserPageView {

	private UserPagePresenter presenter;
	private LinearLayout accountlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_page);

		presenter = new UserPagePresenter((UserModel) getIntent().getExtras()
				.getSerializable("theUser"), this);
		accountlist = (LinearLayout) findViewById(R.id.account_list);
		presenter.drawAccounts();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.user_page, menu);
		return true;
	}

	@Override
	public void drawAccounts(Collection<String> writable) {
		for (String s : writable) {
			final Button button = new Button(this);
			button.setText(s);
			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View view) {
					presenter.onClickAccount(button.getText().toString());
				}
			});
			accountlist.addView(button, 0);
		}
	}

	public void addAccountButton(View view) {
		presenter.onClickAddAccount();
	}
	
	public void createSpendingReport(View view) {
		presenter.goToCreateSpendingReport();
	}

	public void logoutButton(View view) {
		presenter.onClickLogout();
	}

	@Override
	public void goToAddAccount(UserModel theUser) {
		Intent intent = new Intent(UserPageActivity.this,
				AddAccountActivity.class);
		intent.putExtra("theUser", (Serializable) theUser);
		startActivity(intent);
	}

	//DELETE VIEW ON GOT TO INTRO
	@Override
	public void goToIntro() {
		Intent intent = new Intent(UserPageActivity.this,
				FullscreenActivity.class);
		startActivity(intent);
	}

	public void goToCreateSpendingReport(UserModel user) {
		Intent intent = new Intent(this, SpendingReportParametersActivity.class);
		intent.putExtra("theUser", (Serializable)user);
		startActivity(intent);		
	}
	
	@Override
	public void goToAccount(AccountModel account) {
		Intent intent = new Intent(UserPageActivity.this, AccountActivity.class);
		intent.putExtra("theAccount", (Serializable) account);
		startActivity(intent);
	}

}
