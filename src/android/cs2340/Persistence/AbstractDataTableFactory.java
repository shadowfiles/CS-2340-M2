package android.cs2340.Persistence;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.SQLException;

/**
 * Parent class for the various DataSources.
 * @author tiff
 *
 */
public abstract class AbstractDataTableFactory {
    /**
     * The helper for the data source.  
     */
    protected DatabaseHelper dbHelper;
    
    /**
     * The database used by the datasource.
     */
    protected SQLiteDatabase database;
    
    /**
     * The context this data source was made in. 
     */
    protected Context context;
    
    /**
     * A single instance of the data source.
     */
    protected static AbstractDataTableFactory instance;

    /**
     * The id column for various tables.
     */
    protected static final String ID_COLUMN = "_id";
    
    /**
     * The user id column for tables.
     */
    protected static final String USER_ID_COLUMN = "user_id";
    
    /**
     * The account id column for various tables.
     */
    protected static final String ACCOUNT_ID_COLUMN = "account_id";
    
    /**
     * The transaction id column for various tables.
     */
    protected static final String TRANSACTION_ID_COLUMN = "transaction_id";
    

    /**
     * Creates a new data source.  
     * @param c The context of the data source. XD
     */
    public AbstractDataTableFactory(Context c) {
        dbHelper = DatabaseHelper.getInstance(c);
        context = c;
        instance = this;
    }

    /**
     * Closes the database.
     */
    public void close() {
        dbHelper.close();
    }

    /**
     * Opens the database. 
     * @throws SQLException A SQLite exception can be thrown.
     */
    public void open() throws SQLException {
        if (database == null || !database.isOpen()) {
            database = dbHelper.getWritableDatabase();
        }
    }

    /**
     * Gets the context. 
     * @return The context of the data source. 
     */
    public static Context getContext() {
        return getInstance().context;
    }

    /**
     * Gets the single instance of the data source. 
     * @return The instance of AbstractDataSourceFactory.
     */
    public static AbstractDataTableFactory getInstance() {
        return instance;
    }

    /**
     * Converts money to integer form. 
     * @param d The money to convert. 
     * @return The final long version of the money. 
     */
    protected static long doubleToLong(double d) {
        return (long) d * 100;
    }

    /**
     * Converts money from a long into a double. 
     * @param i The long.
     * @return The double form of the money. 
     */
    protected static double longToDouble(long i) {
        return ((double) i) / 100;
    }
}
