package android.cs2340.Model;


/**
 * A class to represent money.
 * @author tiff
 *
 */
public class Money implements MoneyModel {
    /**
     * The double holding the amount of money.
     */
    private double amount;
    
    /**
     * Creates a new money.
     * @param a double for the amount of money.
     */
    public Money(double a) {
        setAmount(a);
    }

    /**
     * Creates money based on the number of cents. 
     * @param a Amount of cents.
     */
    public Money(long a) {
        setAmount(a);
    }
    
    @Override
    public double get() {
        return getAmount();
    }

    @Override
    public double getAmount() {
        return amount;
    }
    @Override
    public void setAmount(double a) {
        amount = a;
    }
    
    @Override
    public void setAmount(long a) {
        amount = ((double) a) / 100.0;
    }

    @Override
    public void setAmount(int a) {
        setAmount((long) a);
    }
    
    @Override
    public void addAmount(double a) {
        amount += a;
    }
    
    @Override
    public void addAmount(int a) {
        amount += a;
    }
    
    @Override
    public void addAmount(long a) {
        amount += a;
    }
    
    @Override
    public long toCents() {
        return (long) amount * 100;
    }

    @Override
    public String toString() {
        return String.format("$%d.2", amount);
    }
}
