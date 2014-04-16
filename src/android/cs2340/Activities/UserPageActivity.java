package android.cs2340.Activities;

import java.io.Serializable;
import java.util.Collection;

import android.cs2340.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.cs2340.Model.AccountModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Presenters.UserPagePresenter;
import android.cs2340.Views.UserPageView;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * This class display the detailed information of the user.
 * 
 * @author Team 42
 * 
 */
public class UserPageActivity extends AbstractActivityFactory implements UserPageView {

    /**
     * Presenter used by the View.
     */
    private UserPagePresenter presenter;
    
    /**
     * Layout for the accounts owned by the user.
     */
    private LinearLayout accountlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        presenter = new UserPagePresenter((UserModel) getIntent().getExtras()
                .getSerializable(USER_SERIAL_ID), this);
        accountlist = (LinearLayout) findViewById(R.id.account_list);
        presenter.drawAccounts();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_page, menu);
        return true;
    }

    @Override
    public void drawAccounts(Collection<String> writable) {
        for (String s : writable) {
            final Button button = new Button(this);
            button.setText(s);
            button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    presenter.onClickAccount(button.getText().toString());
                }
            });
            accountlist.addView(button, 0);
        }
    }

    /**
     * What happens when the user clicks the button to add an account. 
     * @param view This view.
     */
    public void addAccountButton(View view) {
        presenter.onClickAddAccount();
    }

    /**
     * Hook for when the user clicks the button to create a spending report.
     * @param view This view.
     */
    public void createSpendingReport(View view) {
        presenter.goToCreateSpendingReport();
    }

    /**
     * The hook for when the user clicks the logout button.
     * @param view This view.
     */
    public void logoutButton(View view) {
        presenter.onClickLogout();
    }

    @Override
    public void goToAddAccount(UserModel theUser) {
        Intent intent = new Intent(UserPageActivity.this,
                AddAccountActivity.class);
        intent.putExtra(USER_SERIAL_ID, (Serializable) theUser);
        startActivity(intent);
    }

    @Override
    public void goToIntro() {
        Intent intent = new Intent(UserPageActivity.this,
                FullscreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToCreateSpendingReport(UserModel user) {
        Intent intent = new Intent(this, SpendingReportParametersActivity.class);
        intent.putExtra(USER_SERIAL_ID, (Serializable) user);
        startActivity(intent);
    }

    @Override
    public void goToAccount(AccountModel account) {
        Intent intent = new Intent(UserPageActivity.this, AccountActivity.class);
        intent.putExtra("theAccount", (Serializable) account);
        startActivity(intent);
    }

}
