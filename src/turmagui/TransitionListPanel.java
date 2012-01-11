/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import turma.AMachine;
import turma.State;
import turma.Symbol;

/**
 *
 * @author kviiri
 */
public class TransitionListPanel extends JPanel {
    private AMachine machine;
    private GridLayout gl;
    public TransitionListPanel(AMachine machine) {
        this.machine = machine;
    }
    public void updateGUI() {
        this.removeAll();
        gl = new GridLayout(1, 0);
        this.setLayout(gl);
        
        for(State s : machine.getStates()) {
            for(Symbol sym : s.getAllTransitions().keySet()) {
                this.add(new TransitionPanel(s, sym, s.getTransition(sym), this));
            }
        }
    }
}
