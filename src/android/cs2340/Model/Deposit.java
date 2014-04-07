package android.cs2340.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Deposit implementation of the TransactionModel.
 * @author Team 42
 *
 */
public class Deposit implements TransactionModel, Serializable {
    /**
     * Android required serialization id.
     */
    private static final long serialVersionUID = 1;
    
    /**
     * Unique database id. 
     */
    private long id;
    
    /**
     * The date the Deposit was made.
     */
    private String dateMade;
    
    /**
     * The current date.
     */
    private String currentDate;
    
    /**
     * The category for the deposit.
     */
    private String category;
    
    /**
     * The amount deposited.
     */
    private double amount;
    
    /**
     * The account the transaction is in.
     */
    private AccountModel account;

    /**
     * Constructor for Deposit. 
     * @param anId The id of the deposit.
     * @param theDateMade The date the deposit was made.
     * @param aSource The category of the deposit.
     * @param anAmount The amount of the deposit.
     * @param anAccount The account the deposit is in. 
     */
    public Deposit(long anId, String theDateMade, String aSource, double anAmount,
            AccountModel anAccount) {
        this.id = anId;
        this.currentDate = new SimpleDateFormat("MM/dd/yyyy")
                .format(new Date());
        this.dateMade = theDateMade;
        this.category = aSource;
        this.amount = anAmount;
        this.account = anAccount;
    }

    @Override
    public String getDateMade() {
        return dateMade;
    }

    @Override
    public String getCurrentDate() {
        return currentDate;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getWritable() {
        return dateMade + ": " + category + ", " + amount;
    }

    @Override
    public long getId() {
        return this.id;
    }
    
    @Override
    public AccountModel getAccount() {
        return this.account;
    }
}
