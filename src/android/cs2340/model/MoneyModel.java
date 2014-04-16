package android.cs2340.model;
/**
 * The Model for the money.
 * @author tiff
 *
 */
public interface MoneyModel {
    /**
     * Adds an amount to the money. 
     * @param a The amount to add.
     */
    void addAmount(double a);
    
    /**
     * Adds an amount to the money with an int. 
     * @param a The amount to add.
     */
    void addAmount(int a);

    /**
     * Adds an amount to the money with a long. 
     * @param a The amount to add.
     */
    void addAmount(long a);
    
    /**
     * Gets the amount.
     * @return double for the amount.
     */
    double get();

    /**
     * Gets the amount.
     * @return double for the amount.
     */
    double getAmount();

    /**
     * Changes the amount to set. 
     * @param a The new amount to set. 
     */
    void setAmount(double a);

    /**
     * Changes the amount to set with an int. 
     * @param a The new amount to set. 
     */
    void setAmount(int a);

    /**
     * Changes the amount to set with a long. 
     * @param a The new amount to set. 
     */
    void setAmount(long a);

    /**
     * Converts the money amount into cents.
     * @return Long for the number of cents.
     */
    long toCents();

}