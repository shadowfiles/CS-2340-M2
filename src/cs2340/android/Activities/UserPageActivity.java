package cs2340.android.Activities;

import java.io.Serializable;
import java.util.Collection;

import cs2340.andriod.cs_2340_water_s_warriors.R;

import cs2340.android.Activities.UserPageActivity;
import cs2340.android.Model.Account;
import cs2340.android.Model.UserModel;
import cs2340.android.Presenters.ListenerPresenterInterface;
import cs2340.android.Presenters.UserPagePresenter;
import cs2340.android.Views.UserPageView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class UserPageActivity extends Activity implements UserPageView{

	private ListenerPresenterInterface listener;
	private UserPagePresenter presenter;
	private TextView accountdisplay1;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_page);
		
		presenter = new UserPagePresenter((UserModel) getIntent().getExtras().getSerializable("theUser"), this);
		
		//PLEASE FIX THIS SHIT
		UserModel user = (UserModel) getIntent().getExtras().getSerializable("theUser");
		
		accountdisplay1 = (TextView) findViewById(R.id.account1);

		Collection<Account> acnts = user.getAccounts();
		
		for (Account a: acnts) {
			if (a == null){
				break;
			}
			accountdisplay1.setText(a.getDisplayName() + " -- $" + a.getBalance());
		}
		
		//DOWN TO HERE
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.user_page, menu);
		return true;
	}
	
	@Override
	public void attemptUserCallback(ListenerPresenterInterface lsnr) {
		listener = lsnr;
	}

	public void addAccountButton(View view) {
		listener.onClickOne();
	}

	
	public void logoutButton(View view) {
		listener.onClickTwo();
	}

	@Override
	public void goToAddAccount(UserModel theUser) {
		Intent intent = new Intent(UserPageActivity.this, AddAcountActivity.class);
		intent.putExtra("theUser", (Serializable) theUser);
		startActivity(intent);
	}

	@Override
	public void goToIntro() {
		Intent intent = new Intent(UserPageActivity.this, FullscreenActivity.class);
		startActivity(intent);
	}

}
