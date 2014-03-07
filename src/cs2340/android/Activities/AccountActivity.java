package cs2340.android.Activities;

import cs2340.andriod.cs_2340_water_s_warriors.R;
import cs2340.andriod.cs_2340_water_s_warriors.R.layout;
import cs2340.andriod.cs_2340_water_s_warriors.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class AccountActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}
	
	public void makeTransaction(View view){
		Intent i = new Intent(this, TransactionActivity.class);
		startActivity(i);
	}
	
	public void back(View view){
		Intent i = new Intent(this, UserPageActivity.class);
		startActivity(i);
	}
	
}
