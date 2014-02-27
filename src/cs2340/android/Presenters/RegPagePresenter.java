package cs2340.android.Presenters;

import cs2340.android.Model.ListModel;
import cs2340.android.Views.RegisterPageView;

public class RegPagePresenter implements PresenterInterface {

	private RegisterPageView view;
	private ListModel model;
	
	public RegPagePresenter (ListModel m, RegisterPageView v) {
		view = v;
		model = m;
		view.attemptRegisterCallback(this);
	}
	

	@Override
	public void onClickOne() {
		model.addUser(view.getUsername(), view.getPassOne(), view.getPassTwo());
		view.goToIntro();
	}


	@Override
	public void onClickTwo() {
		//view.clearInfo();
		view.goToIntro();		
	}
	

}
