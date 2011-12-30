/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

/**
 *
 * @author kviiri
 */
public enum Direction {
    LEFT, RIGHT, NONE;
    public String toString() {
        switch(this) {
            case LEFT:
                return "L";
            case RIGHT:
                return "R";
            default:
                return "N";
        }
    }
}
