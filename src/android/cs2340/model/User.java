package android.cs2340.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation of User Model. 
 * @author Team 42
 *
 */
public class User implements UserModel {

    /**
     * Unique ID of the user.
     */
    private long id;
    
    /**
     * Username of the user. 
     */
    private String username;
    
    /**
     * Hashed version of the user's password.
     */
    private int password;

    /**
     * The email for the user. 
     */
    private String email;
    
    /**
     * List of all the accounts owned by the user.
     */
    private Collection<AccountModel> accounts;

    /**
     * Alternate Constructor for the User which doesn't define accounts.
     * @param theId long for the ID of the user.
     * @param theUsername String for the username of the User.
     * @param thePassword int for the hashed password.
     * @param e String for the user's email.
     */
    public User(long theId, String theUsername, int thePassword, String e) {
        this(theId, theUsername, thePassword, e, null);
    }

    /**
     * Constructor for the user object.
     * @param theId long for the unique id of the user.
     * @param theUsername String for the username.
     * @param thePassword int for the hashed password.
     * @param e String for the user's email. 
     * @param theaccounts List of the user's accounts.
     */
    public User(long theId, String theUsername, int thePassword, String e, 
            Collection<AccountModel> theaccounts) {
        this.id = theId;
        this.username = theUsername;
        this.password = thePassword;
        this.email = e;
        this.accounts = theaccounts;
    }

    @Override
    public void addAccount(AccountModel account) {
        getAccounts().add(account);
    }

    @Override
    public void addAccounts(Collection<AccountModel> someAccounts) {
        getAccounts().addAll(someAccounts);
    }

    @Override
    public AccountModel getAccount(String name) {
        for (AccountModel a : getAccounts()) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Collection<AccountModel> getAccounts() {
        if (accounts == null) {
            accounts = new ArrayList<AccountModel>();
        }
        return accounts;
    }

    @Override
    public Collection<String> getAccountWriteables() {
        Collection<String> writeables = new ArrayList<String>();
        for (AccountModel a : getAccounts()) {
            writeables.add(a.getWritable());
        }
        return writeables;
    }
    
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public ReportModel getReport(String dateStart, String dateEnd) {
        return new Report(this, dateStart, dateEnd);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getWritable() {
        return this.getUsername();
    }

    @Override
    public int hashCode() {
        return (int) getId();
    }

    @Override
    public boolean verifyPassword(String pass) {
        return pass.hashCode() == this.password;
    }

}
