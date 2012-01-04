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
    AMachine am;
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
        am = new AMachine();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addSymbol method, of class AMachine.
     */
    @Test
    public void testAddSymbolResultsInSymbolBeingAdded() {
        System.out.println("addSymbol");
        am.addSymbol(new Symbol("aasd"));
        assertEquals(2, am.getSymbols().size());
    }

    /**
     * Test of advanceStep method, of class AMachine.
     */
    @Test
    public void testAdvanceStep() {
        
    }

    /**
     * Test of addState method, of class AMachine.
     */
    @Test
    public void testAddStateAddsState() {
        System.out.println("addState");
        am.addState(new State("epavarmuuden tila", false, am.getSymbols()));
        assertEquals(2, am.getStates().size());
    }
    @Test
    public void testAddSymbolAddsTransition() {
        System.out.println("addState");
        State s = new State("epavarmuuden tila", false, am.getSymbols());
        am.addState(s);
        assertTrue(s.getTransition(am.getDefaultSymbol()) != null);
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
