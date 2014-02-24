package cs2340.andriod.Views;

import cs2340.andriod.Presenters.PresenterInterface;

public interface RegisterPageView {

	String getUsername();
	String getPassOne();
	String getPassTwo();
	void setInfoErrorMessage(String text);
	void attemptRegisterCallback(PresenterInterface listener);
	void goToIntro();
	void clearInfo();
	
}
