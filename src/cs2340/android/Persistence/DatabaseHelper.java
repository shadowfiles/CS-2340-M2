
package cs2340.android.Persistence;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

/*
public class DatabaseHelper extends SQLiteOpenHelper {

	
	// Logcat tag
    private static final String LOG = "DatabaseHelper";
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "moneyapp";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
    	UserTableHelper.onCreate(db);
    	AccountTableHelper.onCreate(db);
    	TransactionTableHelper.onCreate(db);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	// delete old tables
        UserTableHelper.onUpgrade(db, oldVersion, newVersion);
        AccountTableHelper.onUpgrade(db, oldVersion, newVersion);
        TransactionTableHelper.onUpgrade(db, oldVersion, newVersion);
 
        // create new tables
        onCreate(db);
    }
    
}
*/
