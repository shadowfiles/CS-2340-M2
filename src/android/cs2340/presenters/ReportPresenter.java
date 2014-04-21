package android.cs2340.presenters;

import android.cs2340.model.ReportModel;
import android.cs2340.views.ReportView;

/**
 * The presenter for showing a report.
 * @author tiff
 *
 */
public class ReportPresenter {
    /**
     * The model being used.
     */
    ReportModel model;

    /**
     * The view being used.
     */
    ReportView view;

    /**
     * The constructor for the presenter.
     * @param m The model being used.
     * @param v The view being used.
     */
    public ReportPresenter(ReportModel m, ReportView v) {
        this.model = m;
        this.view = v;
    }

    /**
     * When the back button is pressed.
     */
    public void back() {
        view.goToUserPage(model.getUser().getId());
    }

    /**
     * Creates the written report in display.
     */
    public void drawWrittenReport() {
        view.drawReport(model.getWrittenReport(), model.getValues(), model.getHcatigories(), model.getVpercent());
    }

}
