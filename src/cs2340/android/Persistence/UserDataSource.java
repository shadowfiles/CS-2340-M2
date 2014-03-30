package cs2340.android.Persistence;

import cs2340.android.Model.UserModel;
import cs2340.android.Model.User;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;

import java.util.HashMap;

public class UserDataSource extends DataSource {
	private static final String TABLE = "users";
	private static String[] allColumns = {"_id", "username", "password"};
	
	public UserDataSource() {
		super();
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
		//createUser(db, "admin", "pass123");
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	}
	
	public static UserModel createUser(SQLiteDatabase database, String username, String password) {
		ContentValues values = new ContentValues();
		values.put("username", username);
		values.put("password", password.hashCode());
		
		long insertId = database.insert(TABLE, null, values);
		return getUser(database, insertId);
	}
	
	public static UserModel getUser(SQLiteDatabase database, long id) {
		Cursor cursor = database.query(TABLE, allColumns, "_id = " + id, null, null, null, null);
		cursor.moveToFirst();
		UserModel user = getUser(database, cursor);		
		cursor.close();
		return user;
	}
	
	private static UserModel getUser(SQLiteDatabase database, Cursor cursor) {
		String username = cursor.getString(0);
		int password = cursor.getInt(1);
		long id = cursor.getLong(0);
		return new User(id, username, password);
	}

}
