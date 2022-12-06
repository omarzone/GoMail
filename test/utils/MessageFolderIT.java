/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utils;

import java.util.ArrayList;
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
public class MessageFolderIT {
    
    public MessageFolderIT() {
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

   
    @Test
    public void testGetEmails() throws Exception {
        System.out.println("getEmails");
        String folderName = "INBOX";
        MessageFolder instance = new MessageFolder();
        assertNotNull(instance.getEmails(folderName));
     
        
    }

    /**
     * Test of reverseList method, of class MessageFolder.
     */
    @Test
    public void testReverseList() {
        System.out.println("reverseList");
        ArrayList expResult = null;
        ArrayList result = MessageFolder.reverseList(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
