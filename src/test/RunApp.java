package test;

import com.formdev.flatlaf.FlatDarkLaf;
import controllers.MainViewController;
import views.MainView;

public class RunApp {

    public static void main(String args[]) {
        FlatDarkLaf.setup();
        MainView mainview = new MainView();
        mainview.setVisible(true);
        mainview.setLocationRelativeTo(null);
        MainViewController mainviewcontroller = new MainViewController(mainview);
    }
}
