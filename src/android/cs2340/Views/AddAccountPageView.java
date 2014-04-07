package android.cs2340.Views;

import android.cs2340.Model.UserModel;

public interface AddAccountPageView {

    String getFullName();

    String getDisplayName();

    double getBalance();

    double getInterest();

    void goToUserPage(UserModel model);


    // onClick listener (must set these on buttons that
    // you want to relate to them).
    // void createButton(); //onClickTwo
    // void backButton(); //onClickOne

    // Just here for later. Not necessary to implement
    // unless you are feeling ambitious.
    // void setErrorMessage();

}
