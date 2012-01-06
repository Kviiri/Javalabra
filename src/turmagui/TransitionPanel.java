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
    private State state;
    private Symbol currentSymbol;
    private Transition transition;
    private JTextField dataField;
    private JButton editButton;
    public TransitionPanel(State state, Symbol currentSymbol, Transition transition, TransitionListPanel parent) {
        this.currentSymbol = currentSymbol;
        this.state = state;
        this.transition = transition;
        dataField = new JTextField(state + ", " + currentSymbol + " :  " + transition);
        editButton = new JButton("Edit");
        this.add(dataField);
        this.add(editButton);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //TODO: Open edit dialog
            }
            
        });
    }
}
