package android.cs2340.Activities;


import android.app.Activity;
import android.content.Intent;
import android.cs2340.Presenters.IntroPagePresenter;
import android.cs2340.Views.IntroPageView;
import android.os.Bundle;
import android.view.View;
import android.cs2340.R;

/**
 * This class constructs the full screen(welcome screen) for the application.
 * @author Team 42
 *
 */
public class FullscreenActivity extends Activity implements IntroPageView{
	
	IntroPagePresenter presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen);
		
				presenter = new IntroPagePresenter(this);
	}
	 
	public void goLoginPage(View view){
		presenter.onClickLogin();
	}
	
	public void tranferPageLogin() {
		Intent intent = new Intent(FullscreenActivity.this, LoginActivity.class);
		startActivity(intent);
	}
	
	public void goRegisterPage(View view) {
		presenter.onClickReg();
	}
	
	public void transferPageReg() {
		Intent intent = new Intent(FullscreenActivity.this, RegisterActivity.class);
		startActivity(intent);
	}

}