package android.cs2340.views;

import java.util.Collection;

/**
 * The view for the user page.
 * @author tiff
 *
 */
public interface UserPageView {

    /**
     * Goes to the add acount page.
     * @param userId the user id used. 
     */
    void goToAddAccount(long userId);

    /**
     * Goes to the intro page.
     */
    void goToIntro();

    /**
     * Goes to the account. 
     * @param accountId The account model used to populate the view.
     */
    void goToAccount(long accountId);

    /**
     *Makes a list of the accounts.  
     * @param writable A list of Strings representing accounts.
     */
    void drawAccounts(Collection<String> writable);

    /**
     * Goes to a page to make a spending report.
     * @param userId The user getting the spending report.
     */
    void goToCreateSpendingReport(long userId);

}
