package android.cs2340.Views;

import java.util.Collection;

import android.cs2340.Model.AccountModel;


public interface TransactionPageView {

    double getAmount();

    String getCategory();

    String getDate();

    boolean withdrawalRadioSet();

    boolean depositRadioSet();

    void goToAccount(AccountModel account);

    void setExpandableViewValues(Collection<String> categories);

}
