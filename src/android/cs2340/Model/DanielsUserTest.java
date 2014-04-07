package cs2340.android.Model;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Daniel
 * @version 1.0
 *
 */


public class DanielsUserTest {
	/**
	 *The test Fixture
	 */
	User theUser;
	/**
	 * run before to set up theUser
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		theUser = new User(1, "testUser", "testPass".hashCode());
	}
	
	/**
	 * Test construction and getters
	 */
	@Test
	public void testVariables() {
		Assert.assertEquals("Wrong ID", 1, theUser.getId());
		Assert.assertEquals("Wrong Name", "testUser", theUser.getUsername());
		Assert.assertEquals("Wrong Pass", "testPass".hashCode(), theUser.getPassword());
		Assert.assertEquals("Didn't make accountList Correct", new ArrayList<Account>(), theUser.getAccounts());

	}
	
	/**
	 * Test creating User
	 */
	@Test
	public void TestVerifyPass() {
		Assert.assertEquals(true, theUser.verifyPassword("testPass"));
	}
	
	/**
	 * Test getAccount
	 */
	@Test
	public void TestGetAccounts() {
		Account one = new Account(1, "testOne", "One", 100, 1, null);
		Account two = new Account(2, "testTwo", "Two", 200, 2, theUser);
		ArrayList<AccountModel> accountList = new ArrayList<AccountModel>();
		accountList.add(one);
		accountList.add(two);
		theUser = new User(1, "test", "test".hashCode(), accountList);
		Assert.assertEquals("didnt get accounts right", accountList, theUser.getAccounts());
	}
	
	@Test
	public void TestGetAccount() {
		Account one = new Account(1, "testOne", "One", 100, 1, null);
		Account two = new Account(2, "testTwo", "Two", 200, 2, theUser);
		ArrayList<AccountModel> accountList = new ArrayList<AccountModel>();
		accountList.add(one);
		accountList.add(two);
		theUser = new User(1, "test", "test".hashCode(), accountList);
		Assert.assertEquals("didnt get accounts one", one, theUser.getAccount("testOne"));
		Assert.assertEquals("didnt get accounts two", two, theUser.getAccount("testTwo"));
		Assert.assertEquals("didnt get accounts null", null, theUser.getAccount("NOPE"));
	}
	
	/**
	 * Test Account adding in group to empty set, and adding NUll
	 */
	@Test
	public void TestAddAccountAndAddNull() {
		Account one = new Account(1, "testOne", "One", 100, 1, null);
		ArrayList<AccountModel> accountList = new ArrayList<AccountModel>();
		accountList.add(null);
		theUser.addAccount(null);
		Assert.assertEquals("Failed adding multiple accounts in group to empty User",accountList, theUser.getAccounts());
		accountList.add(one);
		theUser.addAccount(one);
		Assert.assertEquals("Failed adding multiple accounts in group to empty User",accountList, theUser.getAccounts());
		

	}
	
	/**
	 * Test Account adding in group to empty set
	 */
	@Test
	public void TestAddAccounts() {
		Account one = new Account(1, "testOne", "One", 100, 1, null);
		Account two = new Account(2, "testTwo", "Two", 200, 2, theUser);
		ArrayList<AccountModel> accountList = new ArrayList<AccountModel>();
		accountList.add(one);
		accountList.add(two);
		theUser.addAccounts(accountList);
		Assert.assertEquals("Failed adding multiple accounts in group to empty User",accountList, theUser.getAccounts());
	}
	
	/**
	 * Test Getting AccountWritabe ArrayList
	 */
	@Test
	public void TestAccWritables() {
		Account one = new Account(1, "testOne", "One", 100, 1, null);
		Account two = new Account(2, "testTwo", "Two", 200, 2, theUser);
		ArrayList<String> accountList = new ArrayList<String>();
		accountList.add(one.getWritable());
		accountList.add(two.getWritable());
		theUser.addAccount(one);
		theUser.addAccount(two);
		Assert.assertEquals("Failed Account Writable", accountList, theUser.getAccountWriteables());
	}
	
	/**
	 * Test writable
	 */
	@Test
	public void TestUserWritable() {
		Assert.assertEquals("Failed User Writable", 1, theUser.getId());

	}
	
	//can not test report generation due giant string that is the Report
	 
}
