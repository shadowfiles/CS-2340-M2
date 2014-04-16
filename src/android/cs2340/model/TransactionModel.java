package android.cs2340.model;

/**
 * Interface for Transactions.
 * @author Team 42
 *
 */
public interface TransactionModel {

    /**
     * Gets the Account that holds the transaction.
     * @return AccountModel for the account. 
     */
    AccountModel getAccount();

    /**
     * Get the amount of the transaction. 
     * @return double for the amount of transaction.
     */
    double getAmount();

    /**
     * Get the category of the transaction.
     * @return String for the category.
     */
    String getCategory();

    /**
     * Get the current date.
     * @return String for the current date.
     */
    String getCurrentDate();

    /**
     * Get the date the transaction was made.
     * @return String for the date of transaction.
     */
    String getDateMade();

    /**
     * Gets the unique database id of the transaction. 
     * @return long for the unique id of the transaction.
     */
    long getId();

    /**
     * Get a Writable String for the transaction.
     * @return String that's used as a Writable identifier. 
     */
    String getWritable();

    /**
     * Whether the transaction is a deposit.
     * @return boolean for whether the transaction is a deposit.
     */
    boolean isDeposit();
}
