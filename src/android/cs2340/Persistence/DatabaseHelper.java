package android.cs2340.Persistence;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

/**
 * Helper for SQLite database.
 * @author tiff
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     * Logcat tag for debugging.
     */
    public static final String LOG = "DatabaseHelper";

    /**
     * The version of the database. 
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Name of the database.
     */
    private static final String DATABASE_NAME = "moneyapp.db";

    /**
     * The instance of the helper.
     */
    private static DatabaseHelper instance;

    /**
     * Private constructor for the helper. 
     * @param context The context the database is made in.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        UserDataTable.onCreate(db);
        AccountDataTable.onCreate(db);
        TransactionDataTable.onCreate(db);
        UserDataTable.createUser(db, "admin", "pass123");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // delete old tables
        UserDataTable.onUpgrade(db, oldVersion, newVersion);
        AccountDataTable.onUpgrade(db, oldVersion, newVersion);
        TransactionDataTable.onUpgrade(db, oldVersion, newVersion);

        // create new tables
        onCreate(db);
    }

    /**
     * Gets the instance of the database helper statically.
     * @param c The context to get the database in. 
     * @return The instance of the DatabaseHelper. 
     */
    public static DatabaseHelper getInstance(Context c) {
        if (instance == null) {
            instance = new DatabaseHelper(c);
        }
        return instance;
    }

}
