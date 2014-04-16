package android.cs2340.persistence;

import java.util.Collection;

import android.cs2340.model.AccountModel;
import android.cs2340.model.TransactionModel;
import android.cs2340.model.UserModel;

/**
 * Interface for the Transaction DataSource.
 * The interface is supposed to make it easy to 
 * swap out different database systems.
 * @author tiff
 *
 */
public interface TransactionDataSource {
    
    /**
     * Creates a transaction.
     * @param date The date of the transaction.
     * @param source The source of the transaction.
     * @param amount The amount of the transaction.
     * @param account The account. 
     * @param isDeposit Whether the transaction is a deposit. 
     * @return The final transaction. 
     */
    TransactionModel createTransaction(String date, String source,
            double amount, AccountModel account, boolean isDeposit);

    /**
     * Gets a transaction based on id.
     * @param id The id used to identify the transaction.
     * @return The Transaction returned.
     */
    TransactionModel getTransaction(long id);
    
    /**
     * Gets all of the transactions of an account. 
     * @param account The account transactions are being found for. 
     * @return The final list of transactions. 
     */
    Collection<TransactionModel> getTransactions(AccountModel account);   
}