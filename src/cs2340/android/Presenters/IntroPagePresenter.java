package cs2340.android.Presenters;

import cs2340.android.Views.IntroPageView;

public class IntroPagePresenter {

	private IntroPageView view;
	
	public IntroPagePresenter(IntroPageView v) {
		view = v;
		//view.attemptIntroCallback(this);
	}

	public void onClickLogin() {
		view.tranferPageLogin();
		
	}

	public void onClickReg() {
		view.transferPageReg();
	}

}
