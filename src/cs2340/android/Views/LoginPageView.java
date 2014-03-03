package cs2340.android.Views;

import cs2340.android.Model.User;
import cs2340.android.Model.UserModel;
import cs2340.android.Presenters.ListenerPresenterInterface;

public interface LoginPageView {
	String getUsername();
	String getPassword();
	void setErrorMessage(String text);
	void attemptLoginCallback(ListenerPresenterInterface listener);
	void goToSuccess(UserModel passedObject); 
	void goToIntro();
}
