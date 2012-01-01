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
public class TapeTest {
    Tape t;
    AMachine am;
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
        am = new AMachine();
        t = new Tape(am);
        Symbol[] s = { new Symbol("A"), new Symbol("B"), new Symbol("C")};
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
        assertEquals(t.readSymbol(), t.getSymbol(t.getRwi()));
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
        assertEquals(1, t.getRwi());
        t.moveTape(Direction.LEFT);
        assertEquals(0, t.getRwi());
    }

    /**
     * Test of tapeLength method, of class Tape.
     */
    @Test
    public void testTapeLengthAfterMovingTape() {
        System.out.println("tapeLength");
        t = new Tape(new AMachine());
        t.moveTape(Direction.LEFT);
        t.moveTape(Direction.LEFT);
        t.moveTape(Direction.RIGHT);
        int expResult = 3;
        int result = t.tapeLength();
        assertEquals(expResult, result);
    }


    /**
     * Test of setRwi method, of class Tape.
     */
    @Test
    public void testSetRwiWorksProperly() {
        System.out.println("setRwi");
        int cellIndex = 8;
        t.setRwi(cellIndex);
        assertEquals(cellIndex, t.getRwi());
    }
}
