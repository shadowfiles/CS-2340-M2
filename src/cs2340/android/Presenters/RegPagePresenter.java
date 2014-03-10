package cs2340.android.Presenters;

import cs2340.android.Model.ListModel;
import cs2340.android.Views.RegisterPageView;

public class RegPagePresenter {

	private RegisterPageView view;
	private ListModel model;
	
	public RegPagePresenter (ListModel m, RegisterPageView v) {
		view = v;
		model = m;
	}
	

	public void onClickReg() {
		model.addUser(view.getUsername(), view.getPassOne(), view.getPassTwo());
		view.goToIntro();
	}


	public void onClickBack() {
		view.goToIntro();		
	}
	

}
