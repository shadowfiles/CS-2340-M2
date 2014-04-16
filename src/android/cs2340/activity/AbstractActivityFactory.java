package android.cs2340.activity;

import android.app.Activity;
import android.os.Bundle;
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
     * The place where we get data from. 
     */
    protected static Database database;

    /**
     * The extras passed into the page.
     */
    protected Bundle extras;

    /**
     * User serial id.
     */
    protected static final String USER_ID = "user_id";
    
    /**
     * Account serial id.
     */
    protected static final String ACCOUNT_ID = "account_id";

    /**
     * Transaction serial id.
     */
    protected static final String TRANSACTION_ID = "transaction_id";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        Database.setContext(context);
        extras = getIntent().getExtras();
    }

    /**
     * Gets the extras.
     * @return The extras.
     */
    protected Bundle getExtras() {
        return extras;
    }
}
