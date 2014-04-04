package android.cs2340.Presenters;

import android.cs2340.Views.IntroPageView;

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
