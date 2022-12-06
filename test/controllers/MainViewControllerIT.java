/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controllers;

import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import views.MainView;

/**
 *
 * @author marti
 */
public class MainViewControllerIT {
    
    public MainViewControllerIT() {
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
     * Test of getMainView method, of class MainViewController.
     */
    @Test
    public void testGetMainView() {
        System.out.println("getMainView");
        MainView expResult = null;
        MainView result = MainViewController.getMainView();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSwitchPanels() {
        System.out.println("switchPanels");
        MainView vistaPrincipal = new MainView();
        MainViewController viewController = new MainViewController(vistaPrincipal);
        JPanel panel = new JPanel();
        MainViewController.switchPanels(panel);

    }

    @Test
    public void testLoadMails() throws Exception {
        System.out.println("loadMails");
        String folderName = "INBOX";
        MainView vistaPrincipal = new MainView();
        MainViewController viewController = new MainViewController(vistaPrincipal);
        JScrollPane result = MainViewController.loadMails(folderName);
        assertNotNull(result);
    }

    /**
     * Test of loadFolder method, of class MainViewController.
     */
    @Test
    public void testLoadFolder() throws Exception {
        System.out.println("loadFolder");
        MainView vistaPrincipal = new MainView();
        MainViewController viewController = new MainViewController(vistaPrincipal);
        viewController.loadFolder();
    }
    
}
