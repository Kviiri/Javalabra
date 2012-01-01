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
public class TransitionTest {
    
    public TransitionTest() {
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
     * Test of getDir method, of class Transition.
     */
    @Test
    public void testGetDir() {
        System.out.println("getDir");
        Transition instance = new Transition();
        Direction expResult = null;
        Direction result = instance.getDir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDir method, of class Transition.
     */
    @Test
    public void testSetDir() {
        System.out.println("setDir");
        Direction dir = null;
        Transition instance = new Transition();
        instance.setDir(dir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSta method, of class Transition.
     */
    @Test
    public void testGetSta() {
        System.out.println("getSta");
        Transition instance = new Transition();
        State expResult = null;
        State result = instance.getSta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSta method, of class Transition.
     */
    @Test
    public void testSetSta() {
        System.out.println("setSta");
        State sta = null;
        Transition instance = new Transition();
        instance.setSta(sta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSym method, of class Transition.
     */
    @Test
    public void testGetSym() {
        System.out.println("getSym");
        Transition instance = new Transition();
        Symbol expResult = null;
        Symbol result = instance.getSym();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSym method, of class Transition.
     */
    @Test
    public void testSetSym() {
        System.out.println("setSym");
        Symbol sym = null;
        Transition instance = new Transition();
        instance.setSym(sym);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
