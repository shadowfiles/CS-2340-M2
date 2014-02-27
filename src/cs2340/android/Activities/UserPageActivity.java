package cs2340.android.Activities;

import cs2340.android.Presenters.IntroPagePresenter;
import cs2340.android.Presenters.PresenterInterface;
import cs2340.android.Views.UserPageView;
import android.app.Activity;
import cs2340.andriod.cs_2340_water_s_warriors.R;


public class UserPageActivity extends Activity implements UserPageView{

	private PresenterInterface listener;
	private IntroPagePresenter presenter;
	
	@Override
	public void attemptUserCallback(PresenterInterface lsnr) {
		// TODO Auto-generated method stub
		listener=lsnr;
	}

	@Override
	public void AddAccountButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LogoutButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToAddAccount() {
		// TODO Auto-generated method stub
		listener.onClickOne();
	}

	@Override
	public void goToIntro() {
		// TODO Auto-generated method stub
		listener.onClickTwo();
	}

}
