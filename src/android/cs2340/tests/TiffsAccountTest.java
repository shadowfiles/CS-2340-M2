package android.cs2340.tests;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import android.cs2340.model.Account;
import android.cs2340.model.AccountModel;
import android.cs2340.model.Transaction;
import android.cs2340.model.TransactionModel;
import android.cs2340.model.User;

/**
 * jUnit test for AccountModels.  
 * @author tiff
 * @version 1.0
 * 
 */
public class TiffsAccountTest {

    /**
     * The object being tested.
     */
    AccountModel account;

    /**
     * User name used for testing purposes. 
     */
    private static final String TEST_USERNAME = "test";

    /**
     * Account name for testing purposes.  
     */
    private static final String TEST_ACCOUNT_NAME = "tiff's bank";
    
    /**
     * Display name for testing purposes. 
     */
    private static final String TEST_DISPLAY_NAME = "tiff"; 
    

    /**
     * Set up the test.
     * @throws java.lang.Exception Catching whatever exceptions might occur.
     */
    @Before
    public void setUp() throws Exception {
        account = new Account(1, TEST_ACCOUNT_NAME, TEST_DISPLAY_NAME, 1000.24,
                100.50, new User(1, TEST_USERNAME, "testerizer".hashCode(), "email@email.com"));
    }

    /**
     * Test the getters.
     */
    @Test
    public void testGetters() {
        Assert.assertEquals("Wrong ID", 1, account.getId());
        Assert.assertEquals("Wrong Fullname", TEST_ACCOUNT_NAME, account.getName());
        Assert.assertEquals("Wrong Display Name", TEST_DISPLAY_NAME, account.getDisplayName());
        Assert.assertEquals(1000.24, account.getBalance(), 0.001);
        Assert.assertEquals(100.50, account.getInterest(), 0.001);
        Assert.assertEquals("Wrong username", TEST_USERNAME, account.getOwner().getUsername());
        Assert.assertEquals("Wrong user id", 1, account.getOwner().getId());
    }
    
    /**
     * Test balance.
     */
    @Test
    public void testBalance() {
        account.changeBalance(-100);
        Assert.assertEquals(900.24, account.getBalance(), 0.001);
        
        account.changeBalance(50);
        Assert.assertEquals(950.24, account.getBalance(), 0.001);
    }

    /**
     * Test adding and removing transactions.
     * Duplicate transactions should not be allowed.
     */
    @Test
    public void testAddTransactions() {
        TransactionModel t1 = new Transaction(1, "03/11/1994", "category", 100, account);
        TransactionModel t2 = new Transaction(2, "03/11/1984", "catedgdsg", 100, account);
        TransactionModel t3 = new Transaction(3, "03/11/1974", "cateerw", 100, account);
        TransactionModel t4 = new Transaction(3, "03/11/1964", "catewetwet", 100, account);
        TransactionModel t5 = new Transaction(4, "03/11/1954", "categwtewtte", 100, account);
        account.addTransaction(t1);
        account.addTransaction(t2);
        account.addTransaction(t3);
        account.addTransaction(t4);
        account.addTransaction(t5);
        account.addTransaction(t5);
        
        Collection<TransactionModel> transactions = account.getTransactions();
        Assert.assertEquals("Wrong amount of transactions", 5, transactions.size());
        
        account.addTransactions(transactions);
        transactions = account.getTransactions();
        Assert.assertEquals("Adding all allows duplicates", 5, transactions.size());
        
        account.addTransaction(null);
        transactions = account.getTransactions();
        Assert.assertEquals("Adding null is allowed", 5, transactions.size());       
    }

}
