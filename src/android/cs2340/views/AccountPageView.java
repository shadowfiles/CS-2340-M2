package android.cs2340.views;

import java.util.Collection;


/**
 * Interface for the page to view accounts.
 * @author tiff
 *
 */
public interface AccountPageView {

    /**
     * Goes back a page.  
     * @param userId The user to go back to. 
     */
    void goBack(long userId);

    /**
     * Shows the amount of an account's balance. 
     * @param balance The balance to show. 
     */
    void setAmount(String balance);

    /**
     * Goes to the page to add transactions.
     * @param accountId The account to add transactions to.
     */
    void goToTransaction(long accountId);

    /**
     * Draw transactions. 
     * @param writable Uses a collection of writable strings to make the transactions list. 
     */
    void drawTransactions(Collection<String> writable);
}
