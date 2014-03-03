package cs2340.android.Presenters;
import cs2340.android.Model.UserModel;
import cs2340.android.Views.UserPageView;

public class UserPagePresenter implements ListenerPresenterInterface {
	
	private UserPageView view;
	private UserModel model;
	
	public UserPagePresenter (UserModel m, UserPageView v) {
		view = v;
		model = m;
		view.attemptUserCallback(this);
	}

	@Override
	public void onClickOne() {
		view.goToAddAccount(model); //TODO get account
	}

	@Override
	public void onClickTwo() {
		//CODE TO MAKE IT SO THAT WHEN YOU PRESS BACK YOU CAN NOT RETURN HERE
		view.goToIntro();
	}
}