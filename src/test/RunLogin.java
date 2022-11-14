package test;

import com.formdev.flatlaf.FlatDarkLaf;
import views.LoginView;
import controllers.LoginViewController;

public class RunLogin {

    public static void main(String args[]) {
        FlatDarkLaf.setup();
        LoginView main = new LoginView();
        LoginViewController main2 = new LoginViewController(main);
        main.setVisible(true);
        main.setLocationRelativeTo(null);
    }
}
