package android.cs2340.Model;

import java.util.HashMap;

import android.content.Context;
import android.cs2340.Persistence.AccountDataSource;
import android.cs2340.Persistence.UserDataSource;

/**
 * List of all users in the application.
 * @author Team 42
 *
 */
public class UserList implements UserListModel {

    /**
     * Static instance variable for implementing Singleton.
     */
    private static UserList instance;
    
    /**
     * A Map of the users, keying them by their username.
     */
    private HashMap<String, UserModel> users;
    
    /**
     * Persistence for users. 
     */
    private UserDataSource dataSource;
    
    /**
     * Persistence for Accounts.
     */
    private AccountDataSource accountDataSource;

    /**
     * Private constructor for UserList for Singleton. 
     * @param c Android Context used to initialize UserList. 
     */
    private UserList(Context c) {
        dataSource = new UserDataSource(c);
        users = dataSource.getAllUsers();
        accountDataSource = new AccountDataSource(c);
    }

    /**
     * Gets the UserList instance object.
     * @param c The Context used to construct the UserList.
     * @return A single instance of UserList.
     */
    public static UserList getInstance(Context c) {
        if (instance == null) {
            instance = new UserList(c);
        }
        return instance;
    }

    @Override
    public UserModel getUser(String username) {
        UserModel user = users.get(username);
        return user;
    }

    @Override
    public boolean goodPass(String username, String pass) {
        UserModel user = getUser(username);
        return user != null && user.verifyPassword(pass);
    }

    @Override
    public UserModel createAccount(String fullName, String accountName,
            double balance, double interest, UserModel owner) {
        UserModel user = getUser(owner.getUsername());
        AccountModel account = accountDataSource.createAccount(fullName,
                accountName, balance, interest, user);
        user.addAccount(account);
        return user;
    }

    @Override
    public void addUser(String username, String passone, String passtwo) {
        if (passone.equals(passtwo) && !users.containsKey(username.hashCode())) {
            // Add the user to the database
            UserModel user = dataSource.createUser(username, passone);

            // Then put them in the UserList
            users.put(username, user);
        }
        // ELSE RETURN ERROR
    }

}
