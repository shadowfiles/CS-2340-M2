package android.cs2340.Persistence;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;
import android.cs2340.Model.Account;
import android.cs2340.Model.AccountModel;
import android.cs2340.Model.TransactionModel;
import android.cs2340.Model.UserModel;

import java.util.Collection;
import java.util.ArrayList;

/**
 * Place where the account data comes from.
 * @author tiff
 *
 */
public class AccountDataSource extends AbstractDataSourceFactory {
    /**
     * Database table name for accounts.
     */
    private static final String TABLE = "accounts";
    private static final String FULL_NAME_COLUMN = "full_name";
    private static final String ACCOUNT_NAME_COLUMN = "account_name";
    private static final String BALANCE_COLUMN = "balance";
    private static final String INTEREST_COLUMN = "interest";
    
    /**
     * Array of all the columns in the database.
     */
    private static String[] allColumns = {ID_COLUMN, FULL_NAME_COLUMN, ACCOUNT_NAME_COLUMN,
            BALANCE_COLUMN, INTEREST_COLUMN, USER_ID_COLUMN};

    /**
     * For interactions with the transactions database. 
     */
    private static TransactionDataSource transactionDataSource;

    /**
     * Constructor for the data source.
     * @param c The Android Context the data source is created in.
     */
    public AccountDataSource(Context c) {
        super(c);
        if (transactionDataSource == null) {
            transactionDataSource = new TransactionDataSource(c);
        }
    }

    /**
     * Creates a transaction and adds it to the account. 
     * @param date The date of the transaction.
     * @param source The category of the transaction.
     * @param amount The amount of the transaction.
     * @param account The account of the transaction.
     * @param isDeposit Whether the transaction is a deposit.
     * @return The Transaction created.
     */
    public TransactionModel createTransaction(String date, String source,
            double amount, AccountModel account, boolean isDeposit) {
        TransactionModel t = transactionDataSource.createTransaction(date,
                source, amount, account, isDeposit);
        account.addTransaction(t);
        changeBalance(account, t.getAmount());
        return t;
    }

    /**
     * Update the balance of the account.
     * @param account The account to update.
     * @param amount The amount to change the balance by.
     * @return The AccountModel for the new account with updated balance.
     */
    public AccountModel changeBalance(AccountModel account, double amount) {
        account.changeBalance(amount);
        open();
        ContentValues values = new ContentValues();
        values.put(BALANCE_COLUMN, doubleToInt(account.getBalance()));
        database.update(TABLE, values, ID_COLUMN + " = " + account.getId(), null);
        close();
        return account;
    }

    /**
     * Creates a new account.
     * @param fullName Full name of the new account. 
     * @param accountName The account name of the new account.
     * @param balance The balance of the new account.
     * @param interest The interest of the new account.
     * @param owner The owner of the new account. 
     * @return The AccountModel created.
     */
    public AccountModel createAccount(String fullName, String accountName,
            double balance, double interest, UserModel owner) {
        open();
        ContentValues values = new ContentValues();
        values.put(FULL_NAME_COLUMN, fullName);
        values.put(ACCOUNT_NAME_COLUMN, accountName);
        values.put(BALANCE_COLUMN, doubleToInt(balance));
        values.put(INTEREST_COLUMN, doubleToInt(interest));
        values.put(USER_ID_COLUMN, owner.getId());

        long insertId = database.insert(TABLE, null, values);

        AccountModel account = new Account(insertId, fullName, accountName,
                balance, interest, owner);
        TransactionModel t = transactionDataSource.createTransaction(
                new SimpleDateFormat("MM/dd/yyyy").format(new Date()),
                "Account Created", balance, account, true);
        account.addTransaction(t);
        close();
        return account;
    }

    /**
     * Gets the accounts owned by a user. 
     * @param user The user who owns the accounts. 
     * @return A collection of the accounts found. 
     */
    public Collection<AccountModel> getAccounts(UserModel user) {
        open();
        Collection<AccountModel> accounts = getAccounts(database, user);
        close();
        return accounts;
    }


    /**
     * Static method for what happens when a SQLiteDatabase is created.  
     * @param db the SQLiteDatabase being used. 
     */
    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
                + ID_COLUMN + " integer primary key autoincrement, "
                + FULL_NAME_COLUMN + " text not null, " + ACCOUNT_NAME_COLUMN + " text not null, "
                + BALANCE_COLUMN + " integer not null, " + INTEREST_COLUMN + " integer not null, "
                + USER_ID_COLUMN + " integer not null" + ");");
    }

    /**
     * Static method for what happens when a SQLiteDatabase is upgraded, 
     * @param db The SQLite database being upgraded. 
     * @param oldVersion The old version of the database. 
     * @param newVersion The new version of the database.
     */
    public static void onUpgrade(SQLiteDatabase db, int oldVersion,
            int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

    /**
     * Gets Accounts based on user statically.  
     * @param database The database being searched. 
     * @param user The user who owns the account. 
     * @return The accounts found. 
     */
    public static Collection<AccountModel> getAccounts(SQLiteDatabase database,
            UserModel user) {
        Collection<AccountModel> accounts = new ArrayList<AccountModel>();
        Cursor cursor = database.query(TABLE, allColumns,
                USER_ID_COLUMN + " = " + user.getId(), null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            AccountModel a = getAccount(database, cursor, user);

            // Load the transactions into the account data
            Collection<TransactionModel> t = transactionDataSource
                    .getTransactions(a);
            a.addTransactions(t);
            accounts.add(a);
            cursor.moveToNext();
        }
        cursor.close();
        return accounts;
    }

    /**
     * Gets a single account based on a cursor statically. 
     * @param database The database being searched. 
     * @param cursor The cursor with account information. 
     * @param user The user who owns the account. 
     * @return The account retrieved. 
     */
    private static AccountModel getAccount(SQLiteDatabase database,
            Cursor cursor, UserModel user) {
        String fullName = cursor.getString(cursor.getColumnIndex(FULL_NAME_COLUMN));
        String accountName = cursor.getString(cursor
                .getColumnIndex(ACCOUNT_NAME_COLUMN));
        double balance = longToDouble(cursor.getLong(cursor
                .getColumnIndex(BALANCE_COLUMN)));
        double interest = longToDouble(cursor.getLong(cursor
                .getColumnIndex(INTEREST_COLUMN)));
        long id = cursor.getLong(cursor.getColumnIndex(ID_COLUMN));
        return new Account(id, fullName, accountName, balance, interest, user);
    }
}
