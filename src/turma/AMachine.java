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
    private int stepsTaken;
    public AMachine() {
        tapes = new ArrayList<Tape>();
        symbols = new HashSet<Symbol>();
        defaultSymbol = new Symbol(" ");
        symbols.add(defaultSymbol);
        tapes.add(new Tape(this));
        tapeIndex = 0;
        states = new HashSet<State>();
        State halt = new State("HALT", true, symbols);
        states.add(halt);
        currentState = halt;
        stepsTaken = 0;
    }
    
    public void addSymbol(Symbol sym) {
        symbols.add(sym);
        for(State s : states) {
            s.addTransition(sym, new Transition());
        }
    }
    public void addState(State s) {
        states.add(s);
        for(Symbol sym : symbols) {
            s.addTransition(sym, new Transition());
        }
    }
    public HashSet<Symbol> getSymbols() {
        return symbols;
    }
    public Symbol getDefaultSymbol() {
        return defaultSymbol;
    }
    public void advanceStep() {
        Tape currentTape = tapes.get(tapeIndex);
        Transition trans = currentState.getTransition(currentTape.readSymbol());
        currentTape.writeSymbol(trans.getSym());
        currentTape.moveTape(trans.getDir());
        currentState = trans.getSta();
        stepsTaken++;
    }
    private int getStepsTaken() {
        return stepsTaken;
    }
    public Tape getTape(int i) {
        return tapes.get(i);
    }
}
