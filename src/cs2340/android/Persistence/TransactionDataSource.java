package cs2340.android.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import cs2340.android.Model.TransactionAbstract;
import cs2340.android.Model.Deposit;
import cs2340.android.Model.Withdrawal;

public class TransactionDataSource extends DataSource {
	private static final String TABLE = "transactions";
	private static String[] allColumns = {"_id", "account_id", "amount",
		"source", "data", "is_deposit"};
	
	public TransactionDataSource(Context c) {
		super(c);
	}

	public static void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
        		+ "_id integer primary key autoincrement, "
        		+ "account_id integer not null, "
        		+ "amount integer not null, "
        		+ "source text not null, "
        		+ "date text not null, "
        		+ "is_deposit integer(1) not null"
        		+ ");"
        		);
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	}
}
