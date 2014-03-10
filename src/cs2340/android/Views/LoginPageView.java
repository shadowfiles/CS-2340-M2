package cs2340.android.Views;

import cs2340.android.Model.User;
import cs2340.android.Model.UserModel;

public interface LoginPageView {
	String getUsername();
	String getPassword();
	void setErrorMessage(String text);
	void goToSuccess(UserModel passedObject); 
	void goToIntro();
}
