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
public class StateTest {
    
    public StateTest() {
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
     * Test of addTransition method, of class State.
     */
    @Test
    public void testAddTransition() {
        System.out.println("addTransition");
        Symbol s = null;
        Transition t = null;
        State instance = null;
        instance.addTransition(s, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTransition method, of class State.
     */
    @Test
    public void testRemoveTransition() {
        System.out.println("removeTransition");
        Symbol s = null;
        State instance = null;
        instance.removeTransition(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransition method, of class State.
     */
    @Test
    public void testGetTransition() {
        System.out.println("getTransition");
        Symbol s = null;
        State instance = null;
        Transition expResult = null;
        Transition result = instance.getTransition(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
