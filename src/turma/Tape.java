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
    private Symbol defaultSymbol;   //The symbol that is used for "empty" tape cells
    public Tape(Symbol s) {
        symbols = new LinkedList<Symbol>();
        symbols.add(s);
        defaultSymbol = s;
        rwi = 0;
    }
    public Symbol readSymbol() {
        return symbols.get(rwi);
    }
    public void writeSymbol(Symbol s) {
        symbols.remove(rwi);
        symbols.add(rwi, s);
    }
    public int tapeLength() {
        return symbols.size();
    }
    public void moveTape(Direction dir) {
        switch(dir) {
            case LEFT:
                if(rwi == 0) {
                    symbols.add(0, defaultSymbol);
                }
                else {
                    rwi--;
                }
                break;
            case RIGHT:
                if(rwi + 1 == symbols.size()) {
                    symbols.add(rwi + 1, defaultSymbol);
                }
                rwi++;
                break;
            default:
                break;
        }
    }
}
