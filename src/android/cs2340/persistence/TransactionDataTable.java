package android.cs2340.persistence;

import java.util.ArrayList;
import java.util.Collection;

import android.content.ContentValues;
import android.content.Context;
import android.cs2340.model.AccountModel;
import android.cs2340.model.Transaction;
import android.cs2340.model.TransactionModel;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Data source for the transaction objects.   
 * @author tiff
 *
 */
public class TransactionDataTable extends Database implements TransactionDataSource {
    /**
     * The table for transactions. 
     */
    private static final String TABLE = "transactions";
    
    /**
     * The column for amounts.
     */
    private static final String AMOUNT_COLUMN = "amount";
    
    /**
     * The column for the source.
     */
    private static final String CATEGORY_COLUMN = "source";
    
    /**
     * The column for the date.
     */
    private static final String DATE_COLUMN = "date";
    
    /**
     * The column for whether the transaction is a deposit.
     */
    private static final String DEPOSIT_COLUMN = "is_deposit";
    
    
    /**
     * An array of all the columns.
     */
    private static String[] allColumns = {ID_COLUMN, ACCOUNT_ID_COLUMN, AMOUNT_COLUMN,
        CATEGORY_COLUMN, DATE_COLUMN, DEPOSIT_COLUMN};

    /**
     * Constructor for the data source.
     */
    private TransactionDataTable() {
        super(getContext());
    }

    /**
     * Makes an account data source statically. 
     * @return The AccountDataSource made.
     */
    public static TransactionDataSource getSource() {
        TransactionDataSource trans = null;
        if (getContext() != null) {
            trans = new TransactionDataTable(); 
        }
        return trans;
    }

    @Override
    public TransactionModel getTransaction(long id) {
        return null;
    }
    
    @Override
    public TransactionModel createTransaction(String date, String source,
            double amount, AccountModel account, boolean isDeposit) {
        open();
        ContentValues values = new ContentValues();
        values.put(ACCOUNT_ID_COLUMN, account.getId());
        values.put(AMOUNT_COLUMN, doubleToLong(amount));
        values.put(CATEGORY_COLUMN, source);
        values.put(DATE_COLUMN, date);
        values.put(DEPOSIT_COLUMN, isDeposit);
        long insertId = database.insert(TABLE, null, values);
        close();

        return makeTransaction(insertId, date, source, amount, account,
                isDeposit);
    }

    @Override
    public Collection<TransactionModel> getTransactions(AccountModel account) {
        open();
        Collection<TransactionModel> transactions = getTransactions(database,
                account);
        close();
        return transactions;
    }

    /**
     * Gets a transaction based on a cursor.
     * @param database The database being used.
     * @param cursor The cursor being used.
     * @param account The account owning the transaction.
     * @return The final TransactionModel.
     */
    private static TransactionModel getTransaction(SQLiteDatabase database,
            Cursor cursor, AccountModel account) {
        long id = cursor.getLong(cursor.getColumnIndex(ID_COLUMN));
        String date = cursor.getString(cursor.getColumnIndex(DATE_COLUMN));
        String source = cursor.getString(cursor.getColumnIndex(CATEGORY_COLUMN));
        double amount = longToDouble(cursor.getLong(cursor
                .getColumnIndex(AMOUNT_COLUMN)));
        boolean isDeposit = cursor.getLong(cursor.getColumnIndex(DEPOSIT_COLUMN)) > 0;

        return makeTransaction(id, date, source, amount, account, isDeposit);
    }

    /**
     * Makes a transaction based on data. 
     * @param id The id of the transaction.
     * @param date The date the transaction was made.
     * @param source The category for the transaction. 
     * @param amount The amount of the transaction.
     * @param account The account owning the transaction.
     * @param isDeposit Whether the transaction is a deposit. 
     * @return The transaction model created. 
     */
    private static TransactionModel makeTransaction(long id, String date,
            String source, double amount, AccountModel account,
            boolean isDeposit) {
        TransactionModel transaction = null;        
        double theAmount = amount;
        if (!isDeposit) {
            theAmount = -amount;
        }
        transaction = new Transaction(id, date, source, theAmount, account);
        return transaction;
    }

    /**
     * Gets the transactions from an account. 
     * @param database The database being searched.
     * @param account The account being searched for. 
     * @return The list of all the transactions owned by the account.
     */
    protected static Collection<TransactionModel> getTransactions(
            SQLiteDatabase database, AccountModel account) {
        Collection<TransactionModel> transactions = new ArrayList<TransactionModel>();
        Cursor cursor = database.query(TABLE, allColumns, ACCOUNT_ID_COLUMN + " = "
                + account.getId(), null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            TransactionModel t = getTransaction(database, cursor, account);
            transactions.add(t);
            cursor.moveToNext();
        }
        cursor.close();
        return transactions;
    }
    
    /**
     * What happens when the database is made. 
     * @param db The database for the transaction table.
     */
    protected static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
                + ID_COLUMN + " integer primary key autoincrement, "
                + ACCOUNT_ID_COLUMN + " integer not null,  " + AMOUNT_COLUMN + " integer not null, "
                + CATEGORY_COLUMN + " text not null,  " + DATE_COLUMN + " text not null, "
                + DEPOSIT_COLUMN + " integer(1) not null" + ");");
    }

    /**
     * What happens when the database is upgraded.
     * @param db The database being upgraded.
     * @param oldVersion The old version of the database.
     * @param newVersion The new version of the database.
     */
    protected static void onUpgrade(SQLiteDatabase db, int oldVersion,
            int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }
}
