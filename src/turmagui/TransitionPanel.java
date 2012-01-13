/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import turma.State;
import turma.Symbol;
import turma.Transition;

/**
 *
 * @author kviiri
 */
public class TransitionPanel extends JPanel {
    private State oldState;
    private Symbol oldSymbol;
    private Transition newTransition;
    private JTextField dataField;
    private JButton editButton;
    private JButton deleteButton;
    private TransitionListPanel parentPanel;
    public TransitionPanel(State state, Symbol currentSymbol, Transition transition, TransitionListPanel parent) {
        parentPanel = parent;
        oldSymbol = currentSymbol;
        oldState = state;
        newTransition = transition;
        dataField = new JTextField(state + ", " + currentSymbol + " :  " + transition);
        dataField.setEditable(false);
        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                EditTransitionDialog etd = new EditTransitionDialog(oldState, oldSymbol, newTransition, parentPanel.getMachine());
                etd.show();
                parentPanel.updateGUI();
                parentPanel.revalidate();
            }
            
        });
        
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                oldState.removeTransition(oldSymbol);
                parentPanel.updateGUI();
                parentPanel.revalidate();
            }
            
        });
        
        this.add(dataField);
        this.add(editButton);
        this.add(deleteButton);
        
    }
}
