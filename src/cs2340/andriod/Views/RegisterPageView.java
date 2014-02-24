package cs2340.andriod.Views;

public interface RegisterPageView {

	String getUsername();
	String getPassOne();
	String getPassTwo();
	void setInfoErrorMessage(String text);
	void attemptRegisterCallback(ClickListener listener);
	void goToIntro();
	void clearInfo();
	
}
