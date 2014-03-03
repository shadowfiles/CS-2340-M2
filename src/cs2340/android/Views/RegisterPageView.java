package cs2340.android.Views;

import cs2340.android.Presenters.ListenerPresenterInterface;

public interface RegisterPageView {

	String getUsername();
	String getPassOne();
	String getPassTwo();
	void setInfoErrorMessage(String text);
	void attemptRegisterCallback(ListenerPresenterInterface listener);
	void goToIntro();
	void clearInfo();
	
}
