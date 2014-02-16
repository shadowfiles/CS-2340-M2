package cs2340.andriod.Activities;

import cs2340.andriod.cs_2340_water_s_warrioirs.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SucessActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sucess);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sucess, menu);
		return true;
	}

}
