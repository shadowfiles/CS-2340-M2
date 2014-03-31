package cs2340.android.Presenters;

import cs2340.android.Model.UserListModel;
import cs2340.android.Views.RegisterPageView;

public class RegPagePresenter {

	private RegisterPageView view;
	private UserListModel model;
	
	public RegPagePresenter (UserListModel m, RegisterPageView v) {
		view = v;
		model = m;
	}
	
	//SUPPORT ERROR MESSAGE
	public void onClickReg() {
		model.addUser(view.getUsername(), view.getPassOne(), view.getPassTwo());
		view.goToIntro();
	}


	public void onClickBack() {
		view.goToIntro();		
	}
	

}
