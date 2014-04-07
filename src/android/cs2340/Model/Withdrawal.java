package android.cs2340.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Withdrawal implementation of the TransactionModel.
 * @author Team42
 *
 */
public class Withdrawal implements TransactionModel, Serializable {
    /**
     * Android required serialization id.
     */
    private static final long serialVersionUID = 1;
    
    /**
     * Unique database id. 
     */
    private long id;
    
    /**
     * The date the Withdrawal was made.
     */
    private String dateMade;
    
    /**
     * The current date.
     */
    private String currentDate;
    
    /**
     * The category for the withdrawal.
     */
    private String category;
    
    /**
     * The amount withdrawn.
     */
    private double amount;
    
    /**
     * The account the transaction is in.
     */
    private AccountModel account;

    /**
     * Constructor for Withdrawal. 
     * @param anId The id of the withdrawal.
     * @param theDateMade The date the withdrawal was made.
     * @param aSource The category of the withdrawal.
     * @param anAmount The amount of the withdrawal.
     * @param anAccount The account the withdrawal is in. 
     */
    public Withdrawal(long anId, String theDateMade, String aSource, double anAmount,
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
