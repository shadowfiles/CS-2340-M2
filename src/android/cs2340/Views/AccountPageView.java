package android.cs2340.Views;

import java.util.Collection;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.UserModel;

/**
 * Interface for the page to view accounts.
 * @author tiff
 *
 */
public interface AccountPageView {

    /**
     * Goes back a page.  
     * @param user The user to go back to. 
     */
    void goBack(UserModel user);

    /**
     * Shows the amount of an account's balance. 
     * @param balance The balance to show. 
     */
    void setAmount(String balance);

    /**
     * Goes to the page to add transactions.
     * @param account The account to add transactions to.
     */
    void goToTransaction(AccountModel account);

    /**
     * Draw transactions. 
     * @param writable Uses a collection of writable strings to make the transactions list. 
     */
    void drawTransactions(Collection<String> writable);
}
