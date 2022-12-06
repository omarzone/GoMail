/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import views.LoginView;

/**
 *
 * @author marti
 */
public class LoginViewControllerIT {
    
    public LoginViewControllerIT() {
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
     * Test of actionPerformed method, of class LoginViewController.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        LoginViewController instance = null;
        instance.actionPerformed(e);
    }

    /**
     * Test of validateFields method, of class LoginViewController.
     */
    @Test
    public void testValidateFields() {
        System.out.println("validateFields");
        LoginView vista = new LoginView();
        LoginViewController controlador = new LoginViewController(vista, "outlook");
        assertFalse(controlador.validateFields());

    }
    
}
