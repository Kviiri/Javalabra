/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

/**
 * Represents a single Transition action - which Symbol is written, which
 * Direction the Tape is moved in and which State is the AMachine set to.
 * @author kviiri
 */
public class Transition {
    private Symbol sym;     //Symbol that is written
    private Direction dir;
    private State sta;
    /**
     * Creates a Transition with no properties.
     */
    public Transition() { }     //Creates an empty transition
    /**
     * Creates a new Transition using the given parameters.
     * @param sym The Symbol to be written
     * @param dir The Direction for moving the Tape
     * @param sta The State the AMachine is set to
     */
    public Transition(Symbol sym, Direction dir, State sta) {
        this.sym = sym;
        this.dir = dir;
        this.sta = sta;
    }
    /**
     * @return The Direction of this Transition.
     */
    public Direction getDir() {
        return dir;
    }
    /**
     * Sets the Direction of the Transition.
     * @param dir The new Direction
     */
    public void setDir(Direction dir) {
        this.dir = dir;
    }
    /**
     * @return The State of the Transition
     */
    public State getSta() {
        return sta;
    }
    /**
     * Sets the State of the Transition
     * @param sta The new State to be written
     */
    public void setSta(State sta) {
        this.sta = sta;
    }
    /**
     * @return The Symbol of the Transition
     */
    public Symbol getSym() {
        return sym;
    }
    /**
     * Sets the Symbol of the Transition
     * @param sym The Symbol of the Transition
     */
    public void setSym(Symbol sym) {
        this.sym = sym;
    }
    @Override
    public String toString() {
        return "WRITE " + sym.getName() + ", MOVE " + dir + ", ENTER " + sta;
    }
}
