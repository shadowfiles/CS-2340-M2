package android.cs2340.Views;

import java.util.Collection;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.UserModel;

/**
 * The view for the user page.
 * @author tiff
 *
 */
public interface UserPageView {

    /**
     * Goes to the add acount page.
     * @param theUser The user used to populate the model.
     */
    void goToAddAccount(UserModel theUser);

    /**
     * Goes to the intro page.
     */
    void goToIntro();

    /**
     * Goes to the account. 
     * @param account The account model used to populate the view.
     */
    void goToAccount(AccountModel account);

    /**
     *Makes a list of the accounts.  
     * @param writable A list of Strings representing accounts.
     */
    void drawAccounts(Collection<String> writable);

    /**
     * Goes to a page to make a spending report.
     * @param user The user getting the spending report.
     */
    void goToCreateSpendingReport(UserModel user);

}
