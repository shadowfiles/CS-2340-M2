package android.cs2340.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collection;

/**
 * The object representation of a User's Account.
 * @author Team 42
 *
 */
public class Account implements AccountModel, Serializable {

    /**
     * Android required serial ID.
     */
    private static final long serialVersionUID = 1;
    
    /**
     * Unique database ID for a single account. 
     */
    private long id;
    
    /**
     * The display name for the account.
     */
    private String displayName;
    
    /**
     * The account name.
     */
    private String name;
    
    /**
     * The balance on the account.
     */
    private double balance;
    
    /**
     * The interest rate for the account.
     */
    private double interest;
    
    /**
     * A pointer to the owner of the account. 
     */
    private UserModel owner;
    
    /**
     * A list of all of the transactions on the account. 
     */
    private Collection<TransactionModel> transactions = new HashSet<TransactionModel>();

    /**
     * Constructor for a new account.
     * @param anId The unique id of the account.
     * @param aName The account name.
     * @param aDisplayName The display name.
     * @param aBalance The balance.
     * @param anInterest The interest rate.
     * @param anOwner UserModel for the owner of the account.
     */
    public Account(long anId, String aName, String aDisplayName, double aBalance,
            double anInterest, UserModel anOwner) {

        this.id = anId;
        this.owner = anOwner;
        this.displayName = aDisplayName;
        this.name = aName;
        this.balance = aBalance;
        this.interest = anInterest;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public UserModel getOwner() {
        return owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterest() {
        return interest;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void addTransaction(TransactionModel t) {
        if (t != null) {
            transactions.add(t);
        }
    }

    @Override
    public void addTransactions(Collection<TransactionModel> t) {
        if (t != null) {
            transactions.addAll(t);
        }
    }

    @Override
    public void changeBalance(double amount) {
        balance += amount;
    }

    @Override
    public String getWritable() {
        return getName();
    }

    @Override
    public Collection<String> getTransactionWritables() {
        Collection<String> writeables = new ArrayList<String>();
        for (TransactionModel t : transactions) {
            writeables.add(t.getWritable());
        }
        return writeables;
    }

    @Override
    public Collection<TransactionModel> getTransactions() {
        return transactions;
    }

}
