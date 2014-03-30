package cs2340.android.Activities;

import java.io.Serializable;

import cs2340.android.R;
import cs2340.android.R.layout;
import cs2340.android.R.menu;
import cs2340.android.Model.AccountModel;
import cs2340.android.Model.ReportModel;
import cs2340.android.Model.UserModel;
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
