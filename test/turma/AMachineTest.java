/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import java.util.HashSet;
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
public class AMachineTest {
    
    public AMachineTest() {
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
     * Test of addSymbol method, of class AMachine.
     */
    @Test
    public void testAddSymbol() {
        System.out.println("addSymbol");
        Symbol sym = null;
        AMachine instance = new AMachine();
        instance.addSymbol(sym);
        assertTrue(instance.getSymbols().size() == 2);
    }

    /**
     * Test of advanceStep method, of class AMachine.
     */
    @Test
    public void testAdvanceStep() {
        System.out.println("advanceStep");
        AMachine instance = new AMachine();
        instance.advanceStep();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addState method, of class AMachine.
     */
    @Test
    public void testAddState() {
        System.out.println("addState");
        State s = null;
        AMachine instance = new AMachine();
        instance.addState(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSymbols method, of class AMachine.
     */
    @Test
    public void testGetSymbols() {
        System.out.println("getSymbols");
        AMachine instance = new AMachine();
        HashSet expResult = null;
        HashSet result = instance.getSymbols();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefaultSymbol method, of class AMachine.
     */
    @Test
    public void testGetDefaultSymbol() {
        System.out.println("getDefaultSymbol");
        AMachine instance = new AMachine();
        Symbol expResult = null;
        Symbol result = instance.getDefaultSymbol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTape method, of class AMachine.
     */
    @Test
    public void testGetTape() {
        System.out.println("getTape");
        int i = 0;
        AMachine instance = new AMachine();
        Tape expResult = null;
        Tape result = instance.getTape(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
