/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
    private GridLayout gl;
    public TransitionListPanel(AMachine representedMachine) {
        this.machine = representedMachine;     
        gl = new GridLayout(0, 1);
        this.setLayout(gl);
        updateGUI();
    }
    public final void updateGUI() {
        this.removeAll();
        this.setSize(new Dimension(256, machine.getTransitions().size() * 40));
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
