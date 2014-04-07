package android.cs2340.Model;

/**
 * Interface for Transactions.
 * @author Team 42
 *
 */
public interface TransactionModel {

    /**
     * Get the date the transaction was made.
     * @return String for the date of transaction.
     */
    String getDateMade();

    /**
     * Get the current date.
     * @return String for the current date.
     */
    String getCurrentDate();

    /**
     * Get the category of the transaction.
     * @return String for the category.
     */
    String getCategory();

    /**
     * Get the amount of the transaction. 
     * @return double for the amount of transaction.
     */
    double getAmount();

    /**
     * Get a Writable String for the transaction.
     * @return String that's used as a Writable identifier. 
     */
    String getWritable();

    /**
     * Gets the unique database id of the transaction. 
     * @return long for the unique id of the transaction.
     */
    long getId();

    /**
     * Gets the Account that holds the transaction.
     * @return AccountModel for the account. 
     */
    AccountModel getAccount();
}
