package cs2340.android.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.util.Pair;

public class ReportModel {
	
	private List<Pair<String,Double>> listOfSpendings = new ArrayList<Pair<String,Double>>();
	private Date start;
	private Date end;
	private double totalSpending = 0;

    public ReportModel(List<Pair<String,Double>> listOfSpendings, Date start, Date end){
    	this.listOfSpendings = listOfSpendings;
    	this.start = start;
    	this.end = end;
    }
    
    public String toString(){
    	String report = "Spending Category Report" + start.toString() + end.toString() + "\n";
    	for (Pair<String, Double> category : listOfSpendings) {
            report = report + "Category: " + category.first + " Spending: " + category.second.toString() + "\n"; 
            totalSpending = totalSpending + category.second;
        }
    	report = report + "Total Category Spending: " + totalSpending;
    	return report;
    }
    
}
