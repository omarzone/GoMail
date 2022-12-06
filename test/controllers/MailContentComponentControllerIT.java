/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controllers;

import components.MailContentComponent;
import java.awt.event.ActionEvent;
import java.util.Date;
import javafx.application.Platform;
import javafx.scene.Scene;
import models.Mail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marti
 */
public class MailContentComponentControllerIT {
    
    public MailContentComponentControllerIT() {
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
     * Test of getMailContentView method, of class MailContentComponentController.
     */
    @Test
    public void testGetMailContentView() {
        System.out.println("getMailContentView");
        MailContentComponent expResult = null;
        MailContentComponent result = MailContentComponentController.getMailContentView();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class MailContentComponentController.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        MailContentComponentController instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetScene() {
        System.out.println("getMailContentView");
        MailContentComponent vista = new MailContentComponent();
        String email = "";
        String subject = "";
        String message = "";
        Date date = null;
        Mail mail = new Mail(email, subject, message, date);
        MailContentComponentController controller = new MailContentComponentController(vista, mail);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                assertNotNull(controller.createScene());
            }
        });
    }
}
