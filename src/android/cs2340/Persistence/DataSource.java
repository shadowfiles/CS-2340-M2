package android.cs2340.Persistence;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.SQLException;

public abstract class DataSource {
    protected DatabaseHelper dbHelper;
    protected SQLiteDatabase database;
    protected Context context;
    protected static DataSource INSTANCE;

    public DataSource(Context c) {
        dbHelper = DatabaseHelper.getInstance(c);
        context = c;
        INSTANCE = this;
    }

    public void open() throws SQLException {
        if (database == null || !database.isOpen()) {
            database = dbHelper.getWritableDatabase();
        }
    }

    public void close() {
        dbHelper.close();
    }

    public static DataSource getInstance() {
        return INSTANCE;
    }

    public static Context getContext() {
        return getInstance().context;
    }

    protected static int doubleToInt(double d) {
        return (int) d * 100;
    }

    protected static double longToDouble(long i) {
        return ((double) i) / 100;
    }
}
