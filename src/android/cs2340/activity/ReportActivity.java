package android.cs2340.activity;

import android.cs2340.R;
import android.os.Bundle;
import android.content.Intent;
import android.cs2340.model.ReportModel;
import android.cs2340.presenters.ReportPresenter;
import android.cs2340.views.ReportView;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.cs2340.model.GraphView;

/**
 * The class constructs the page of the spending report.
 * 
 * @author Team 42
 * 
 */
public class ReportActivity extends AbstractActivityFactory implements ReportView {

    /**
     * The Presenter used by the view.
     */
    ReportPresenter presenter;
    
    /**
     * The container showing the report. 
     */
    LinearLayout reportHolder;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        presenter = new ReportPresenter((ReportModel) getIntent().getExtras()
                .getSerializable("theReport"), this);
        reportHolder = (LinearLayout) findViewById(R.id.Report_Holder);

        presenter.drawWrittenReport();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.report, menu);
        return true;
    }
    
    @Override
    public void drawReport(String writtenReport, float[] values, String[] hcatigories,
			String[] vpercent) {
        TextView writtenRep = new TextView(this);
        writtenRep.setText(writtenReport);
        reportHolder.addView(writtenRep);
        GraphView graph = new GraphView(this, values, "Graph", hcatigories, vpercent, GraphView.BAR);
        reportHolder.addView(graph);
    }

    /**
     * Hook for when the user clicks the back button.
     * Goes to UserPageActivity.
     * @param view This view.
     */
    public void goBack(View view) {
        presenter.back();
    }

    @Override
    public void goToUserPage(long userId) {
        Intent intent = new Intent(this, UserPageActivity.class);
        intent.putExtra("user_id", userId);
        startActivity(intent);
    }

}
