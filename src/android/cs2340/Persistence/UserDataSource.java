package android.cs2340.Persistence;

import java.util.Collection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;
import android.cs2340.Model.AccountModel;
import android.cs2340.Model.User;
import android.cs2340.Model.UserModel;

import java.util.HashMap;

public class UserDataSource extends DataSource {
    private static final String TABLE = "users";
    private static final String USERNAME_COLUMN = "username";
    private static final String PASSWORD_COLUMN = "password";
    
    private static String[] allColumns = { ID_COLUMN, USERNAME_COLUMN, PASSWORD_COLUMN };
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
        Cursor cursor = database.query(TABLE, allColumns, null, null, null,
                null, null);

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
                + ID_COLUMN + " integer primary key autoincrement, "
                + USERNAME_COLUMN + " text not null, " + PASSWORD_COLUMN + " integer not null, "
                + "unique(" + USERNAME_COLUMN + ") on conflict replace" + "); ");
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion,
            int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

    public static UserModel createUser(SQLiteDatabase database,
            String username, String password) {
        ContentValues values = new ContentValues();
        values.put(USERNAME_COLUMN, username);
        values.put(PASSWORD_COLUMN, password.hashCode());

        long insertId = database.insert(TABLE, null, values);

        return makeUser(database, insertId, username, password.hashCode());
    }

    public static UserModel getUser(SQLiteDatabase database, long id) {
        Cursor cursor = database.query(TABLE, allColumns, ID_COLUMN + " = " + id, null,
                null, null, null);
        cursor.moveToFirst();
        UserModel user = getUser(database, cursor);
        cursor.close();
        return user;
    }

    private static UserModel getUser(SQLiteDatabase database, Cursor cursor) {
        String username = cursor.getString(cursor.getColumnIndex(USERNAME_COLUMN));
        int password = (int) cursor.getLong(cursor.getColumnIndex(PASSWORD_COLUMN));
        long id = cursor.getLong(cursor.getColumnIndex(ID_COLUMN));

        return makeUser(database, id, username, password);
    }

    private static UserModel makeUser(SQLiteDatabase db, long id,
            String username, int password) {
        UserModel user = new User(id, username, password);
        Collection<AccountModel> accounts = AccountDataSource.getAccounts(db,
                user);
        user.addAccounts(accounts);
        return user;
    }

}
