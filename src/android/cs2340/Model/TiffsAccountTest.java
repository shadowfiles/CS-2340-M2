package android.cs2340.Model;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
     * Set up the test.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        account = new Account(1, "tiff's bank", "tiff", 1000.24,
                100.50, new User(1, "test", "testerizer".hashCode()));
    }

    /**
     * Test the getters.
     */
    @Test
    public void testVariables() {
        Assert.assertEquals("Wrong ID", 1, account.getId());
        Assert.assertEquals("Wrong Fullname", "tiff's bank", account.getName());
        Assert.assertEquals("Wrong Display Name", "tiff", account.getDisplayName());
        Assert.assertEquals(1000.24, account.getBalance(), 0.001);
        Assert.assertEquals(100.50, account.getInterest(), 0.001);
        Assert.assertEquals("Wrong username", "test", account.getOwner().getUsername());
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
        TransactionModel t1 = new Deposit(1, "03/11/1994", "category", 100, account);
        TransactionModel t2 = new Deposit(2, "03/11/1984", "catedgdsg", 100, account);
        TransactionModel t3 = new Deposit(3, "03/11/1974", "cateerw", 100, account);
        TransactionModel t4 = new Deposit(3, "03/11/1964", "catewetwet", 100, account);
        TransactionModel t5 = new Deposit(4, "03/11/1954", "categwtewtte", 100, account);
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
