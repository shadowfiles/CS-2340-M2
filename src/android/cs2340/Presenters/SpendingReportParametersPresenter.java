package android.cs2340.Presenters;

import android.cs2340.Model.ReportModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Views.SpendingReportParametersView;

/**
 * Presenter for page to show select spending report options.
 * @author tiff
 *
 */
public class SpendingReportParametersPresenter {

    /**
     * The model for the users.
     */
    UserModel model;
    
    /**
     * The view for the spending report.
     */
    SpendingReportParametersView view;

    /**
     * Constructor for the spending report presenter.
     * @param m The model used.
     * @param v The view used.
     */
    public SpendingReportParametersPresenter(UserModel m,
            SpendingReportParametersView v) {
        this.model = m;
        this.view = v;
    }

    /**
     * Go to the report generated. 
     */
    public void goToReport() {
        ReportModel repmod = model.getReport(view.getStartDate(),
                view.getEndDate());
        view.goToReport(repmod);
    }

    /**
     * Go back to the user model. 
     */
    public void back() {
        view.goToUserPage(model);
    }
}
