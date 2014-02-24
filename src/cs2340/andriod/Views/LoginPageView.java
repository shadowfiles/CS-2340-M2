package cs2340.andriod.Views;

import cs2340.andriod.Presenters.PresenterInterface;

public interface LoginPageView {
	String getUsername();
	String getPassword();
	void setErrorMessage(String text);
	void attemptLoginCallback(PresenterInterface listener);
	void goToSuccess(); 
}
