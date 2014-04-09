package android.cs2340.Persistence;

import java.util.ArrayList;
import java.util.Collection;

import android.content.ContentValues;
import android.content.Context;
import android.cs2340.Model.AccountModel;
import android.cs2340.Model.Deposit;
import android.cs2340.Model.TransactionModel;
import android.cs2340.Model.Withdrawal;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TransactionDataSource extends DataSource {
    private static final String TABLE = "transactions";
    private static final String AMOUNT_COLUMN = "amount";
    private static final String CATEGORY_COLUMN = "source";
    private static final String DATE_COLUMN = "date";
    private static final String DEPOSIT_COLUMN = "is_deposit";
    
    
    private static String[] allColumns = { ID_COLUMN, ACCOUNT_ID_COLUMN, AMOUNT_COLUMN,
        CATEGORY_COLUMN, DATE_COLUMN, DEPOSIT_COLUMN };

    public TransactionDataSource(Context c) {
        super(c);
    }

    public TransactionModel createTransaction(String date, String source,
            double amount, AccountModel account, boolean isDeposit) {
        open();
        ContentValues values = new ContentValues();
        values.put(ACCOUNT_ID_COLUMN, account.getId());
        values.put(AMOUNT_COLUMN, doubleToInt(amount));
        values.put(CATEGORY_COLUMN, source);
        values.put(DATE_COLUMN, date);
        values.put(DEPOSIT_COLUMN, isDeposit);
        long insertId = database.insert(TABLE, null, values);
        close();

        return makeTransaction(insertId, date, source, amount, account,
                isDeposit);
    }

    public Collection<TransactionModel> getTransactions(AccountModel account) {
        open();
        Collection<TransactionModel> transactions = getTransactions(database,
                account);
        close();
        return transactions;
    }

    public TransactionModel getTransaction(Cursor cursor, AccountModel owner) {
        return getTransaction(database, cursor, owner);
    }

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
                + ID_COLUMN + " integer primary key autoincrement, "
                + ACCOUNT_ID_COLUMN + " integer not null, " + AMOUNT_COLUMN + " integer not null, "
                + CATEGORY_COLUMN + " text not null, " + DATE_COLUMN + " text not null, "
                + DEPOSIT_COLUMN + " integer(1) not null" + ");");
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion,
            int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

    public static Collection<TransactionModel> getTransactions(
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

    private static TransactionModel makeTransaction(long id, String date,
            String source, double amount, AccountModel account,
            boolean isDeposit) {
        TransactionModel transaction = null;
        if (isDeposit) {
            transaction = new Deposit(id, date, source, amount, account);
        } else {
            transaction = new Withdrawal(id, date, source, amount, account);
        }
        return transaction;
    }
}
