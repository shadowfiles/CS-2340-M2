package cs2340.andriod.Presenters;

import cs2340.andriod.Views.IntroPageView;
import cs2340.andriod.Views.LoginPageView;

public class IntroPagePresenter implements PresenterInterface {

	private IntroPageView view;
	
	public IntroPagePresenter(IntroPageView v) {
		view = v;
		view.attemptIntroCallback(this);
	}

	@Override
	public void onClickOne() {
		view.tranferPageLogin();
		
	}

	@Override
	public void onClickTwo() {
		view.transferPageReg();
	}

}
