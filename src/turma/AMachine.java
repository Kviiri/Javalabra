/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents a single Turing-machine.
 * The machine has one or more Tapes, and a limited collection of States and Symbols.
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
    /**
     * Creates a new AMachine with the default Symbol " ", a single Tape and a "HALT" state (which is a halting state).
     */
    public AMachine(Symbol def, State initialState) {
        this.defaultSymbol = def;
        this.currentState = initialState;
        tapes = new ArrayList<Tape>();
        symbols = new HashSet<Symbol>();
        symbols.add(def);
        tapes.add(new Tape(this));
        tapeIndex = 0;
        states = new HashSet<State>();
        states.add(initialState);
        stepsTaken = 0;
    }
    
    /**
     * Adds a Symbol to the AMachine's alphabet. The first Symbol added will be the "default" symbol
     * @param sym - The Symbol to be added to the alphabet.
     */
    public void addSymbol(Symbol sym) {
        symbols.add(sym);
    }
    /**
     * Adds a State to the AMachine's State set.
     * @param s 
     */
    public void addState(State s) {
        states.add(s);
    }
    /**
     * @return HashSet of the Symbols in the AMachine's alphabet.
     */
    public HashSet<Symbol> getSymbols() {
        return symbols;
    }
    /**
     * @return The default Symbol of the AMachine.
     */
    public Symbol getDefaultSymbol() {
        return defaultSymbol;
    }
    /**
     * Advances the AMachine a single step; the current Tape is read at the location of the RW-head,
     * the Transition is chosen according to the current State's Transition rules and the operations
     * mandated by the Transition (writing a new Symbol, possibly moving the tape, changing the state)
     * are performed.
     * 
     * advanceStep also increases the step counter of the AMachine by one.
     */
    public void advanceStep() throws NoTransitionException {
        if(currentState.isHaltingState()) return;
        Tape currentTape = tapes.get(tapeIndex);
        Transition trans = currentState.getTransition(currentTape.readSymbol());
        if(trans == null) throw new NoTransitionException("no transition for current state");
        currentTape.writeSymbol(trans.getSym());
        currentTape.moveTape(trans.getDir());
        currentState = trans.getSta();
        stepsTaken++;
    }
    /**
     * @return The step counter's value (starts at zero, incremented every time advanceStep() is called) 
     */
    public int getStepsTaken() {
        return stepsTaken;
    }
    /**
     * @param i The index of the Tape.
     * @return The (i+1):th Tape of the AMachine.
     */
    public Tape getTape(int i) {
        return tapes.get(i);
    }
    /**
     * Single-Tape machines can use the simpler version of getTape(), which is equivalent to
     * getTape(0)
     * @return The first Tape of the AMachine.
     */
    public Tape getTape() {
        return tapes.get(0);
    }
    /**
     * @return HashSet of the States of the machine
     */
    public HashSet<State> getStates() {
        return states;
    }
    /**
     * 
     * @return HashSet of all Transitions
     */
    public HashSet<Transition> getTransitions() {
        HashSet ret = new HashSet<Transition>();
        for(State s : states) {
            ret.addAll(s.getAllTransitions().values());
        }
        return ret;
    }
    /**
     * 
     * @return current State of the machine
     */
    public State getCurrentState() {
        return currentState;
    }
    /**
     * Sets the current State of the machine
     * @param s The new State
     */
    public void setCurrentState(State s) {
        states.add(s);
        this.currentState = s;
    }
}
