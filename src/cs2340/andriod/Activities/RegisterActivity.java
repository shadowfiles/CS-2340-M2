package cs2340.andriod.Activities;

import cs2340.andriod.Model.UserList;
import cs2340.andriod.Presenters.LoginPagePresenter;
import cs2340.andriod.Views.ClickListener;
import cs2340.andriod.cs_2340_water_s_warrioirs.R;
import cs2340.andriod.cs_2340_water_s_warrioirs.R.layout;
import cs2340.andriod.cs_2340_water_s_warrioirs.R.menu;
import cs2340.andriod.cs_2340_water_s_warrioirs.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class RegisterActivity extends Activity {

	private ClickListener listener;
	LoginPagePresenter presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	}