package cs2340.andriod.Views;

import cs2340.andriod.Presenters.PresenterInterface;

public interface AddAccountPageView {
	
	//You can do all this using the interfaces I set up. You do not need anything from 
	//any of the other team mates.
	
	//to start, create a blankActivity called "AddAccountActivity" go from 
	//implement this interface. If you think anything is missing please text me

	//returns specified variable (will be in a EditText [made in the layout])
	String getFullName();
	String getDisplayName();
	String getBalance();
	String getIntrest();
	
	//sets listener using presenter
	void attemptAddAccountCallback(PresenterInterface lsnr);
	void goToUserPage();
	
	//onClick listener (must set these on buttons that 
	//you want to relate to them). 
	void createButton();	//onClickTwo
	void backButton();		//onClickOne
	
	//Just here for later. Not necessary to implement 
	//unless you are feeling ambitious. 
	//void setErrorMessage();
	
}
