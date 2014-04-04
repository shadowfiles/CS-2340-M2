package android.cs2340.Views;

import android.cs2340.Model.UserModel;
import android.view.View;

public interface AddAccountPageView {

    // You can do all this using the interfaces I set up. You do not need
    // anything from
    // any of the other team mates.

    // to start, create a blankActivity called "AddAccountActivity" go from
    // implement this interface. If you think anything is missing please text me

    // returns specified variable (will be in a EditText [made in the layout])
    String getFullName();

    String getDisplayName();

    double getBalance();

    double getInterest();

    // sets listener using presenter
    void goToUserPage(UserModel model);

    void createButton(View view);

    void backButton(View view);

    // onClick listener (must set these on buttons that
    // you want to relate to them).
    // void createButton(); //onClickTwo
    // void backButton(); //onClickOne

    // Just here for later. Not necessary to implement
    // unless you are feeling ambitious.
    // void setErrorMessage();

}
