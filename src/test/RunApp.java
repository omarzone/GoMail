package test;

import com.formdev.flatlaf.FlatDarkLaf;
import views.MainView;


public class RunApp {
    
     public static void main(String args[]) {
       FlatDarkLaf.setup();
       MainView main = new MainView();
       main.setVisible(true);
       main.setLocationRelativeTo(null);
    }

}
