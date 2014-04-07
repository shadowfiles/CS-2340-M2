package android.cs2340.Views;

import java.util.Collection;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.UserModel;

public interface AccountPageView {

    void goBack(UserModel user);

    void setAmount(String balance);

    void goToTransaction(AccountModel account);

    void drawTransactions(Collection<String> writable);
}
