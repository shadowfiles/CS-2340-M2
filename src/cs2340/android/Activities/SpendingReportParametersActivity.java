package cs2340.android.Activities;

import java.io.Serializable;

import cs2340.andriod.cs_2340_water_s_warriors.R;
import cs2340.andriod.cs_2340_water_s_warriors.R.layout;
import cs2340.andriod.cs_2340_water_s_warriors.R.menu;
import cs2340.android.Model.AccountModel;
import cs2340.android.Presenters.AccountPresenter;
import cs2340.android.Presenters.SpendingReportParametersPresenter;
import cs2340.android.Views.SpendingReportParametersView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;

public class SpendingReportParametersActivity extends Activity implements SpendingReportParametersView {

	
	SpendingReportParametersPresenter presenter;
	DatePicker startDatePicker;
	DatePicker endDatePicker;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spending_report_parameters);
		
		presenter = new SpendingReportParametersPresenter((AccountModel) getIntent().getExtras().getSerializable("theAccount"), this);
		startDatePicker = (DatePicker)findViewById(R.id.start_data_picker_spending_report);
		endDatePicker = (DatePicker)findViewById(R.id.end_date_picker_spending_report);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spending_report_parameters, menu);
		return true;
	}
	
	public String getDate(DatePicker datePicker) {
		return "" + (1+datePicker.getMonth()) + "/" + datePicker.getDayOfMonth() + "/" + datePicker.getYear();
	}
	
	public void goToReport(View view) {
		presenter.goToReport();
	}
	
	public void goBack(View view) {
		presenter.back();
	}
	
	public void goToAccount(AccountModel account) {
		Intent intent = new Intent(this, AccountActivity.class);
		intent.putExtra("theAccount",(Serializable)account);
		startActivity(intent);			
	}

	public void goToReport(AccountModel account) {
		String startDate = getDate(startDatePicker);
		String endDate = getDate(endDatePicker);
		Intent intent = new Intent(this, ReportActivity.class);
		intent.putExtra("theAccount", (Serializable)account);
		intent.putExtra("startDate", startDate);
		intent.putExtra("endDate", endDate);
		startActivity(intent);
	}

}
