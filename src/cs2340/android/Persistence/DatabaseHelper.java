package cs2340.android.Persistence;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {
	// Logcat tag
    private static final String LOG = "DatabaseHelper";
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "moneyapp";
    
    // Table Names
    private static final String TABLE_USER = "users";
    private static final String TABLE_ACCOUNT = "accounts";
    private static final String TABLE_TRANSACTION = "transactions";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL("CREATE TABLE IF NOT EXISTS `" + TABLE_USER + "` ("
        		+ "`id` int(10) unsigned NOT NULL AUTO_INCREMENT,"
        		+ "`username` varchar(100) NOT NULL,"
        		+ "`password` tinytext NOT NULL,"
        		+ "`created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"
        		+ "PRIMARY KEY (`id`),"
        		+ "UNIQUE KEY `username` (`username`)"
        		+ ")"
        		+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;");
        db.execSQL("CREATE TABLE IF NOT EXISTS `" + TABLE_TRANSACTION + "` ("
        		+ "`id` int(10) unsigned NOT NULL AUTO_INCREMENT,"
        		+ "`account_id` int(10) unsigned NOT NULL,"
        		+ "`amount` int(10) unsigned NOT NULL,"
        		+ "`source` tinytext NOT NULL,"
        		+ "`date` int(10) unsigned NOT NULL,"
        		+ "`is_deposit` tinyint(1) NOT NULL,"
        		+ "`created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"
        		+ "PRIMARY KEY (`id`)"
        		+ ")"
        		+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;");
        db.execSQL("CREATE TABLE IF NOT EXISTS `" + TABLE_ACCOUNT + ""
        		+ "` (`id` int(10) unsigned NOT NULL AUTO_INCREMENT,"
        		+ "`display_name` tinytext NOT NULL,"
        		+ "`name` tinytext NOT NULL,"
        		+ "`balance` int(11) NOT NULL,"
        		+ "`interest` int(11) NOT NULL,"
        		+ " `user_id` int(10) unsigned NOT NULL,"
        		+ "`created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"
        		+ "PRIMARY KEY (`id`)"
        		+ ")"
        		+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;");
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION);
 
        // create new tables
        onCreate(db);
    }
}
