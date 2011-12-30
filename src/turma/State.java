/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author kviiri
 */
public class State {
    private String name;
    private HashMap<Symbol, Transition> transitions;
    private boolean isHaltingState;
    public State(String name, HashSet<Symbol> symbols) {
        this(name, false, symbols);
    }
    public State(String name, boolean isHaltingState, HashSet<Symbol> symbols) {
        transitions = new HashMap<Symbol, Transition>();
        this.isHaltingState = isHaltingState;
        for(Symbol s : symbols) {
            transitions.put(s, new Transition());
        }
    }
    public void addTransition(Symbol s, Transition t) {
        transitions.put(s, t);
    }
    public void removeTransition(Symbol s) {
        transitions.remove(s);
    }
    public Transition getTransition(Symbol s) {
        return transitions.get(s);
    }
}
