package android.cs2340.Activities;

import java.io.Serializable;

import android.cs2340.R;
import android.cs2340.R.layout;
import android.cs2340.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.cs2340.Model.AccountModel;
import android.cs2340.Model.ReportModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Presenters.AccountPresenter;
import android.cs2340.Presenters.SpendingReportParametersPresenter;
import android.cs2340.Views.SpendingReportParametersView;
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
		
		presenter = new SpendingReportParametersPresenter((UserModel) getIntent().getExtras().getSerializable("theUser"), this);
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
	
	public String getStartDate() {
		return getDate(startDatePicker);
	}
	
	public String getEndDate() {
		return getDate(endDatePicker);
	}
	
	public void goToReport(View view) {
		presenter.goToReport();
	}
	
	public void goBack(View view) {
		presenter.back();
	}
	
	public void goToUserPage(UserModel user) {
		Intent intent = new Intent(this, UserPageActivity.class);
		intent.putExtra("theUser",(Serializable)user);
		startActivity(intent);			
	}

	@Override
	public void goToReport(ReportModel report) {
		Intent intent = new Intent(this, ReportActivity.class);
		intent.putExtra("theReport", (Serializable)report);
		startActivity(intent);
	}

}
