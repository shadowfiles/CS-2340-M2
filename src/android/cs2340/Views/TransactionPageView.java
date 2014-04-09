package android.cs2340.Views;

import java.util.Collection;

import android.cs2340.Model.AccountModel;

/**
 * The view for the transaction page.
 * @author tiff
 *
 */
public interface TransactionPageView {

    /**
     * Gets the amount of the transaction.
     * @return double for the amount entered.  
     */
    double getAmount();

    /**
     * Gets the category for the transaction.
     * @return String for the ctaegory.
     */
    String getCategory();

    /**
     * Gets the date of the transaction.
     * @return String for the date of the transaction.
     */
    String getDate();

    /**
     * Gets whether withdrawal is set.
     * @return boolean for whether the withdrawal is set.
     */
    boolean withdrawalRadioSet();

    /**
     * Gets whether the deposit button is set.
     * @return boolean for whether the deposit is set.
     */
    boolean depositRadioSet();

    /**
     * Goes to the account page.  
     * @param account The account used to populate the view.
     */
    void goToAccount(AccountModel account);

    /**
     * Sets the categories available. 
     * @param categories List of the categories available.
     */
    void setExpandableViewValues(Collection<String> categories);

}
