/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utils;

import java.util.Iterator;
import org.json.JSONObject;
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
public class JsonReaderIT {
    
    public JsonReaderIT() {
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
    public void testGetJson() {
        System.out.println("getJson");
        String file = "src/utils/temp.txt";
        JSONObject result = JsonReader.getJson(file);
        assertNotNull( result);
    }
    
    @Test
    public void testJsonKeys() {
        System.out.println("getJson");
        String file = "src/utils/temp.txt";
        JSONObject jsonTest = JsonReader.getJson(file);
        Iterator<String> iterador = jsonTest.keys();
        boolean succes = true;
        int contador = 0;
        while (iterador.hasNext()) {
            String llave = iterador.next();
            System.out.println("Llave: " + llave);
            if (contador > 4) {
                succes = false;
            }
            contador++;
        }
        assertTrue(succes);
    }
    
        @Test
    public void testJsonSearchKey() {
        System.out.println("getJson");
        String file = "src/utils/temp.txt";
        JSONObject jsonTest = JsonReader.getJson(file);
        Iterator<String> iterador = jsonTest.keys();
        boolean succes = false;
        int contador = 0;
        String key = "email";
        while (iterador.hasNext()) {
            String llave = iterador.next();
            if (llave.equals(key)) {                
                succes = true;
            }
            contador++;
        }
        assertTrue(succes);
    }
    
    
}
