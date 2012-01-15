/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Symbol testSymbol;
    Symbol anotherTestSymbol;
    State testState;
    State anotherTestState;
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
        testSymbol = new Symbol("derp");
        anotherTestSymbol = new Symbol("herp");
        testState = new State("hurr", false);
        anotherTestState = new State("durr", true);
        am = new AMachine(testSymbol, testState);
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
        am.addSymbol(anotherTestSymbol);
        assertEquals(2, am.getSymbols().size());
    }

    //Accessory for advanceStep testing
    public void initializeAdvanceStep() {
        am.addSymbol(anotherTestSymbol);
        am.addState(anotherTestState);
        testState.addTransition(testSymbol, new Transition(anotherTestSymbol, Direction.LEFT, anotherTestState));
        try {
            am.advanceStep();
        } catch (NoTransitionException ex) {
            fail("Transition fail when initializing test :(");
        }
    }
    @Test
    public void testAdvanceStepIncrementsStepsTaken() {
        initializeAdvanceStep();
        assertEquals(1, am.getStepsTaken());
    }
    @Test
    public void testAdvanceStepMovesTape() {
        initializeAdvanceStep();
        Tape t = am.getTape();
        assertEquals(0, t.getHead());
    }
    @Test
    public void testAdvanceStepWroteCorrectSymbol() {
        initializeAdvanceStep();
        Tape t = am.getTape();
        assertEquals(anotherTestSymbol, t.getSymbol(1));
    }
    @Test
    public void testAdvanceStepEntersCorrectState() {
        initializeAdvanceStep();
        assertEquals(anotherTestState, am.getCurrentState());
    }
    @Test
    public void testAdvanceStepInHaltingStateDoesNothing() {
        initializeAdvanceStep();
        try {
            am.advanceStep();
        } catch (NoTransitionException ex) {
            fail("Exception occurred");
        }
        assertEquals(1, am.getStepsTaken());
        
    }

    
    /**
     * Test of addState method, of class AMachine.
     */
    @Test
    public void testAddStateAddsState() {
        System.out.println("addState");
        am.addState(anotherTestState);
        assertEquals(2, am.getStates().size());
    }
    @Test
    public void testAddSymbolAddsSymbol() {
        System.out.println("addSymbol");
        am.addSymbol(anotherTestSymbol);
        assertEquals(2, am.getSymbols().size());
    }

    /**
     * Test of getDefaultSymbol method, of class AMachine.
     */
    @Test
    public void testGetDefaultSymbol() {
        System.out.println("getDefaultSymbol");
        assertEquals(testSymbol, am.getDefaultSymbol());
    }
    
    @Test
    public void testNoTransitionExceptionOccursWhenAppropriate() {
        am.setCurrentState(new State("exceptioner"));
        try {
            am.advanceStep();
        } catch (NoTransitionException ex) {
            return;
        }
        fail("Expected a NoTransitionException!");
    }
}
