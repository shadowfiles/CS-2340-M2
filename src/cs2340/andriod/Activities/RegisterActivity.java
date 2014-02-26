package cs2340.andriod.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import cs2340.andriod.cs_2340_water_s_warriors.R;
import cs2340.android.Model.UserList;
import cs2340.android.Presenters.PresenterInterface;
import cs2340.android.Presenters.RegPagePresenter;
import cs2340.android.Views.RegisterPageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class RegisterActivity extends Activity implements RegisterPageView {

	private PresenterInterface listener;
	RegPagePresenter presenter;
	EditText username;
	EditText passOne;
	EditText passTwo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		presenter = new RegPagePresenter(UserList.getInstance(), this);
		
		username = (EditText) findViewById(cs2340.andriod.cs_2340_water_s_warriors.R.id.Username_Reg);
		passOne = (EditText) findViewById(R.id.PassRegOne);
		passTwo = (EditText) findViewById(R.id.PassRegTwo);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public void registerUser(View view) {
		listener.onClickOne();
	}
	
	public void cancelReg(View view) {
		listener.onClickTwo();
	}

	public void clearInfo() {
		username.setText("");
		passOne.setText("");
		passTwo.setText("");
	}
	
	public String getUsername() {
		return username.getText().toString();
	}
	

	public String getPassOne() {
		return passOne.getText().toString();
	}

	public String getPassTwo() {
		return passTwo.getText().toString();
	}

	@Override
	public void attemptRegisterCallback(PresenterInterface lsnr) {
		listener = lsnr;
	}

	@Override
	public void setInfoErrorMessage(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToIntro() {
		Intent intent = new Intent(RegisterActivity.this, FullscreenActivity.class);
		startActivity(intent);		
	}


}