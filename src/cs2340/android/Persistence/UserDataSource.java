package cs2340.android.Persistence;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

public class UserDataSource {
	

	private static final String TABLE = "users";
	public static void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS `" + TABLE + "` ("
        		+ "`_id` int(10) unsigned NOT NULL AUTO_INCREMENT,"
        		+ "`username` varchar(100) NOT NULL,"
        		+ "`password` tinytext NOT NULL,"
        		+ "`created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"
        		+ "PRIMARY KEY (`id`),"
        		+ "UNIQUE KEY `username` (`username`)"
        		+ ")"
        		+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;");
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	}

}
