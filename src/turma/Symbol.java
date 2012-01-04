/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

/**
 * A Symbol represents a single Symbol in a Turing Machine's alphabet.
 * @author kviiri
 */
public class Symbol {
    private String name;
    /**
     * Creates a Symbol with the specified name.
     * @param name The name for the Symbol
     */
    public Symbol(String name) {
        this.name = name;
    }
    /**
     * @return The Symbol's name 
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the Symbol's name
     * @param name The new name for the Symbol
     */
    public void setname(String name) {
        this.name = name;
    }
}
