package android.cs2340.activity;

import android.cs2340.R;
import android.os.Bundle;
import android.content.Intent;
import android.cs2340.presenters.AddAccountPresenter;
import android.cs2340.views.AddAccountPageView;
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

        presenter = new AddAccountPresenter(getExtras().getLong("account_id"), this);
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
    public void goToUserPage(long userId) {
        Intent intent = new Intent(AddAccountActivity.this,
                UserPageActivity.class);
        intent.putExtra("user_id", userId);
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
