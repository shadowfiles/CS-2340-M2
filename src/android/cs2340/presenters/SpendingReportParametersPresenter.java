package android.cs2340.presenters;

import android.cs2340.model.ReportModel;
import android.cs2340.model.UserModel;
import android.cs2340.persistence.UserDataTable;
import android.cs2340.persistence.UserDataSource;
import android.cs2340.views.SpendingReportParametersView;

/**
 * Presenter for page to show select spending report options.
 * @author tiff
 *
 */
public class SpendingReportParametersPresenter {

    /**
     * The model for the users.
     */
    private UserModel model;
    
    /**
     * The view for the spending report.
     */
    private SpendingReportParametersView view;
    
    private UserDataSource source;

    /**
     * Constructor for the spending report presenter.
     * @param m The model used.
     * @param v The view used.
     */
    public SpendingReportParametersPresenter(long id,
            SpendingReportParametersView v) {
        this.source = UserDataTable.getSource();
        this.model = source.getUser(id);
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
        view.goToUserPage(model.getId());
    }
}
