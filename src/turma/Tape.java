/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import java.util.LinkedList;

/**
 *
 * @author kviiri
 */
public class Tape {
    private LinkedList<Symbol> symbols;
    private int rwi;        //Read-write Index
    private AMachine machine;
    public Tape(AMachine machine) {
        symbols = new LinkedList<Symbol>();
        this.machine = machine;
        symbols.add(machine.getDefaultSymbol());
        rwi = 0;
    }
    public Symbol readSymbol() {
        return getSymbol(rwi);
    }
    public void writeSymbol(Symbol s) {
        setSymbol(rwi, s);
    }
    public int getRwi() {
        return rwi;
    }
    public int tapeLength() {
        return symbols.size();
    }
    public Symbol getSymbol(int i) {
        return symbols.get(i);
    }
    /**
     * setSymbol should ONLY be used for debugging and through other methods to avoid screwing the operation of the machine
     * @param i
     * @param s 
     */
    public void setSymbol(int i, Symbol s) {
        if(i < symbols.size()) symbols.remove(i);
        symbols.add(i, s);
    }
    public void moveTape(Direction dir) {
        switch(dir) {
            case LEFT:
                if(rwi == 0) {
                    symbols.add(0, machine.getDefaultSymbol());
                }
                else {
                    rwi--;
                }
                break;
            case RIGHT:
                if(rwi + 1 == symbols.size()) {
                    symbols.add(rwi + 1, machine.getDefaultSymbol());
                }
                rwi++;
                break;
            default:
                break;
        }
    }

    public void setRwi(int cellIndex) {
        rwi = cellIndex;
    }
}
