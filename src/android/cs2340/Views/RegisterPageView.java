package android.cs2340.Views;


public interface RegisterPageView {

    String getUsername();

    String getPassOne();

    String getPassTwo();

    void setInfoErrorMessage(String text);

    void goToIntro();

    void clearInfo();

}
