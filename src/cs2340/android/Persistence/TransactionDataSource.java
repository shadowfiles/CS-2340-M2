package cs2340.android.Persistence;

import java.util.ArrayList;
import java.util.Collection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cs2340.android.Model.Account;
import cs2340.android.Model.AccountModel;
import cs2340.android.Model.TransactionAbstract;
import cs2340.android.Model.Deposit;
import cs2340.android.Model.UserModel;
import cs2340.android.Model.Withdrawal;

public class TransactionDataSource extends DataSource {
	private static final String TABLE = "transactions";
	private static String[] allColumns = {"_id", "account_id", "amount",
		"source", "date", "is_deposit"};
	
	public TransactionDataSource(Context c) {
		super(c);
	}
	
	public TransactionAbstract createTransaction(String date, String source, 
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

	public Collection<TransactionAbstract> getTransactions(AccountModel account) {
		open();
		Collection<TransactionAbstract> transactions = getTransactions(database, account);
		close();
		return transactions;
	}
	
	public TransactionAbstract getTransaction(Cursor cursor, AccountModel owner) {
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
	
	public static Collection<TransactionAbstract> getTransactions(
			SQLiteDatabase database, AccountModel account) {
		Collection<TransactionAbstract> transactions = new ArrayList<TransactionAbstract>();
		Cursor cursor = database.query(TABLE, allColumns, 
				"account_id = " + account.getId(), null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			TransactionAbstract t = getTransaction(database, cursor, account);
			transactions.add(t);
			cursor.moveToNext();
		}
		cursor.close();
		return transactions;
	}
	
	private static TransactionAbstract getTransaction(SQLiteDatabase database, 
			Cursor cursor, AccountModel account) {
		long id = cursor.getLong(cursor.getColumnIndex("_id"));
		String date = cursor.getString(cursor.getColumnIndex("date"));
		String source = cursor.getString(cursor.getColumnIndex("source"));
		double amount = longToDouble(cursor.getLong(cursor.getColumnIndex("amount")));
		boolean isDeposit = cursor.getLong(cursor.getColumnIndex("is_deposit")) > 0;
		
		return makeTransaction(id, date, source, amount, account, isDeposit);
	}
	
	private static TransactionAbstract makeTransaction(long id, String date, String source, 
			double amount, AccountModel account, boolean isDeposit) {
		TransactionAbstract transaction = null;
		if (isDeposit) {
			transaction = new Deposit(id, date, source, amount, account);
		} else {
			transaction = new Withdrawal(id, date, source, amount, account);
		}
		return transaction;
	}
}
