/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * State represents a single state of the Turing Machine.
 * A State has a name and a boolean flag that determines whether a State is a halting state.
 * Each State also has a map of Transitions for each Symbol.
 * @author kviiri
 */
public class State {
    private String name;
    private HashMap<Symbol, Transition> transitions;
    private boolean isHaltingState;
    /**
     * Creates a new State that is not a halting state.
     * @param name The name for the new State.
     * @param symbols The Symbols for which Transitions are created
     */
    public State(String name, Set<Symbol> symbols) {
        this(name, false, symbols);
    }
    /**
     * Creates a new State.
     * @param name The name for the new State
     * @param isHaltingState true means the State is a halting state, false means it is not
     * @param symbols The Symbols for which Transitions are created
     */
    public State(String name, boolean isHaltingState, Set<Symbol> symbols) {
        transitions = new HashMap<Symbol, Transition>();
        this.isHaltingState = isHaltingState;
        for(Symbol s : symbols) {
            transitions.put(s, new Transition());
        }
    }
    /**
     * Adds or replaces the Transition for the input Symbol with a new one.
     * @param s The Symbol whose Transition will be replaced
     * @param t The new Transition
     */
    public void addTransition(Symbol s, Transition t) {
        transitions.put(s, t);
    }
    /**
     * Removes the Transition from Symbol s
     * @param s The Transition whose Transition will be removed
     */
    public void removeTransition(Symbol s) {
        transitions.remove(s);
    }
    /**
     * Returns the Transition of this State while reading the specified Symbol
     * @param s The Symbol whose Transition is returned
     * @return The Transition of this State for the specified Symbol.
     */
    public Transition getTransition(Symbol s) {
        return transitions.get(s);
    }
}
