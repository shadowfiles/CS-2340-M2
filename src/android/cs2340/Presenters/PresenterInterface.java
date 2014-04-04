package android.cs2340.Presenters;

//You can do all this using the interfaces I set up. You do not need anything from 
//any of the other team mates.

//to start, create a class in presenter package called either.
// -AddAccountPagePresenter
// -UserPagePresenter
//from there implement the onClick for each page. USING 
//ONLY MODEL AND VIEW METHOD CALLS (see other presenters)
//FOR UserPage
//onClickOne - goes to AddAccountPage
//onClickTwo - Logout and return to IntroPage(FullscreenActivity)
//For AddAccount
//onClickOne - BackButton (just goes to UserPage, and does not create account
//onClickTwo - Create Account, and return to UserPage

public interface PresenterInterface {
    void onClickOne();

    void onClickTwo();
}
