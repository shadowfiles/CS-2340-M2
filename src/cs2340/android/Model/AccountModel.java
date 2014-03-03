package cs2340.android.Model;

public interface AccountModel {

	User getOwner();
	String getName();
	double getBalance();
	double getIntrest();
	String getDisplayName();
}
