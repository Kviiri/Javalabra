/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

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
public class TapeTest {
    Tape t;
    AMachine am;
    State testState;
    public TapeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
        Symbol[] s = { new Symbol("A"), new Symbol("B"), new Symbol("C")};
        testState = new State("herp", false);
        am = new AMachine(s[0], testState);
        t = new Tape(am);
        for(int i = 0; i < 20; i++) {
            t.setSymbol(i, s[i%3]);
        }
       
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readSymbol method, of class Tape.
     */
    @Test
    public void testReadSymbolReturnsSameValueAsGetSymbolAtRWI() {
        System.out.println("readSymbol");
        assertEquals(t.readSymbol(), t.getSymbol(t.getHead()));
    }
    /**
     * Test of writeSymbol method, of class Tape.
     */
    @Test
    public void testWriteSymbolWritesCorrectly() {
        System.out.println("writeSymbol");
        Symbol s = new Symbol("alan");
        t.writeSymbol(s);
        assertEquals(s, t.readSymbol());
    }

    /**
     * Test of moveTape method, of class Tape.
     */
    @Test
    public void testMoveTapeMovesRWI() {
        System.out.println("moveTape");
        t.moveTape(Direction.RIGHT);
        assertEquals(1, t.getHead());
        t.moveTape(Direction.LEFT);
        assertEquals(0, t.getHead());
    }

    /**
     * Test of tapeLength method, of class Tape.
     */
    @Test
    public void testTapeLengthAfterMovingTape() {
        System.out.println("tapeLength");
        t = new Tape(new AMachine(new Symbol("alan"), testState));
        t.moveTape(Direction.LEFT);
        t.moveTape(Direction.LEFT);
        t.moveTape(Direction.RIGHT);
        int expResult = 3;
        int result = t.length();
        assertEquals(expResult, result);
    }
    @Test
    public void testDefaultSymbolIsUsedForExpandingTape() {
        t.moveTape(Direction.LEFT);
        assertEquals(am.getDefaultSymbol(), t.readSymbol());
    }


    /**
     * Test of setRwi method, of class Tape.
     */
    @Test
    public void testSetRwiWorksProperly() {
        System.out.println("setRwi");
        int cellIndex = 8;
        t.setHead(cellIndex);
        assertEquals(cellIndex, t.getHead());
    }
    @Test
    public void testInsertSymbolMovesHeadProperly() {
        t.setHead(5);
        t.insertSymbol(5, am.getDefaultSymbol(), true);
        assertEquals(6, t.getHead());
    }
    @Test
    public void testDeleteSymbolMovesHeadProperly() {
        t.setHead(5);
        try {
            t.deleteCell(4, true);
        } catch (EmptyTapeException ex) {
            fail("Exception occurred");
        }
        assertEquals(4, t.getHead());
    }
    @Test
    public void testDeleteSymbolDoesNotAllowheadToLeaveTape() {
        t.setHead(0);
        try {
            t.deleteCell(0, true);
        } catch (EmptyTapeException ex) {
            fail("Exception occurred");
        }
        assertEquals(0, t.getHead());   
    }
    @Test
    public void testDeleteSymbolDoesNotRemoveLastCellOfTapeAndThrowsException() {
        t = new Tape(am);
        try {
            t.deleteCell(0, true);
        } catch (EmptyTapeException ex) {
            return;
        }
        fail("No EmptyTapeException happened!");
    }
}
