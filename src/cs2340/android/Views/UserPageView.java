package cs2340.android.Views;

import cs2340.android.Model.AccountModel;
import cs2340.android.Model.UserModel;

public interface UserPageView {
	
	//You can do all this using the interfaces I set up. You do not need anything from 
	//any of the other team mates.
	
	//to start, create a blankActivity called "UserPageActivity" go from 
	//implement this interface. If you think anything is missing please text me.

	
	//onClick listener (must set these on buttons that 
	//you want to relate to them). 
	//void addAccountButton();	//onClickOne
	//void logoutButton();		//onClickTwo
	void goToAddAccount(UserModel theUser);
	//DO LATER void logoutAndReturnToIntro();
	void goToIntro();
	void goToAccount(AccountModel account);
	void drawAccount(String name, double balance);


}
