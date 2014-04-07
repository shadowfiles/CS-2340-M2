package android.cs2340.Model;

/**
 * Model for the UserList. 
 * @author Team 42
 *
 */
public interface UserListModel {

    /**
     * Returns whether a password is valid.
     * @param user The user to check the password on.
     * @param pass The password being checked.
     * @return boolean for whether the passwords match.
     */
    boolean goodPass(final String user, final String pass);

    /**
     * Adds a user to the list.
     * @param name Name of the user being added.
     * @param passone String for the password of the user.
     * @param passtwo String for the second password entered.
     */
    void addUser(final String name, final String passone, final String passtwo);

    /**
     * Adds an account to a user. 
     * @param fullName Full name of the account.
     * @param accountName Account name of the account.
     * @param balance Balance of the account.
     * @param interest Interest rate on the account.
     * @param owner UserModel object the account is being added to.
     * @return UserModel for the User who had an account created.
     */
    UserModel createAccount(String fullName, String accountName,
            double balance, double interest, UserModel owner);

    /**
     * Gets a user from the list.
     * @param user Username of the user.
     * @return UserModel for the user.
     */
    UserModel getUser(String user);
}
