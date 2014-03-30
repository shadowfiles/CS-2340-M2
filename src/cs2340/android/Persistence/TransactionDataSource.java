package cs2340.android.Persistence;

import android.database.sqlite.SQLiteDatabase;

public class TransactionDataSource extends DataSource {
	private static final String TABLE = "transactions";
	
	public TransactionDataSource() {
		super();
	}

	public static void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS `" + TABLE + "` ("
        		+ "`_id` int(10) unsigned NOT NULL AUTO_INCREMENT,"
        		+ "`account_id` int(10) unsigned NOT NULL,"
        		+ "`amount` int(10) unsigned NOT NULL,"
        		+ "`source` tinytext NOT NULL,"
        		+ "`date` int(10) unsigned NOT NULL,"
        		+ "`is_deposit` tinyint(1) NOT NULL,"
        		+ "`created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"
        		+ "PRIMARY KEY (`id`)"
        		+ ")"
        		+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;");
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	}
}
