package cs2340.andriod.Presenters;

import cs2340.andriod.Model.Model;
import cs2340.andriod.Views.LoginPageView;
import cs2340.andriod.Views.RegisterPageView;

public class RegPagePresenter implements PresenterInterface {

	private RegisterPageView view;
	private Model model;
	
	public RegPagePresenter (Model m, RegisterPageView v) {
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
