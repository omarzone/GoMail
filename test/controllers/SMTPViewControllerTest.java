/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controllers;

import java.awt.event.MouseEvent;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import views.SMTPView;

/**
 *
 * @author Pablo
 */
public class SMTPViewControllerTest {
    
    public SMTPViewControllerTest() {
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
     * Test of mouseClicked method, of class SMTPViewController.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent e = null;
        SMTPViewController instance = null;
        instance.mouseClicked(e);
        
    }
    
    @Test
    public void testSMTPView() {
        SMTPView SMTP = new SMTPView();
        SMTPViewController SMTPController = new SMTPViewController(SMTP);
        assertNotNull(SMTP);
    }

    /**
     * Test of mousePressed method, of class SMTPViewController.
     */
//    @Test
//    public void testMousePressed() {
//        System.out.println("mousePressed");
//        MouseEvent e = null;
//        SMTPViewController instance = null;
//        instance.mousePressed(e);
//
//    }
//
//    /**
//     * Test of mouseReleased method, of class SMTPViewController.
//     */
//    @Test
//    public void testMouseReleased() {
//        System.out.println("mouseReleased");
//        MouseEvent e = null;
//        SMTPViewController instance = null;
//        instance.mouseReleased(e);
//
//    }
//
//    /**
//     * Test of mouseEntered method, of class SMTPViewController.
//     */
//    @Test
//    public void testMouseEntered() {
//        System.out.println("mouseEntered");
//        MouseEvent e = null;
//        SMTPViewController instance = null;
//        instance.mouseEntered(e);
//    }
//
//    /**
//     * Test of mouseExited method, of class SMTPViewController.
//     */
//    @Test
//    public void testMouseExited() {
//        System.out.println("mouseExited");
//        MouseEvent e = null;
//        SMTPViewController instance = null;
//        instance.mouseExited(e);
//
//    }
    
}
