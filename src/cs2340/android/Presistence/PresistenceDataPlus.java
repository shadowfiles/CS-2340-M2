package cs2340.android.Presistence;

import cs2340.android.Model.ListModel;
import cs2340.android.Model.UserList;

public class PresistenceDataPlus {

	private ListModel DATA = UserList.getInstance();
	
	public ListModel getData() {
		return DATA;
	}
	
	//SAVE? LOAD?
}
