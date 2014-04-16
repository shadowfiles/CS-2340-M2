package android.cs2340.Model;

import java.util.Collection;

/**
 * The Model to represent the Account concept. 
 * @author Team 42
 *
 */
public interface AccountModel {

    /**
     * Gets the owner of an account. 
     * @return A UserModel representing the account owner. 
     */
    UserModel getOwner();

    /**
     * Gets the id of the account.
     * @return A long representing the account's unique id. 
     */
    long getId();

    /**
     * Gets the name of the account.
     * @return A String for the name of the account.
     */
    String getName();

    /**
     * Gets the balance of the account.
     * @return A double for the balance of the account.
     */
    double getBalance();

    /**
     * Displays the balance.
     * @return A String formatted with the balance.
     */
    String showBalance();

    /**
     * Get the interest rate of the account. 
     * @return A double for the interest rate on the account.
     */
    double getInterest();

    /**
     * Get the display name of the account.
     * @return A String for the account's display name.
     */
    String getDisplayName();

    /**
     * Changes the balance on the account.
     * @param amount The amount to add or subtract from the balance.
     */
    void changeBalance(double amount);

    /**
     * Add a transaction to an Account.
     * @param t A TransacitonModel holding data to be added to the account. 
     */
    void addTransaction(TransactionModel t);

    /**
     * Add multiple transactions to the account.
     * @param t A list of the transactions to add.
     */
    void addTransactions(Collection<TransactionModel> t);

    /**
     * Gets a writable name for the account.
     * @return String used as a writable name. 
     */
    String getWritable();

    /**
     * Get the Writable names for the transactions.  
     * @return A list of the writable names.
     */
    Collection<String> getTransactionWritables();

    /**
     * Get all of the transactions in an account. 
     * @return A list of the transactions.
     */
    Collection<TransactionModel> getTransactions();
}
