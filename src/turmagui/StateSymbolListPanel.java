/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import turma.AMachine;

/**
 *
 * @author kviiri
 */
public class StateSymbolListPanel extends JPanel {
    private AMachine am;
    private JList symbolList;
    private JList stateList;
    private GridLayout gl;
    public StateSymbolListPanel(AMachine am) {
        this.am = am;    
        gl = new GridLayout(1, 2);
        this.setLayout(gl);
        updateGUI();
        
    }

    public final void updateGUI() {
        this.removeAll();
        
        symbolList = new JList(am.getSymbols().toArray());
        stateList = new JList(am.getStates().toArray());
        symbolList.setSelectedValue(am.getTape().readSymbol(), true);
        stateList.setSelectedValue(am.getCurrentState(), true);
        symbolList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        stateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        symbolList.setEnabled(false);
        stateList.setEnabled(false);
        
        this.add(symbolList);
        this.add(stateList);
        this.revalidate();
    }
}
