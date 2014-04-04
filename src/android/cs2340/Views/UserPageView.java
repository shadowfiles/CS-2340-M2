package android.cs2340.Views;

import java.util.Collection;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.UserModel;

public interface UserPageView {

    void goToAddAccount(UserModel theUser);

    void goToIntro();

    void goToAccount(AccountModel account);

    void drawAccounts(Collection<String> writable);

    void goToCreateSpendingReport(UserModel user);

}
