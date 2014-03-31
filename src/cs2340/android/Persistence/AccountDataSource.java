package cs2340.android.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;

import java.util.Collection;
import java.util.ArrayList;

import cs2340.android.Model.AccountModel;
import cs2340.android.Model.Account;
import cs2340.android.Model.UserModel;

public class AccountDataSource extends DataSource {
	private static final String TABLE = "accounts";
	private static String[] allColumns = {"_id", "full_name", "account_name", 
		"balance", "interest", "user_id"};

	public AccountDataSource(Context c) {
		super(c);
	}
	
	public AccountModel createAccount(String fullName, String accountName,
			double balance, double interest, UserModel owner) {
		
		open();
		ContentValues values = new ContentValues();
		values.put("full_name", fullName);
		values.put("account_name", accountName);
		values.put("balance", doubleToInt(balance));
		values.put("interest", doubleToInt(interest));
		values.put("user_id", owner.getId());
		
		long insertId = database.insert(TABLE, null, values);
		close();
		return new Account(insertId, fullName, accountName, balance, interest, owner);
	}
	
	public Collection<AccountModel> getAccounts(UserModel user) {
		open();
		Collection<AccountModel> accounts = getAccounts(database, user);
		close();
		return accounts;
	}
	
	public AccountModel getAccount(Cursor cursor, UserModel owner) {
		return getAccount(database, cursor, owner);
	}
	
	public static void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
        		+ "_id integer primary key autoincrement, "
        		+ "full_name text not null, "
        		+ "account_name text not null, "
        		+ "balance integer not null, "
        		+ "interest integer not null, "
        		+ "user_id integer not null"
        		+ ");");
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	}
	
	public static Collection<AccountModel> getAccounts(SQLiteDatabase database, UserModel user) {
		Collection<AccountModel> accounts = new ArrayList<AccountModel>();
		Cursor cursor = database.query(TABLE, allColumns, "user_id = " + user.getId(), null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			AccountModel a = getAccount(database, cursor, user);
			accounts.add(a);
			cursor.moveToNext();
		}
		cursor.close();
		return accounts;
	}
	
	private static AccountModel getAccount(SQLiteDatabase database, Cursor cursor, UserModel user) {
		String fullName = cursor.getString(cursor.getColumnIndex("full_name"));
		String accountName = cursor.getString(cursor.getColumnIndex("account_name"));
		double balance  = longToDouble(cursor.getLong(cursor.getColumnIndex("balance")));
		double interest = longToDouble(cursor.getLong(cursor.getColumnIndex("interest")));
		long id = cursor.getLong(cursor.getColumnIndex("_id"));
		return new Account(id, fullName, accountName, balance, interest, user);
	}
	
	private static int doubleToInt(double d) {
		return (int) d * 100;
	}
	
	private static double longToDouble(long i) {
		return ((double) i) / 100;
	}
}
