package cs2340.android.Presenters;
import cs2340.android.Views.UserPageView;

public class UserPagePresenter implements PresenterInterface {
	
	private UserPageView view;
	
	public UserPagePresenter (UserPageView v) {
		view = v;
	}

	@Override
	public void onClickOne() {
		view.goToAddAccount();
	}

	@Override
	public void onClickTwo() {
		view.LogoutButton();
		view.goToIntro();
	}
}