/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

/**
 *
 * @author kviiri
 */
public class Transition {
    private Symbol sym;     //Symbol that is written
    private Direction dir;
    private State sta;
    
    public Transition() { }     //Creates an empty transition
    
    public Transition(Symbol sym, Direction dir, State sta) {
        this.sym = sym;
        this.dir = dir;
        this.sta = sta;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public State getSta() {
        return sta;
    }

    public void setSta(State sta) {
        this.sta = sta;
    }

    public Symbol getSym() {
        return sym;
    }

    public void setSym(Symbol sym) {
        this.sym = sym;
    }
    
}
