package android.cs2340.Presenters;

import android.cs2340.Model.AccountModel;
import android.cs2340.Model.ReportModel;
import android.cs2340.Model.UserModel;
import android.cs2340.Views.ReportView;

public class ReportPresenter {
    ReportModel model;
    ReportView view;

    public ReportPresenter(ReportModel model, ReportView view) {
        this.model = model;
        this.view = view;
    }

    public void back() {
        view.goToUserPage(model.getUser());
    }

    public void drawWrittenReport() {
        view.drawReport(model.getWritenReport());
    }
}
