package android.cs2340.Model;

import java.util.Collection;

public interface AccountModel {

    UserModel getOwner();

    long getId();

    String getName();

    double getBalance();

    double getInterest();

    String getDisplayName();

    void changeBalance(double amount);

    void addTransaction(TransactionModel t);

    void addTransactions(Collection<TransactionModel> t);

    String getWritable();

    Collection<String> getTransactionWritables();

    Collection<TransactionModel> getTransactions();
}
