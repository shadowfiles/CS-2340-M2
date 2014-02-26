package cs2340.andriod.Activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cs2340.android.Presenters.IntroPagePresenter;
import cs2340.android.Presenters.PresenterInterface;
import cs2340.android.Views.IntroPageView;
import cs2340.andriod.cs_2340_water_s_warriors.R;

public class FullscreenActivity extends Activity implements IntroPageView{
	
	PresenterInterface listener;
	IntroPagePresenter presenter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen);
				presenter = new IntroPagePresenter(this);
	}
	 
	public void goLoginPage(View view){
		listener.onClickOne();
	}
	
	public void tranferPageLogin() {
		Intent intent = new Intent(FullscreenActivity.this, LoginActivity.class);
		startActivity(intent);
	}
	
	public void goRegisterPage(View view) {
		listener.onClickTwo();
	}
	
	public void transferPageReg() {
		Intent intent = new Intent(FullscreenActivity.this, RegisterActivity.class);
		startActivity(intent);
	}

	@Override
	public void attemptIntroCallback(PresenterInterface lsn) {
		listener = lsn;
	}
}