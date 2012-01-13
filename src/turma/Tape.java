/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import java.util.LinkedList;

/**
 * Represents a single Tape in an AMachine. Contains the Symbols of the Tape in a
 * LinkedList and a read-write head that determines which part of the List is being
 * updated when executing the machine.
 * @author kviiri
 */
public class Tape {
    private LinkedList<Symbol> symbols;
    private int head;        //Read-write Index
    private AMachine machine;
    /**
     * Creates a new Tape that belongs to a specific AMachine. The Tape is initialized
     * to have a single Symbol that is the AMachine's default symbol. The head is
     * initialized to zero.
     * @param machine The machine this Tape belongs to
     */
    public Tape(AMachine machine) {
        symbols = new LinkedList<Symbol>();
        this.machine = machine;
        symbols.add(machine.getDefaultSymbol());
        head = 0;
    }
    /**
     * Reads the Symbol at the location of the read-write head.
     * @return The Symbol read
     */
    public Symbol readSymbol() {
        return getSymbol(head);
    }
    /**
     * Writes a Symbol at the location of the read-write head.
     * @param s The Symbol to be written
     */
    public void writeSymbol(Symbol s) {
        setSymbol(head, s);
    }
    /**
     * @return The current location of the read-write head
     */
    public int getHead() {
        return head;
    }
    /**
     * @return The current length of the Tape
     */
    public int length() {
        return symbols.size();
    }
    /**
     * Gets the Symbol at the Tape position
     * @param i The Tape position specified for reading
     * @return The Symbol at the specified position
     */
    public Symbol getSymbol(int i) {
        return symbols.get(i);
    }
    /**
     * Sets the Symbol at the specified position of the Tape.
     * @param i The location in which the Symbol should be added (0...current tape length)
     * @param s The Symbol to be added.
     */
    public void setSymbol(int i, Symbol s) {
        if(i < symbols.size()) symbols.remove(i);
        symbols.add(i, s);
    }
    /**
     * Moves the Tape one step left or right, either incrementing or decrementing head.
     * The Tape is expanded dynamically, if needed, using the default symbol of the
     * parent AMachine.
     * @param dir The Direction to move the Tape in.
     */
    public void moveTape(Direction dir) {
        switch(dir) {
            case LEFT:
                if(head == 0) {
                    symbols.add(0, machine.getDefaultSymbol());
                }
                else {
                    head--;
                }
                break;
            case RIGHT:
                if(head + 1 == symbols.size()) {
                    symbols.add(head + 1, machine.getDefaultSymbol());
                }
                head++;
                break;
            default:
                break;
        }
    }
    /**
     * Sets the location of the head.
     * @param cellIndex The new location for the head.
     */
    public void setHead(int cellIndex) {
        head = cellIndex;
    }
    /**
     * Deletes the specified cell from the tape. The head may be set to follow the
     * cell it is on. If the head would wind up outside the Tape, it is automatically
     * relocated to the last cell. Removing the last cell in the Tape causes EmptyTapeException
     * to be thrown.
     * @param deleteIndex The index to the cell to delete
     * @param moveHead If true, the head will stick to its current cell instead of the current index
     * @throws EmptyTapeException
     */
    public void deleteCell(int deleteIndex, boolean moveHead) throws EmptyTapeException {
        if(symbols.size() == 1) {
            throw new EmptyTapeException("cannot remove the last cell of a tape");
        }
        if(moveHead && deleteIndex <= head) head--;
        if(head < 0) head = 0;
        symbols.remove(deleteIndex);
    }

    /**
     * Inserts a Symbol in the specified location.
     * @param cellIndex The location to insert in (0 is the first)
     * @param s Symbol to be inserted
     * @param moveHead if true, the head will stick to the current cell instead of the current index
     */
    public void insertSymbol(int cellIndex, Symbol s, boolean moveHead) {
        if(moveHead && cellIndex <= head) head++;
        symbols.add(cellIndex, s);
    }
}
