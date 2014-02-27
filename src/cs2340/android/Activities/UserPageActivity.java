package cs2340.android.Activities;

import cs2340.andriod.cs_2340_water_s_warriors.R;

import cs2340.android.Activities.UserPageActivity;
import cs2340.android.Presenters.PresenterInterface;
import cs2340.android.Presenters.UserPagePresenter;
import cs2340.android.Views.UserPageView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class UserPageActivity extends Activity implements UserPageView{

	private PresenterInterface listener;
	private UserPagePresenter presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_page);
		presenter = new UserPagePresenter(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_page, menu);
		return true;
	}
	
	@Override
	public void attemptUserCallback(PresenterInterface lsnr) {
		// TODO Auto-generated method stub
		listener=lsnr;
	}

	@Override
	public void goToAddAccount() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(UserPageActivity.this, AddAcountActivity.class);
		startActivity(intent);
	}

	@Override
	public void goToIntro() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(UserPageActivity.this, FullscreenActivity.class);
		startActivity(intent);
	}
	
	@Override
	public void AddAccountButton() {
		// TODO Auto-generated method stub
		listener.onClickOne();
	}

	@Override
	public void LogoutButton() {
		// TODO Auto-generated method stub
		listener.onClickTwo();
	}
	

}
