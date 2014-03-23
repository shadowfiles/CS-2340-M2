package cs2340.android.Persistence;

import cs2340.android.Model.ListModel;
import cs2340.android.Model.UserList;
import android.database.sqlite.SQLiteOpenHelper;

public class PersistenceDataPlus {

	private ListModel DATA = UserList.getInstance();
	
	public ListModel getData() {
		return DATA;
	}
	
	//SAVE? LOAD?
}
