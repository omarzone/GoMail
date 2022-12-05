/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import controllers.UserSettingsViewController;
import views.UserSettingsView;

/**
 *
 * @author PC GOOSE
 */
public class RunUserSettings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserSettingsView userSV = new UserSettingsView();
        UserSettingsViewController USVC = new UserSettingsViewController(userSV);
    }
    
}
