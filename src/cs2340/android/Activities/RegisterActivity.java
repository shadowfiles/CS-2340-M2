package cs2340.android.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import cs2340.android.R;
import cs2340.android.Model.UserList;
import cs2340.android.Presenters.RegPagePresenter;
import cs2340.android.Views.RegisterPageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class RegisterActivity extends Activity implements RegisterPageView {

	RegPagePresenter presenter;
	EditText username;
	EditText passOne;
	EditText passTwo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		presenter = new RegPagePresenter(UserList.getInstance(), this);
		
		username = (EditText) findViewById(cs2340.android.R.id.Username_Reg);
		passOne = (EditText) findViewById(R.id.PassRegOne);
		passTwo = (EditText) findViewById(R.id.PassRegTwo);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public void registerUser(View view) {
		presenter.onClickReg();
	}
	
	public void cancelReg(View view) {
		presenter.onClickBack();
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
	public void setInfoErrorMessage(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToIntro() {
		Intent intent = new Intent(RegisterActivity.this, FullscreenActivity.class);
		startActivity(intent);		
	}


}