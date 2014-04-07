package android.cs2340.Activities;

import android.app.Activity;
import android.content.Intent;
import android.cs2340.Presenters.IntroPagePresenter;
import android.cs2340.Views.IntroPageView;
import android.os.Bundle;
import android.view.View;
import android.cs2340.R;

/**
 * This class constructs the full screen(welcome screen) for the application.
 * 
 * @author Team 42
 * 
 */
public class FullscreenActivity extends Activity implements IntroPageView {

    /**
     * The Presenter used by the view. 
     */
    IntroPagePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        presenter = new IntroPagePresenter(this);
    }

    /**
     * Hook for when the user clicks to go to the login page.
     * Goes to LoginPageActivity.
     * @param view This view.
     */
    public void goLoginPage(View view) {
        presenter.onClickLogin();
    }

    @Override
    public void transferPageLogin() {
        Intent intent = new Intent(FullscreenActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Hook for when the user clicks the register page button.
     * Goes to RegisterActivity.
     * @param view This view.
     */
    public void goRegisterPage(View view) {
        presenter.onClickReg();
    }

    @Override
    public void transferPageReg() {
        Intent intent = new Intent(FullscreenActivity.this,
                RegisterActivity.class);
        startActivity(intent);
    }

}