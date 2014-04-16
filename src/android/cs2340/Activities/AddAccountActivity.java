package android.cs2340.Activities;

import java.io.Serializable;

import android.cs2340.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.cs2340.Model.UserList;
import android.cs2340.Model.UserModel;
import android.cs2340.Presenters.AddAccountPresenter;
import android.cs2340.Views.AddAccountPageView;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**
 * This class describes the methods need to add a new account for a user.
 * 
 * @author Team 42
 */
public class AddAccountActivity extends AbstractActivityFactory implements AddAccountPageView {

    /**
     * Presenter used by the view. 
     */
    private AddAccountPresenter presenter;
    
    /**
     * Entered full name of the account added.
     */
    private EditText fullName;
    
    /**
     * Entered display name of the account added. 
     */
    private EditText displayName;
    
    /**
     * Entered balance of the account added.
     */
    private EditText balance;
    
    /**
     * Entered interest of the account added. 
     */
    private EditText interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_acount);

        presenter = new AddAccountPresenter((UserModel) getIntent().getExtras()
                .getSerializable(USER_SERIAL_ID), UserList.getInstance(this), this);
        // display accounts

        fullName = (EditText) findViewById(R.id.fullNameAddAccount);
        displayName = (EditText) findViewById(R.id.displayNameAddAccount);
        balance = (EditText) findViewById(R.id.balanceAddAccount);
        interest = (EditText) findViewById(R.id.interestAddAccount);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_acount, menu);
        return true;
    }

    @Override
    public String getFullName() {
        return fullName.getText().toString();
    }

    @Override
    public String getDisplayName() {
        return displayName.getText().toString();
    }

    @Override
    public double getBalance() {
        return Double.parseDouble(balance.getText().toString());
    }

    @Override
    public double getInterest() {
        return Double.parseDouble(interest.getText().toString());
    }

    @Override
    public void goToUserPage(UserModel theUser) {
        Intent intent = new Intent(AddAccountActivity.this,
                UserPageActivity.class);
        intent.putExtra(USER_SERIAL_ID, (Serializable) theUser);
        startActivity(intent);
    }

    /**
     * Hook for when the user clicks the button to create an account.
     * @param view This view.
     */
    public void createButton(View view) {
        presenter.onClickCreate();
    }

    /**
     * Hook for when the user clicks the back button.
     * @param view This view.
     */
    public void backButton(View view) {
        presenter.onClickBack();
    }

}
