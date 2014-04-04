package android.cs2340.Activities;

import java.io.Serializable;

import android.cs2340.R;
import android.cs2340.R.layout;
import android.cs2340.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.cs2340.Model.UserList;
import android.cs2340.Model.UserModel;
import android.cs2340.Persistence.AccountDataSource;
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
public class AddAccountActivity extends Activity implements AddAccountPageView {

    private AddAccountPresenter presenter;
    private EditText fullName;
    private EditText displayName;
    private EditText balance;
    private EditText interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_acount);

        presenter = new AddAccountPresenter((UserModel) getIntent().getExtras()
                .getSerializable("theUser"), UserList.getInstance(this), this);
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
        intent.putExtra("theUser", (Serializable) theUser);
        startActivity(intent);
    }

    @Override
    public void createButton(View view) {
        presenter.onClickCreate();
    }

    @Override
    public void backButton(View view) {
        presenter.onClickBack();
    }

}
