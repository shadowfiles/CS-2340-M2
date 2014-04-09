package android.cs2340.Presenters;

import android.cs2340.Views.IntroPageView;

/**
 * The presenter for the intro page.
 * @author tiff
 *
 */
public class IntroPagePresenter {

    /**
     * The view used by the intro page.
     */
    private IntroPageView view;

    /**
     * Constructor for the presenter. 
     * @param v The view used.
     */
    public IntroPagePresenter(IntroPageView v) {
        view = v;
        // view.attemptIntroCallback(this);
    }

    /**
     * Redirects to login page when button is clicked.
     */
    public void onClickLogin() {
        view.transferPageLogin();

    }

    /**
     * Redirects to register page when button is clicked.
     */
    public void onClickReg() {
        view.transferPageReg();
    }

}
