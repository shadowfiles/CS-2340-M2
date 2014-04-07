package android.cs2340.Activities;

import android.app.Activity;
import android.content.Intent;
import android.cs2340.Model.UserList;
import android.cs2340.Presenters.RegPagePresenter;
import android.cs2340.Views.RegisterPageView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.cs2340.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @author Team 42
 * @see SystemUiHider
 */
public class RegisterActivity extends Activity implements RegisterPageView {

    /**
     * The Presenter used by the view.
     */
    RegPagePresenter presenter;
    
    /**
     * The username entered by the user.
     */
    EditText username;
    
    /**
     * The first password entered by the user.
     */
    EditText passOne;
    
    /**
     * The second password entered by the user. 
     */
    EditText passTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new RegPagePresenter(
                UserList.getInstance(getApplicationContext()), this);

        username = (EditText) findViewById(android.cs2340.R.id.Username_Reg);
        passOne = (EditText) findViewById(R.id.PassRegOne);
        passTwo = (EditText) findViewById(R.id.PassRegTwo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    /**
     * Hook for when the user clicks the register button.
     * @param view This view.
     */
    public void registerUser(View view) {
        presenter.onClickReg();
    }

    /**
     * Hook for when the user clicks the cancel button.
     * @param view This view. 
     */
    public void cancelReg(View view) {
        presenter.onClickBack();
    }

    @Override
    public void clearInfo() {
        username.setText("");
        passOne.setText("");
        passTwo.setText("");
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassOne() {
        return passOne.getText().toString();
    }

    @Override
    public String getPassTwo() {
        return passTwo.getText().toString();
    }

    @Override
    public void setInfoErrorMessage(String text) {
        // TODO Auto-generated method stub
    }

    @Override
    public void goToIntro() {
        Intent intent = new Intent(RegisterActivity.this,
                FullscreenActivity.class);
        startActivity(intent);
    }

}