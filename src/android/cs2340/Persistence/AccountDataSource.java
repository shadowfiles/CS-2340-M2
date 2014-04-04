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

public class AccountDataSource extends DataSource {
    private static final String TABLE = "accounts";
    private static String[] allColumns = { "_id", "full_name", "account_name",
            "balance", "interest", "user_id" };
    private static TransactionDataSource transactionDataSource;

    public AccountDataSource(Context c) {
        super(c);
        if (transactionDataSource == null) {
            transactionDataSource = new TransactionDataSource(c);
        }
    }

    public TransactionModel createTransaction(String date, String source,
            double amount, AccountModel account, boolean isDeposit) {
        TransactionModel t = transactionDataSource.createTransaction(date,
                source, amount, account, isDeposit);
        account.addTransaction(t);
        changeBalance(account, t.getAmount());
        return t;
    }

    public AccountModel changeBalance(AccountModel account, double amount) {
        account.changeBalance(amount);
        open();
        ContentValues values = new ContentValues();
        values.put("balance", doubleToInt(account.getBalance()));
        database.update(TABLE, values, "_id = " + account.getId(), null);
        close();
        return account;
    }

    public AccountModel createAccount(String fullName, String accountName,
            double balance, double interest, UserModel owner) {
        open();
        ContentValues values = new ContentValues();
        values.put("full_name", fullName);
        values.put("account_name", accountName);
        values.put("balance", doubleToInt(balance));
        values.put("interest", doubleToInt(interest));
        values.put("user_id", owner.getId());

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

    public Collection<AccountModel> getAccounts(UserModel user) {
        open();
        Collection<AccountModel> accounts = getAccounts(database, user);
        close();
        return accounts;
    }

    public AccountModel getAccount(Cursor cursor, UserModel owner) {
        open();
        AccountModel account = getAccount(database, cursor, owner);
        close();
        return account;
    }

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
                + "_id integer primary key autoincrement, "
                + "full_name text not null, " + "account_name text not null, "
                + "balance integer not null, " + "interest integer not null, "
                + "user_id integer not null" + ");");
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion,
            int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

    public static Collection<AccountModel> getAccounts(SQLiteDatabase database,
            UserModel user) {
        Collection<AccountModel> accounts = new ArrayList<AccountModel>();
        Cursor cursor = database.query(TABLE, allColumns,
                "user_id = " + user.getId(), null, null, null, null);

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

    private static AccountModel getAccount(SQLiteDatabase database,
            Cursor cursor, UserModel user) {
        String fullName = cursor.getString(cursor.getColumnIndex("full_name"));
        String accountName = cursor.getString(cursor
                .getColumnIndex("account_name"));
        double balance = longToDouble(cursor.getLong(cursor
                .getColumnIndex("balance")));
        double interest = longToDouble(cursor.getLong(cursor
                .getColumnIndex("interest")));
        long id = cursor.getLong(cursor.getColumnIndex("_id"));
        return new Account(id, fullName, accountName, balance, interest, user);
    }
}
