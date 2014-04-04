package android.cs2340.Views;

import java.util.Collection;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.UserModel;
import android.view.View;

public interface AccountPageView {

    void goBack(UserModel user);

    void makeTransaction(View view);

    void goBack(View view);

    void setAmount(String balance);

    void goToTransaction(AccountModel account);

    void drawTransactions(Collection<String> writable);
}
