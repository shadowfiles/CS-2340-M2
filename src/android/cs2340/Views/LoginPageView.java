package android.cs2340.Views;

import android.cs2340.Model.UserModel;

public interface LoginPageView {
    String getUsername();

    String getPassword();

    void setErrorMessage(String text);

    void goToSuccess(UserModel passedObject);

    void goToIntro();
}
