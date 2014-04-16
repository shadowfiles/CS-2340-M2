package android.cs2340.persistence;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;
import android.cs2340.model.Account;
import android.cs2340.model.AccountModel;
import android.cs2340.model.TransactionModel;
import android.cs2340.model.UserModel;

import java.util.Collection;
import java.util.ArrayList;

/**
 * Place where the account data comes from.
 * @author tiff
 *
 */
public final class AccountDataTable extends Database implements AccountDataSource {
    /**
     * Database table name for accounts.
     */
    private static final String TABLE = "accounts";
    
    /**
     * The column for full names.
     */
    private static final String FULL_NAME_COLUMN = "full_name";
    
    /**
     * The column for account names.
     */
    private static final String ACCOUNT_NAME_COLUMN = "account_name";
    
    /**
     * The column for balance.
     */
    private static final String BALANCE_COLUMN = "balance";
    
    /**
     * The column for interest. 
     */
    private static final String INTEREST_COLUMN = "interest";
    
    /**
     * Array of all the columns in the database.
     */
    private static String[] allColumns = {ID_COLUMN, FULL_NAME_COLUMN, ACCOUNT_NAME_COLUMN,
        BALANCE_COLUMN, INTEREST_COLUMN, USER_ID_COLUMN};

    /**
     * For interactions with the transactions database. 
     */
    private static TransactionDataSource transactionDataTable;

    /**
     * Constructor for the data source.
     * @param c The Android Context the data source is created in.
     */
    private AccountDataTable() {
        super(getContext());
        if (transactionDataTable == null) {
            transactionDataTable = TransactionDataTable.getSource();
        }
    }

    /**
     * Makes an account data source statically. 
     * @return The AccountDataSource made.
     */
    public static AccountDataSource getSource() {
        AccountDataSource accounts = null;
        if (getContext() != null) {
            accounts = new AccountDataTable(); 
        }
        return accounts;
    }
    
    @Override
    public AccountModel getAccount(long id) {
        open();
        AccountModel account = getAccount(database, id);
        close();
        return account;
    }

    @Override
    public AccountModel changeBalance(AccountModel account, double amount) {
        account.changeBalance(amount);
        open();
        ContentValues values = new ContentValues();
        values.put(BALANCE_COLUMN, doubleToLong(account.getBalance()));
        database.update(TABLE, values, ID_COLUMN + " = " + account.getId(), null);
        close();
        return account;
    }

    @Override
    public AccountModel createAccount(String fullName, String accountName,
            double balance, double interest, UserModel owner) {
        open();
        ContentValues values = new ContentValues();
        values.put(FULL_NAME_COLUMN, fullName);
        values.put(ACCOUNT_NAME_COLUMN, accountName);
        values.put(BALANCE_COLUMN, doubleToLong(balance));
        values.put(INTEREST_COLUMN, doubleToLong(interest));
        values.put(USER_ID_COLUMN, owner.getId());

        long insertId = database.insert(TABLE, null, values);

        AccountModel account = makeAccount(insertId, fullName, accountName,
                balance, interest, owner);
        TransactionModel t = transactionDataTable.createTransaction(
                new SimpleDateFormat("MM/dd/yyyy").format(new Date()),
                "Account Created", balance, account, true);
        account.addTransaction(t);
        close();
        return account;
    }

    @Override
    public TransactionModel createTransaction(String date, String source,
            double amount, AccountModel account, boolean isDeposit) {
        TransactionModel t = transactionDataTable.createTransaction(date,
                source, amount, account, isDeposit);
        account.addTransaction(t);
        changeBalance(account, t.getAmount());
        return t;
    }

    @Override
    public Collection<AccountModel> getAccounts(UserModel user) {
        open();
        Collection<AccountModel> accounts = getAccounts(database, user);
        close();
        return accounts;
    }
    
    /**
     * Gets a single account based on a cursor statically. 
     * @param database The database being searched. 
     * @param cursor The cursor with account information. 
     * @param user The user who owns the account. 
     * @return The account retrieved. 
     */
    protected static AccountModel getAccount(SQLiteDatabase database,
            Cursor cursor, UserModel user) {
        String fullName = cursor.getString(cursor.getColumnIndex(FULL_NAME_COLUMN));
        String accountName = cursor.getString(cursor
                .getColumnIndex(ACCOUNT_NAME_COLUMN));
        double balance = longToDouble(cursor.getLong(cursor
                .getColumnIndex(BALANCE_COLUMN)));
        double interest = longToDouble(cursor.getLong(cursor
                .getColumnIndex(INTEREST_COLUMN)));
        long id = cursor.getLong(cursor.getColumnIndex(ID_COLUMN));
        return makeAccount(id, fullName, accountName, balance, interest, user);
    }

    /**
     * Makes an account object.
     * @param id the id.
     * @param fullName the full name.
     * @param accountName the account name.
     * @param balance balance.
     * @param interest interest.
     * @param user user.
     * @return The Account Model.
     */
    private static AccountModel makeAccount(long id, String fullName, String accountName, 
            double balance, double interest, UserModel user) {
        AccountModel account = new Account(id, fullName, accountName, balance, interest, user);
        account.addTransactions(transactionDataTable.getTransactions(account));
        return account;
    }

    /**
     * Gets an account based on an id statically. 
     * @param database The database used.
     * @param id The id. 
     * @return The Account returned.  
     */
    protected static AccountModel getAccount(SQLiteDatabase database, long id) {
        Cursor cursor = database.query(TABLE, allColumns, ID_COLUMN + " = " + id, null,
                null, null, null);
        cursor.moveToFirst();
        AccountModel account = getAccount(database, cursor);
        cursor.close();
        return account;
    }
    
    /**
     * Gets an account based on a cursor and a database.
     * @param database The database used.
     * @param cursor The cursor used.
     * @return The AccountModel returned. 
     */
    protected static AccountModel getAccount(SQLiteDatabase database, Cursor cursor) {
        long userId = cursor.getLong(cursor.getColumnIndex(USER_ID_COLUMN));
        UserModel user = UserDataTable.getUser(database, userId);
        return getAccount(database, cursor, user);
    }

    /**
     * Gets Accounts based on user statically.  
     * @param database The database being searched. 
     * @param user The user who owns the account. 
     * @return The accounts found. 
     */
    protected static Collection<AccountModel> getAccounts(SQLiteDatabase database,
            UserModel user) {
        Collection<AccountModel> accounts = new ArrayList<AccountModel>();
        Cursor cursor = database.query(TABLE, allColumns,
                USER_ID_COLUMN + " = " + user.getId(), null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            AccountModel a = getAccount(database, cursor, user);

            // Load the transactions into the account data
            Collection<TransactionModel> t = transactionDataTable
                    .getTransactions(a);
            a.addTransactions(t);
            accounts.add(a);
            cursor.moveToNext();
        }
        cursor.close();
        return accounts;
    }

    /**
     * Static method for what happens when a SQLiteDatabase is created.  
     * @param db the SQLiteDatabase being used. 
     */
    protected static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
                + ID_COLUMN + " integer primary key autoincrement, "
                + FULL_NAME_COLUMN + " text not null,  " + ACCOUNT_NAME_COLUMN + " text not null, "
                + BALANCE_COLUMN + " integer not null, " + INTEREST_COLUMN + " integer not null,  "
                + USER_ID_COLUMN + " integer not null" + ");");
    }

    /**
     * Static method for what happens when a SQLiteDatabase is upgraded. 
     * @param db The SQLite database being upgraded. 
     * @param oldVersion The old version of the database. 
     * @param newVersion The new version of the database.
     */
    protected static void onUpgrade(SQLiteDatabase db, int oldVersion,
            int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }
}
