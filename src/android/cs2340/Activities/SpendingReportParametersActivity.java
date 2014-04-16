package android.cs2340.Activities;

import java.io.Serializable;

import android.cs2340.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.cs2340.Model.ReportModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Presenters.SpendingReportParametersPresenter;
import android.cs2340.Views.SpendingReportParametersView;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;

/**
 * The page for users to pick options for their spending report.
 * @author Team 42
 *
 */
public class SpendingReportParametersActivity extends AbstractActivityFactory implements
        SpendingReportParametersView {

    /**
     * The Presenter used by this view.
     */
    SpendingReportParametersPresenter presenter;
    
    /**
     * DatePicker for the starting date of the report. 
     */
    DatePicker startDatePicker;
    
    /**
     * DatePicker for the ending date of the report.
     */
    DatePicker endDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_report_parameters);

        presenter = new SpendingReportParametersPresenter(
                (UserModel) getIntent().getExtras().getSerializable(USER_SERIAL_ID),
                this);
        startDatePicker = (DatePicker) findViewById(R.id.start_data_picker_spending_report);
        endDatePicker = (DatePicker) findViewById(R.id.end_date_picker_spending_report);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.spending_report_parameters, menu);
        return true;
    }

    /**
     * Converts a DatePicker to a String.
     * @param datePicker Object being converted to a date String.
     * @return A string for the date. 
     */
    private String getDate(DatePicker datePicker) {
        String dateFormat = "%d/%d/%d";
        return String.format(dateFormat, (1 + datePicker.getMonth()),
                datePicker.getDayOfMonth(), datePicker.getYear());
    }

    @Override
    public String getStartDate() {
        return getDate(startDatePicker);
    }

    @Override
    public String getEndDate() {
        return getDate(endDatePicker);
    }

    /**
     * Hook for when the user clicks the go to report button.
     * @param view This view.
     */
    public void goToReport(View view) {
        presenter.goToReport();
    }

    /**
     * Hook for when the user clicks the back button.
     * Goes to AccountActivity. 
     * @param view This view.
     */
    public void goBack(View view) {
        presenter.back();
    }

    @Override
    public void goToUserPage(UserModel user) {
        Intent intent = new Intent(this, UserPageActivity.class);
        intent.putExtra(USER_SERIAL_ID, (Serializable) user);
        startActivity(intent);
    }

    @Override
    public void goToReport(ReportModel report) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("theReport", (Serializable) report);
        startActivity(intent);
    }

}
