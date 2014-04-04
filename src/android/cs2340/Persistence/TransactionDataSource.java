package android.cs2340.Persistence;

import java.util.ArrayList;
import java.util.Collection;

import android.content.ContentValues;
import android.content.Context;
import android.cs2340.Model.Account;
import android.cs2340.Model.AccountModel;
import android.cs2340.Model.Deposit;
import android.cs2340.Model.TransactionModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Model.Withdrawal;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TransactionDataSource extends DataSource {
	private static final String TABLE = "transactions";
	private static String[] allColumns = {"_id", "account_id", "amount",
		"source", "date", "is_deposit"};
	
	public TransactionDataSource(Context c) {
		super(c);
	}
	
	public TransactionModel createTransaction(String date, String source, 
			double amount, AccountModel account, boolean isDeposit) {		
		open();
		ContentValues values = new ContentValues();
		values.put("account_id", account.getId());
		values.put("amount", doubleToInt(amount));
		values.put("source", source);
		values.put("date", date);
		values.put("is_deposit", isDeposit);
		long insertId = database.insert(TABLE, null, values);
		close();
		
		return makeTransaction(insertId, date, source, amount, account, isDeposit);
	}

	public Collection<TransactionModel> getTransactions(AccountModel account) {
		open();
		Collection<TransactionModel> transactions = getTransactions(database, account);
		close();
		return transactions;
	}
	
	public TransactionModel getTransaction(Cursor cursor, AccountModel owner) {
		return getTransaction(database, cursor, owner);
	}
	
	public static void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
        		+ "_id integer primary key autoincrement, "
        		+ "account_id integer not null, "
        		+ "amount integer not null, "
        		+ "source text not null, "
        		+ "date text not null, "
        		+ "is_deposit integer(1) not null"
        		+ ");"
        		);
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
	}
	
	public static Collection<TransactionModel> getTransactions(
			SQLiteDatabase database, AccountModel account) {
		Collection<TransactionModel> transactions = new ArrayList<TransactionModel>();
		Cursor cursor = database.query(TABLE, allColumns, 
				"account_id = " + account.getId(), null, null, null, null);
		
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
		long id = cursor.getLong(cursor.getColumnIndex("_id"));
		String date = cursor.getString(cursor.getColumnIndex("date"));
		String source = cursor.getString(cursor.getColumnIndex("source"));
		double amount = longToDouble(cursor.getLong(cursor.getColumnIndex("amount")));
		boolean isDeposit = cursor.getLong(cursor.getColumnIndex("is_deposit")) > 0;
		
		return makeTransaction(id, date, source, amount, account, isDeposit);
	}
	
	private static TransactionModel makeTransaction(long id, String date, String source, 
			double amount, AccountModel account, boolean isDeposit) {
		TransactionModel transaction = null;
		if (isDeposit) {
			transaction = new Deposit(id, date, source, amount, account);
		} else {
			transaction = new Withdrawal(id, date, source, amount, account);
		}
		return transaction;
	}
}
