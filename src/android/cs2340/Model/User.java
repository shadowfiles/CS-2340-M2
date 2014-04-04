package android.cs2340.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class User implements UserModel, Serializable {

    // HASH THE PASSWORD
    private static final long serialVersionUID = 1;
    private long id;
    private String username;
    private int password;
    private Collection<AccountModel> Accounts;

    public User(long id, String username, int password,
            Collection<AccountModel> accounts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.Accounts = accounts;
    }

    public User(long id, String username, int password) {
        this(id, username, password, null);
    }

    public boolean verifyPassword(String pass) {
        return pass.hashCode() == this.password;
    }

    public long getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void addAccounts(Collection<AccountModel> accounts) {
        getAccounts().addAll(accounts);
    }

    public void addAccount(AccountModel account) {
        getAccounts().add(account);
    }

    public AccountModel getAccount(String name) {
        for (AccountModel a : getAccounts()) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    public Collection<AccountModel> getAccounts() {
        if (Accounts == null) {
            Accounts = new ArrayList<AccountModel>();
        }
        return Accounts;
    }

    public Collection<String> getAccountWriteables() {
        Collection<String> writeables = new ArrayList<String>();
        for (AccountModel a : getAccounts()) {
            writeables.add(a.getWritable());
        }
        return writeables;
    }

    @Override
    public String GetWritable() {
        return username;
    }

    @Override
    public ReportModel getReport(String dateStart, String dateEnd) {
        return new SpendingCategoryReport(this, dateStart, dateEnd);
    }

    @Override
    public int hashCode() {
        return (int) getId();
    }

}
