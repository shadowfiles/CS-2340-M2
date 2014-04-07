package android.cs2340.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation of User Model. 
 * @author Team 42
 *
 */
public class User implements UserModel, Serializable {

    /**
     * Android required serialization ID.
     */
    private static final long serialVersionUID = 1;
    
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
     * List of all the accounts owned by the user.
     */
    private Collection<AccountModel> accounts;

    /**
     * Constructor for the user object.
     * @param theId long for the unique id of the user.
     * @param theUsername String for the username.
     * @param thePassword int for the hashed password. 
     * @param theaccounts List of the user's accounts.
     */
    public User(long theId, String theUsername, int thePassword,
            Collection<AccountModel> theaccounts) {
        this.id = theId;
        this.username = theUsername;
        this.password = thePassword;
        this.accounts = theaccounts;
    }

    /**
     * Alternate Constructor for the User which doesn't define accounts.
     * @param theId long for the ID of the user.
     * @param theUsername String for the username of the User.
     * @param thePassword int for the hashed password.
     */
    public User(long theId, String theUsername, int thePassword) {
        this(theId, theUsername, thePassword, null);
    }

    @Override
    public boolean verifyPassword(String pass) {
        return pass.hashCode() == this.password;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void addAccounts(Collection<AccountModel> someAccounts) {
        getAccounts().addAll(someAccounts);
    }

    @Override
    public void addAccount(AccountModel account) {
        getAccounts().add(account);
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
    public String getWritable() {
        return this.getUsername();
    }

    @Override
    public ReportModel getReport(String dateStart, String dateEnd) {
        return new SpendingCategoryReport(this, dateStart, dateEnd);
    }

    @Override
    public int hashCode() {
        return (int) getId();
    }

}
