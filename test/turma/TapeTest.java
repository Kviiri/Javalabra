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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readSymbol method, of class Tape.
     */
    @Test
    public void testReadSymbol() {
        System.out.println("readSymbol");
        Tape instance = null;
        Symbol expResult = null;
        Symbol result = instance.readSymbol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeSymbol method, of class Tape.
     */
    @Test
    public void testWriteSymbol() {
        System.out.println("writeSymbol");
        Symbol s = null;
        Tape instance = null;
        instance.writeSymbol(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveTape method, of class Tape.
     */
    @Test
    public void testMoveTape() {
        System.out.println("moveTape");
        Direction dir = null;
        Tape instance = null;
        instance.moveTape(dir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tapeLength method, of class Tape.
     */
    @Test
    public void testTapeLength() {
        System.out.println("tapeLength");
        Tape t = new Tape(new Symbol("ASD"));
        t.moveTape(Direction.LEFT);
        t.moveTape(Direction.LEFT);
        t.moveTape(Direction.RIGHT);
        int expResult = 3;
        int result = t.tapeLength();
        assertEquals(expResult, result);
    }
}
