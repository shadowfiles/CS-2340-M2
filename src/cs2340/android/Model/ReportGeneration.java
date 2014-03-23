package cs2340.android.Model;

import java.util.ArrayList;
import java.util.Collection;

public class ReportGeneration {
	
	private Collection<TransactionInterface> transactions = new ArrayList<TransactionInterface>();
	private double totalSpending = 0;

    public ReportGeneration(Collection<TransactionInterface> transactions){
    	this.transactions = transactions;
    }
    
    public String toString(){
    	String report = "Spending Category Report" + "\n";
    	for (TransactionInterface category : transactions) {
            report = report + "Category: " + category.getSource() + " Spending: " + category.getAmount() + "\n"; 
            totalSpending = totalSpending + category.getAmount();
        }
    	report = report + "Total Category Spending: " + totalSpending;
    	return report;
    }
    
}
