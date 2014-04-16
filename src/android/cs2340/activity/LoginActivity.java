package android.cs2340.activity;


import android.content.Intent;
import android.cs2340.presenters.LoginPagePresenter;
import android.cs2340.views.LoginPageView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.cs2340.R;

/**
 * The class constructs the screen for user to login.
 * 
 * @author Team 42
 * 
 */
public class LoginActivity extends AbstractActivityFactory implements LoginPageView {

    /**
     * The Presenter used by the view. 
     */
    LoginPagePresenter presenter;
    
    /**
     * The username entered by the user.  
     */
    EditText usernameField;
    
    /**
     * The password entered by the user. 
     */
    EditText passwordField;
    
    /**
     * The textbox for feedback shown to the user. 
     */
    TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPagePresenter(this);

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

    /**
     * Hook for when the user clicks the login button.
     * @param v This view.
     */
    public void attemptLogin(View v) {
        presenter.onClickLogin();
    }

    /**
     * Hook for when the user clicks the back button. 
     * @param v This view.
     */
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
    public void goToSuccess(long userId) {
        Intent intent = new Intent(LoginActivity.this, UserPageActivity.class);
        intent.putExtra(USER_SERIAL_ID, userId);
        startActivity(intent);
    }

    @Override
    public void goToIntro() {
        Intent intent = new Intent(LoginActivity.this, FullscreenActivity.class);
        startActivity(intent);
    }

}
