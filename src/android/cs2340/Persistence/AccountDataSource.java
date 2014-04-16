package android.cs2340.Persistence;

import java.util.Collection;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.TransactionModel;
import android.cs2340.Model.UserModel;

/**
 * Interface for the AccountDataSource. Meant to allow easy swapping out of
 * persistence systems.
 * @author tiff
 *
 */
public interface AccountDataSource {
    /**
     * Update the balance of the account.
     * @param account The account to update.
     * @param amount The amount to change the balance by.
     * @return The AccountModel for the new account with updated balance.
     */
    AccountModel changeBalance(AccountModel account, double amount);
    
    /**
     * Creates a new account.
     * @param fullName Full name of the new account. 
     * @param accountName The account name of the new account.
     * @param balance The balance of the new account.
     * @param interest The interest of the new account.
     * @param owner The owner of the new account. 
     * @return The AccountModel created.
     */
    AccountModel createAccount(String fullName, String accountName,
            double balance, double interest, UserModel owner);
    
    /**
     * Creates a transaction and adds it to the account.
     * 
     * @param date The date of the transaction.
     * @param source The category of the transaction.
     * @param amount The amount of the transaction.
     * @param account The account of the transaction.
     * @param isDeposit Whether the transaction is a deposit.
     * @return The Transaction created.
     */
    TransactionModel createTransaction(String date, String source,
            double amount, AccountModel account, boolean isDeposit);
    
    /**
     * Gets an account based on id.
     * @param id The id used to identify the account.
     * @return The Account returned.
     */
    AccountModel getAccount(long id);
    
    /**
     * Gets the accounts owned by a user. 
     * @param user The user who owns the accounts. 
     * @return A collection of the accounts found. 
     */
    Collection<AccountModel> getAccounts(UserModel user);
}
