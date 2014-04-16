package android.cs2340.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for representing a transaction. 
 * @author tiff
 *
 */
public class Transaction implements TransactionModel {
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
    private MoneyModel amount;
    
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
    public Transaction(long anId, String theDateMade, String aSource, double anAmount,
            AccountModel anAccount) {
        this.id = anId;
        this.currentDate = new SimpleDateFormat("MM/dd/yyyy")
                .format(new Date());
        this.dateMade = theDateMade;
        this.category = aSource;
        this.amount = new Money(anAmount);
        this.account = anAccount;
    }

    @Override
    public AccountModel getAccount() {
        return this.account;
    }

    @Override
    public double getAmount() {
        return amount.get();
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getCurrentDate() {
        return currentDate;
    }
    
    @Override
    public String getDateMade() {
        return dateMade;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getWritable() {
        return dateMade + ": " + category + ", " + amount.toString();
    }
    
    @Override
    public boolean isDeposit() {
        return amount.get() >= 0;
    }
}