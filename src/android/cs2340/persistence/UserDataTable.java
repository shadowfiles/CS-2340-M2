package android.cs2340.persistence;

import java.util.Collection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;
import android.cs2340.model.AccountModel;
import android.cs2340.model.User;
import android.cs2340.model.UserModel;

import java.util.Map;
import java.util.HashMap;

/**
 * The data source for the users.
 * @author tiff
 *
 */
public class UserDataTable extends Database implements UserDataSource {
    /**
     * The user table.
     */
    private static final String TABLE = "users";
    
    /**
     * The username column.
     */
    private static final String USERNAME_COLUMN = "username";
    
    /**
     * The password column. 
     */
    private static final String PASSWORD_COLUMN = "password";

    /**
     * Array of all the user columns. 
     */
    private static String[] allColumns = {ID_COLUMN, USERNAME_COLUMN, PASSWORD_COLUMN};
    
    /**
     * The data source for the accounts.
     */
    private static AccountDataSource accountDataTable;

    /**
     * Constructor for the data source.
     */
    private UserDataTable() {
        super(getContext());
        if (accountDataTable == null) {
            accountDataTable = AccountDataTable.getSource();
        }
    }

    /**
     * Gets the user data source statically.
     * @return The user data source. 
     */
    public static UserDataSource getSource() {
        UserDataSource users = null;
        if (getContext() != null) {
            users = new UserDataTable();
        }
        return users;
    }
    
    @Override
    public UserModel getUser(String username) {
        open();
        UserModel user = getUser(database, username);
        close();
        return user;
    }

    @Override
    public UserModel createUser(String username, String password) {
        open();
        UserModel user = createUser(database, username, password);
        close();
        return user;
    }

    @Override
    public Map<String, UserModel> getAllUsers() {
        Map<String, UserModel> users = new HashMap<String, UserModel>();

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

    @Override
    public UserModel getUser(long id) {
        open();
        UserModel user = getUser(database, id);
        close();
        return user;
    }

    /**
     * Gets a user based on a cursor.
     * @param cursor The cursor for the user.
     * @return The user object.
     */
    private UserModel getFirstUser(Cursor cursor) {
        open();
        UserModel user = getFirstUser(database, cursor);
        close();
        return user;
    }
    
    /**
     * Gets a user based on a cursor at any location.
     * @param cursor The cursor for the user.
     * @return The user object.
     */
    private UserModel getUser(Cursor cursor) {
        open();
        UserModel user = getUser(database, cursor);
        close();
        return user;
    }

    /**
     * Gets a user based on a cursor. 
     * @param database The database being searched. 
     * @param cursor The cursor. 
     * @return The UserModel found.
     */
    private static UserModel getFirstUser(SQLiteDatabase database, Cursor cursor) {
        UserModel user = null;
        if (cursor.moveToFirst()) {
            user = getUser(database, cursor);
        }
        return user; 
    }
    
    /**
     * Gets a user based on a cursor in a set location. 
     * @param database The database being used.
     * @param cursor The cursor.
     * @return The user made. 
     */
    private static UserModel getUser(SQLiteDatabase database, Cursor cursor) {
        String username = cursor.getString(cursor.getColumnIndex(USERNAME_COLUMN));
        int password = (int) cursor.getLong(cursor.getColumnIndex(PASSWORD_COLUMN));
        long id = cursor.getLong(cursor.getColumnIndex(ID_COLUMN));
        return makeUser(database, id, username, password);
    }

    /**
     * Creates a user statically. 
     * @param database The database to make the user in.
     * @param username The username for the user.
     * @param password The password for the user. 
     * @return The UserModel created. 
     */
    protected static UserModel createUser(SQLiteDatabase database,
            String username, String password) {
        ContentValues values = new ContentValues();
        values.put(USERNAME_COLUMN, username);
        values.put(PASSWORD_COLUMN, password.hashCode());

        long insertId = database.insert(TABLE, null, values);

        return makeUser(database, insertId, username, password.hashCode());
    }

    /**
     * Gets a user based on id statically. 
     * @param database The database being searched.
     * @param id The user's id.
     * @return The UserModel found.
     */
    protected static UserModel getUser(SQLiteDatabase database, long id) {
        Cursor cursor = database.query(TABLE, allColumns, ID_COLUMN + " = " + id, null,
                null, null, null);
        UserModel user = getFirstUser(database, cursor);
        cursor.close();
        return user;
    }
    
    
    /**
     * Gets a user based on usernme statically. 
     * @param database The database being searched.
     * @param username The user's username.
     * @return The UserModel found.
     */
    protected static UserModel getUser(SQLiteDatabase database, String username) {
        Cursor cursor = database.query(TABLE, allColumns, USERNAME_COLUMN + " = " + username, null,
                null, null, null);
        UserModel user = getFirstUser(database, cursor);
        cursor.close();
        return user;
    }
    /**
     * Creates a user model from data. 
     * @param db The database being used. 
     * @param id The id for the user. 
     * @param username The username for the user.
     * @param password The password.
     * @return The user.
     */
    protected static UserModel makeUser(SQLiteDatabase db, long id,
            String username, int password) {
        UserModel user = new User(id, username, password);
        Collection<AccountModel> accounts = AccountDataTable.getAccounts(db,
                user);
        user.addAccounts(accounts);
        return user;
    }

    /**
     * What to do with the user table when a database is created.
     * @param db The database bing modified. 
     */
    protected static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + " ("
                + ID_COLUMN + " integer primary key autoincrement, "
                + USERNAME_COLUMN + " text not null, " + PASSWORD_COLUMN + " integer not null, "
                + "unique(" + USERNAME_COLUMN + ") on conflict replace" + "); ");
    }

    /**
     * What to do when upgrading the database.
     * @param db The database being upgraded. 
     * @param oldVersion The old version of the database.
     * @param newVersion The new version of the database.
     */
    protected static void onUpgrade(SQLiteDatabase db, int oldVersion,
            int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

}
