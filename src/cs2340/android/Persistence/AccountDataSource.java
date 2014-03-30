package cs2340.android.Persistence;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;

public class AccountDataSource extends DataSource {
	private static final String TABLE = "accounts";

	public AccountDataSource() {
		super();
	}
	
	public static void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS `" + TABLE + "` ("
        		+ "`_id` int(10) unsigned NOT NULL AUTO_INCREMENT,"
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

	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	}
}
