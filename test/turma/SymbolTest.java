/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kviiri
 */
public class SymbolTest {
    
    public SymbolTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Symbol.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Symbol instance = new Symbol("Wikla");
        String expResult = "Wikla";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setname method, of class Symbol.
     */
    @Test
    public void testSetname() {
        System.out.println("setname");
        String name = "alkiW";
        Symbol instance = new Symbol("asd");
        instance.setname(name);
        assertEquals(name, instance.getName());
    }
}
