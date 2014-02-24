package cs2340.andriod.Views;

public interface LoginPageView {
	String getUsername();
	String getPassword();
	void setErrorMessage(String text);
	void attemptLoginCallback(ClickListener listener);
	void goToSuccess(); 
}
