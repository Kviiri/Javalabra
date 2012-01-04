/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

/**
 * Enum: contains directions LEFT, RIGHT, NONE
 * @author kviiri
 */
public enum Direction {
    LEFT, RIGHT, NONE;
    /**
     * @return "L" if the Direction is LEFT, "R" if the Direction is RIGHT, "N" otherwise
     */
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
