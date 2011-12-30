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
    ArrayList<Tape> tapes;
    HashSet<State> states;  //Symbols and Transitions are in State.java
}
