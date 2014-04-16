package android.cs2340.activity;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.Context;
import android.cs2340.persistence.Database;

/**
 * An Activity for all other Activities in the app to extend.
 * @author tiff
 *
 */
public abstract class AbstractActivityFactory extends Activity {

    /**
     * The context for the app.
     */
    protected static Context context;
    /**
     * The preferences for the app. 
     */
    protected static SharedPreferences preferences;

    /**
     * For editing preferences.
     */
    protected static Editor editor;

    /**
     * The place where we get data from. 
     */
    protected static Database database;

    /**
     * The extras passed into the page.
     */
    protected Bundle extras = getIntent().getExtras();

    /**
     * User serial id.
     */
    protected static final String USER_SERIAL_ID = "user_id";
    
    /**
     * Account serial id.
     */
    protected static final String ACCOUNT_SERIAL_ID = "account_id";

    /**
     * Transaction serial id.
     */
    protected static final String TRANSACTION_SERIAL_ID = "transaction_id";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        preferences = context.getSharedPreferences("CS2340WatersWarriors", 0);
        editor = preferences.edit();
        Database.setContext(context);
    }

    /**
     * Gets the extras.
     * @return The extras.
     */
    protected Bundle getExtras() {
        return extras;
    }
}
