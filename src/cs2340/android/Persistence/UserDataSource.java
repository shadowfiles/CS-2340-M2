package cs2340.android.Persistence;

import java.util.Collection;

import android.content.Context;
import cs2340.android.Model.UserModel;
import cs2340.android.Model.User;
import cs2340.android.Model.AccountModel;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;

import java.util.HashMap;

public class UserDataSource extends DataSource {
	private static final String TABLE = "users";
	private static String[] allColumns = {"_id", "username", "password"};
	private static AccountDataSource accountDataSource;
	
	public UserDataSource(Context c) {
		super(c);
		if (accountDataSource == null) {
			accountDataSource = new AccountDataSource(c);
		}
	}
	
	public UserModel createUser(String username, String password) {
		open();
		UserModel user = createUser(database, username, password);
		close();
		return user;
	}
	
	public UserModel getUser(long id) {
		open();
		UserModel user = getUser(database, id);
		close();
		return user;
	}
	
	private UserModel getUser(Cursor cursor) {
		open();
		UserModel user = getUser(database, cursor);
		close();
		return user;
	}
	
	public HashMap<String, UserModel> getAllUsers() {
		HashMap<String, UserModel> users = new HashMap<String, UserModel>();

		open();
		Cursor cursor = database.query(TABLE, allColumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			UserModel user = getUser(cursor);
			users.put(user.getUsername(), user);
			cursor.moveToNext();
		}
		cursor.close();
		close();
		return users;
	}
	
	public static void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE + " ("
        		+ "_id integer primary key autoincrement, "
        		+ "username text not null, "
        		+ "password integer not null, "
        		+ "unique(username) on conflict replace"
        		+ "); "
				);
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	}
	
	public static UserModel createUser(SQLiteDatabase database, String username, String password) {
		ContentValues values = new ContentValues();
		values.put("username", username);
		values.put("password", password.hashCode());
		
		long insertId = database.insert(TABLE, null, values);
		
		return makeUser(database, insertId, username, password.hashCode());
	}
	
	public static UserModel getUser(SQLiteDatabase database, long id) {
		Cursor cursor = database.query(TABLE, allColumns, "_id = " + id, null, null, null, null);
		cursor.moveToFirst();
		UserModel user = getUser(database, cursor);		
		cursor.close();
		return user;
	}
	
	private static UserModel getUser(SQLiteDatabase database, Cursor cursor) {
		String username = cursor.getString(cursor.getColumnIndex("username"));
		int password = (int) cursor.getLong(cursor.getColumnIndex("password"));
		long id = cursor.getLong(cursor.getColumnIndex("_id"));
		
		return makeUser(database, id, username, password);
	}
	
	private static UserModel makeUser(SQLiteDatabase db, long id, String username, int password) {
		UserModel user = new User(id, username, password);
		Collection<AccountModel> accounts = AccountDataSource.getAccounts(db, user);
		user.addAccounts(accounts);
		return user;
	}
	
	

}
