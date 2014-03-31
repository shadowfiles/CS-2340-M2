package cs2340.android.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TransactionDataSource extends DataSource {
	private static final String TABLE = "transactions";
	
	public TransactionDataSource(Context c) {
		super(c);
	}

	public static void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
        		+ "_id integer primary key autoincrement, "
        		+ "account_id integer not null, "
        		+ "amount integer not null, "
        		+ "source text not null, "
        		+ "date integer not null, "
        		+ "is_deposit integer(1) not null"
        		+ ");"
        		);
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	}
}
