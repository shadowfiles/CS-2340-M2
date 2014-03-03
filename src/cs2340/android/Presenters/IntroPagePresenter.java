package cs2340.android.Presenters;

import cs2340.android.Views.IntroPageView;

public class IntroPagePresenter implements ListenerPresenterInterface {

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
