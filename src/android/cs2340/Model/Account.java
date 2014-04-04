package android.cs2340.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Account implements AccountModel, Serializable {

    private static final long serialVersionUID = 1;
    private long id;
    private String displayName;
    private String name;
    private double balance;
    private double interest;
    private UserModel owner;
    private Collection<TransactionModel> transactions = new ArrayList<TransactionModel>();

    public Account(long id, String name, String displayName, double balance,
            double interest, UserModel owner) {

        this.id = id;
        this.owner = owner;
        this.displayName = displayName;
        this.name = name;
        this.balance = balance;
        this.interest = interest;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public UserModel getOwner() {
        return owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterest() {
        return interest;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void addTransaction(TransactionModel t) {
        transactions.add(t);
    }

    @Override
    public void addTransactions(Collection<TransactionModel> t) {
        transactions.addAll(t);
    }

    @Override
    public void changeBalance(double amount) {
        balance += amount;
    }

    @Override
    public String getWritable() {
        return name;
    }

    @Override
    public Collection<String> getTransactionWritables() {
        Collection<String> writeables = new ArrayList<String>();
        for (TransactionModel t : transactions) {
            writeables.add(t.getWritable());
        }
        return writeables;
    }

    public Collection<TransactionModel> getTransactions() {
        return transactions;
    }

}
