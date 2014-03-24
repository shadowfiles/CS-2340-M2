package cs2340.android.Activities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import cs2340.andriod.cs_2340_water_s_warriors.R;
import cs2340.android.Model.AccountModel;
import cs2340.android.Model.ReportModel;
import cs2340.android.Model.TransactionInterface;
import cs2340.android.Model.UserModel;
import cs2340.android.Presenters.ReportPresenter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ReportActivity extends Activity implements ReportModel {

	ReportPresenter presenter;
	TextView reportview;
	private Collection<TransactionInterface> transactions = new ArrayList<TransactionInterface>();
	private String start;
	private String end;
	private String report = "";

    @Override
    public String toString(){
    	String reportByAccount = "";
    	int size = transactions.size();
    	double totalSpending = 0;
    	if (size==0)
    		return "No spending report. ";
    	for (TransactionInterface transaction : transactions) {
            String date = transaction.getDateMade();
            if(compareDates(date,start)>=0 && compareDates(date,end)<=0 ){ //between the date range
            	reportByAccount = reportByAccount + " Spending: " + transaction.getAmount() + " Source: " + transaction.getSource() + "\n"; 
            	totalSpending = totalSpending + transaction.getAmount();
            }
        }
    	reportByAccount = reportByAccount + "Total Account Spending: " + totalSpending;
    	return reportByAccount;
    }
    
    public double compareDates(String dateA, String dateRange){
    	try{
    		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        	Date date1 = sdf.parse(dateA);
        	Date date2 = sdf.parse(dateRange);
 
        	if(date1.compareTo(date2)>0){
        		return 1;
        	}else if(date1.compareTo(date2)<0){
        		return -1;
        	}else if(date1.compareTo(date2)==0){
        		return 0;
        	}
    	}catch(ParseException ex){
    		ex.printStackTrace();
    	}
		return 0;
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report);
	    reportview = (TextView) findViewById(R.id.report);
	    UserModel user = (UserModel)getIntent().getExtras().getSerializable("theUser");
	    Collection<AccountModel> accounts = user.getAccounts();
	    start = getIntent().getExtras().getString("startDate");
	    end = getIntent().getExtras().getString("endDate");
	    for(AccountModel account: accounts){
	    	if(account.getTransactions()!=null){
	    		transactions=account.getTransactions();
	    		report = report + "Transaction Made by: " + account.getDisplayName() + "\n" +toString() + "\n";
	    	}
	    }
	    //TextView validReport = (TextView) findViewById(R.layout.activity_report);
		//validReport.setText(report);
		
	    reportview.setText(report);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report, menu);
		return true;
	}
	
	public void goBack(View view) {
		presenter.back();
	}
	
	public void goToAccount(AccountModel account) {
		Intent intent = new Intent(this, AccountActivity.class);
		intent.putExtra("theAccount",(Serializable)account);
		startActivity(intent);			
	}
	
}
