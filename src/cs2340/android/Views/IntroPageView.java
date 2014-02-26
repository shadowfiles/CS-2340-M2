package cs2340.android.Views;

import cs2340.android.Presenters.PresenterInterface;

public interface IntroPageView {

	void attemptIntroCallback(PresenterInterface listener);
	void transferPageReg();
	void tranferPageLogin();


}
