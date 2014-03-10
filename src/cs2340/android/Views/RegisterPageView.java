package cs2340.android.Views;


public interface RegisterPageView {

	String getUsername();
	String getPassOne();
	String getPassTwo();
	void setInfoErrorMessage(String text);
	void goToIntro();
	void clearInfo();
	
}
