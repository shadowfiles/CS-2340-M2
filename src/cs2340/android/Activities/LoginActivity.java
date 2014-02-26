package cs2340.android.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import cs2340.android.Model.UserList;
import cs2340.android.Presenters.LoginPagePresenter;
import cs2340.android.Presenters.PresenterInterface;
import cs2340.android.Views.LoginPageView;
import cs2340.andriod.cs_2340_water_s_warriors.R;

public class LoginActivity extends Activity implements LoginPageView{

	private PresenterInterface listener;
	LoginPagePresenter presenter;
	EditText usernameField;
	EditText passwordField;
	TextView feedback;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		presenter = new LoginPagePresenter(UserList.getInstance(), this);
		
		usernameField = (EditText) findViewById(R.id.username_input);
		passwordField = (EditText) findViewById(R.id.password_input);
		feedback = (TextView) findViewById(R.id.feedback_string);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public void attemptLogin(View v) {
		listener.onClickOne();
	}
	
	@Override
	public String getUsername() {
		return usernameField.getText().toString();
	}

	@Override
	public String getPassword() {
		return passwordField.getText().toString();
	}

	@Override
	public void setErrorMessage(String text) {
		feedback.setText(text);
		
	}

	@Override
	public void attemptLoginCallback(PresenterInterface lsnr) {
		listener = lsnr;
	}

	@Override
	public void goToSuccess() {
		Intent intent = new Intent(LoginActivity.this, SucessActivity.class);
		startActivity(intent);		
	}

	
	
}
