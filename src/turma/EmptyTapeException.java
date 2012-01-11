/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

/**
 * This exception is thrown when an operation attepts to remove the last cell from a Tape.
 * @author kviiri
 */
public class EmptyTapeException extends Exception {
    public EmptyTapeException(String message) {
        super(message);
    }
}
