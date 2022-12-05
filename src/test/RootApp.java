/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.formdev.flatlaf.FlatDarkLaf;
import controllers.MainViewController;
import controllers.SMTPViewController;
import org.json.JSONObject;

import utils.JsonReader;
import views.MainView;
import views.SMTPView;


/**
 *
 * @author Pablo
 */

public class RootApp {
    
    public static void main(String args[]) {
     FlatDarkLaf.setup();
     JSONObject temp = JsonReader.getJson("src/utils/temp.txt");
        boolean logged = temp.getBoolean("logged");
        
        if(logged== false){
            SMTPView smtpView = new SMTPView();
            smtpView.setVisible(true);
            smtpView.setLocationRelativeTo(null);
            SMTPViewController SMTPViewController = new SMTPViewController(smtpView);
        }else{
            MainView mainview = new MainView();
            mainview.setVisible(true);
            mainview.setLocationRelativeTo(null);
            MainViewController mainviewcontroller = new MainViewController(mainview);
        }
    }
}
