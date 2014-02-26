package cs2340.android.Views;

import cs2340.android.Presenters.PresenterInterface;

public interface RegisterPageView {

	String getUsername();
	String getPassOne();
	String getPassTwo();
	void setInfoErrorMessage(String text);
	void attemptRegisterCallback(PresenterInterface listener);
	void goToIntro();
	void clearInfo();
	
}
