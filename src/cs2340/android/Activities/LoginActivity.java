package cs2340.android.Activities;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import cs2340.android.Model.User;
import cs2340.android.Model.UserList;
import cs2340.android.Model.UserModel;
import cs2340.android.Presenters.LoginPagePresenter;
import cs2340.android.Views.LoginPageView;
import cs2340.android.R;

public class LoginActivity extends Activity implements LoginPageView{

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
		presenter.onClickLogin();
	}
	
	public void backToIntro(View v) {
		presenter.onClickBack();
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
	public void goToSuccess(UserModel passedObject) {
		Intent intent = new Intent(LoginActivity.this, UserPageActivity.class);
		intent.putExtra("theUser", (Serializable)passedObject);
		startActivity(intent);		
	}
	
	public void goToIntro() {
		Intent intent = new Intent(LoginActivity.this, FullscreenActivity.class);
		startActivity(intent);	
	}

}
