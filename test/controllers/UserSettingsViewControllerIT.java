/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import views.UserSettingsView;

/**
 *
 * @author PC GOOSE
 */
public class UserSettingsViewControllerIT {
    UserSettingsView userSettingsView;
    
    public UserSettingsViewControllerIT() {
        userSettingsView = new UserSettingsView();
        UserSettingsViewController userSettingsViewController = new UserSettingsViewController(userSettingsView);
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actionPerformed method, of class UserSettingsViewController.
     */
    public void deleteInfo(){
        
        
    }
    
}
