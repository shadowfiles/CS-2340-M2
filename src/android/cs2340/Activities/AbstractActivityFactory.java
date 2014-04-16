package android.cs2340.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.Context;

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
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        preferences = context.getSharedPreferences("CS2340WatersWarriors", 0);
        editor = preferences.edit();
    }
}
