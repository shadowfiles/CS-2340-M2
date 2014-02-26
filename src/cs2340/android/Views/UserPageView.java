package cs2340.android.Views;

import cs2340.android.Presenters.PresenterInterface;

public interface UserPageView {
	
	//You can do all this using the interfaces I set up. You do not need anything from 
	//any of the other team mates.
	
	//to start, create a blankActivity called "UserPageActivity" go from 
	//implement this interface. If you think anything is missing please text me.

	void attemptUserCallback(PresenterInterface lsnr);
	
	//onClick listener (must set these on buttons that 
	//you want to relate to them). 
	void AddAccountButton();	//onClickOne
	void LogoutButton();		//onClickTwo
		
	void goToAddAccount();
	//DO LATER void logoutAndReturnToIntro();
}
