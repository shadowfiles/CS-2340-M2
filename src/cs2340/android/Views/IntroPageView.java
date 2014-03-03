package cs2340.android.Views;

import cs2340.android.Presenters.ListenerPresenterInterface;

public interface IntroPageView {

	void attemptIntroCallback(ListenerPresenterInterface listener);
	void transferPageReg();
	void tranferPageLogin();


}
