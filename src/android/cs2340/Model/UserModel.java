package android.cs2340.Model;

import java.util.Collection;

/**
 * Model for users in the app.  
 * @author Team 42
 *
 */
public interface UserModel {

    /**
     * Gets the username for a user.
     * @return String for the user's username.
     */
    String getUsername();

    /**
     * Checks to see if a password is valid.
     * @param password String for the password being checked.
     * @return boolean for whether the password matches.
     */
    boolean verifyPassword(String password);

    /**
     * Adds a list of accounts to the UserModel.  
     * @param accounts List of accounts being added.
     */
    void addAccounts(Collection<AccountModel> accounts);

    /**
     * Adds a single account to the UserModel.
     * @param account Account being added.
     */
    void addAccount(AccountModel account);

    /**
     * Gets the unique id for the user.
     * @return long for the id of the user.
     */
    long getId();

    /**
     * Gets all the accounts owned by a user.
     * @return List of the user's accounts.
     */
    Collection<AccountModel> getAccounts();

    /**
     * Gets a single account owned by the user.  
     * @param name String for the name of the account. 
     * @return AccoutModel for the account found. 
     */
    AccountModel getAccount(String name);

    /**
     * Gets a writable String for the user. 
     * @return Writable String.
     */
    String getWritable();

    /**
     * Gets all of the Writable strings for the user's accounts.
     * @return A List of the writable Strings.
     */
    Collection<String> getAccountWriteables();

    /**
     * Gets a report for a User based on a given range.
     * @param dateStart The starting ate for the report.
     * @param dateEnd The ending date for the report.
     * @return The Report generated.
     */
    ReportModel getReport(String dateStart, String dateEnd);
}