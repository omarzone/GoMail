package test;

import com.formdev.flatlaf.FlatDarkLaf;
import views.LoginSMTPView;
import views.LoginView;
import views.MainView;
import views.SMTPView;

public class RunApp {

    public static void main(String args[]) {
        FlatDarkLaf.setup();
        MainView main = new MainView();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
    }

}
