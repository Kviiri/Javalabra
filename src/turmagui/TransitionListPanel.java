/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import turma.AMachine;
import turma.State;
import turma.Symbol;

/**
 *
 * @author kviiri
 */
public class TransitionListPanel extends JPanel {
    private AMachine machine;
    public TransitionListPanel(AMachine representedMachine) {
        this.machine = representedMachine;        
        updateGUI();
    }
    public final void updateGUI() {
        this.removeAll();        
        for(State s : machine.getStates()) {
            for(Symbol sym : s.getAllTransitions().keySet()) {
                this.add(new TransitionPanel(s, sym, s.getTransition(sym), this));
            }
        }
    }

    public AMachine getMachine() {
        return machine;
    }
}
