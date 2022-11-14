/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import controllers.MainViewController;
import views.MainView;

/**
 *
 * @author PC GOOSE
 */
public class RunMailContent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainView mv = new MainView();
        MainViewController MVC = new MainViewController(mv);
    }
    
}
