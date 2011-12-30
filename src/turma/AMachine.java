/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author kviiri
 */
public class AMachine {
    private ArrayList<Tape> tapes;
    private HashSet<State> states;  //Symbols and Transitions are in State.java
    private HashSet<Symbol> symbols;
    private Symbol defaultSymbol;       //Will be the default symbol of all tapes created in this machine
    private State currentState;
    private int tapeIndex;
    public AMachine() {
        tapes = new ArrayList<Tape>();
        symbols = new HashSet<Symbol>();
        defaultSymbol = new Symbol(" ");
        symbols.add(defaultSymbol);
        tapes.add(new Tape(defaultSymbol));
        tapeIndex = 0;
        states = new HashSet<State>();
        State halt = new State("HALT", true, symbols);
        states.add(halt);
        currentState = halt;
    }
    
    public void addSymbol(Symbol sym) {
        symbols.add(sym);
        for(State s : states) {
            s.addTransition(sym, new Transition());
        }
    }
    public void addState(State s) {
        for(Symbol sym : symbols) {
            s.addTransition(sym, new Transition());
        }
        states.add(s);
    }
    public HashSet<Symbol> getSymbols() {
        return symbols;
    }
    public void advanceStep() {
        Tape currentTape = tapes.get(tapeIndex);
        Transition trans = currentState.getTransition(currentTape.readSymbol());
        currentTape.writeSymbol(trans.getSym());
        currentTape.moveTape(trans.getDir());
        currentState = trans.getSta();        
    }
}
