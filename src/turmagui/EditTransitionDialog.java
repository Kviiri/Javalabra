/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import turma.AMachine;
import turma.Direction;
import turma.State;
import turma.Symbol;
import turma.Transition;

/**
 *
 * @author kviiri
 */
public class EditTransitionDialog extends JDialog {
    private JComboBox oldStateBox;
    private JComboBox oldSymbolBox;
    private JComboBox newStateBox;
    private JComboBox newSymbolBox;
    private JComboBox directionBox;
    private JButton okButton;
    private JButton cancelButton;
    
    public EditTransitionDialog(AMachine machine) {
        oldStateBox = new JComboBox();
        oldSymbolBox = new JComboBox();
        newStateBox = new JComboBox();
        newSymbolBox = new JComboBox();
        directionBox = new JComboBox();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        
        for(State s : machine.getStates()) {
            oldStateBox.addItem(s);
            newStateBox.addItem(s);
        }
        
        for(Symbol s : machine.getSymbols()) {
            oldSymbolBox.addItem(s);
            newSymbolBox.addItem(s);
        }
        
        directionBox.addItem(Direction.LEFT);
        directionBox.addItem(Direction.RIGHT);
        directionBox.addItem(Direction.NONE);
        
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //Lord forgive me for all this type casting
                State saveState = (State)oldStateBox.getSelectedItem();
                Symbol saveSymbol = (Symbol)oldSymbolBox.getSelectedItem();
                Transition newTransition = new Transition((Symbol)newSymbolBox.getSelectedItem(),
                        (Direction)directionBox.getSelectedItem(), (State)newStateBox.getSelectedItem());
                dispose();
            }
            
        });
        
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
            
        });
    }
    public EditTransitionDialog(State state, Symbol symbol, Transition transition, AMachine machine) {
        this(machine);
        oldStateBox.setSelectedItem(state);
        oldSymbolBox.setSelectedItem(symbol);
        newStateBox.setSelectedItem(transition.getSta());
        newSymbolBox.setSelectedItem(transition.getSym());
        directionBox.setSelectedItem(transition.getDir());
    }    
}
