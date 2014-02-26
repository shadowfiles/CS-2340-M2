package cs2340.android.Views;

import cs2340.android.Presenters.PresenterInterface;

public interface LoginPageView {
	String getUsername();
	String getPassword();
	void setErrorMessage(String text);
	void attemptLoginCallback(PresenterInterface listener);
	void goToSuccess(); 
}
