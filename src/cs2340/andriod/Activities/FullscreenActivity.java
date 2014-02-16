package cs2340.andriod.Activities;


import cs2340.andriod.cs_2340_water_s_warrioirs.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FullscreenActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen);
	}
	 
	public void goLoginPage(View view){
		Intent intent = new Intent(FullscreenActivity.this, LoginActivity.class);
		startActivity(intent);
	}
}
