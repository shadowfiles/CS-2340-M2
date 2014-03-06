package cs2340.android.Model;

import java.util.Date;
import java.util.UUID;

public class Transaction {
	
	private TransactionType type;
	private double value;
	private Date dateAdded;
	private Date dateProcessed;
	private String comment;
	private final UUID transactionID;

	// enum for enforcement to be used to classify this transaction
	public enum TransactionType {WITHDRAW, DEPOSIT}
	
	/**
	 * Constructs a new Transaction.
	 *
	 * @param type type of transaction
	 * @param value amount of the transaction
	 * @param dateAdded date the transaction was created
	 * @param dateProcessed date the transaction was processed
	 * @param comment comment for the transaction
	 * @param transactionID randomly created transaction ID
	 */
	public Transaction(TransactionType type, double value, Date dateAdded, Date dateProcessed, String comment) {
		this.type = type;
		this.value = value;
		this.dateAdded = dateAdded;
		this.dateProcessed = dateProcessed;
		this.comment = comment;
		transactionID = UUID.randomUUID();
	}
	
	/**
	 * Returns type of transaction
	 *
	 * @return type of transaction
	 */
	public TransactionType getType() {
		return type;
	}

	/**
	 * Returns the amount of the transaction
	 *
	 * @return amount of the transaction
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Returns date the transaction was created
	 *
	 * @return date the transaction was created
	 */
	public Date getDateAdded() {
		return dateAdded;
	}

	/**
	 * Returns date the transaction was processed
	 *
	 * @return date the transaction was processed
	 */
	public Date getDateProcessed() {
		return dateProcessed;
	}

	/**
	 * Returns comment for the transaction
	 *
	 * @return comment for the transaction
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Returns randomly created transaction ID
	 *
	 * @return randomly created transaction ID
	 */
	public String getTransactionID() {
		return transactionID.toString();
	}
}
