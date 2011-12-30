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
}
