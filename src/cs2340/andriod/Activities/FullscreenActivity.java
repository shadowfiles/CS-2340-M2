package cs2340.andriod.Activities;


import cs2340.andriod.Model.Model;
import cs2340.andriod.Model.UserList;
import cs2340.andriod.Presenters.PresenterInterface;
import cs2340.andriod.Presenters.IntroPagePresenter;
import cs2340.andriod.Views.IntroPageView;
import cs2340.andriod.cs_2340_water_s_warrioirs.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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