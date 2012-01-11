/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.Dimension;
import javax.swing.JPanel;
import turma.AMachine;
import turma.Tape;
/**
 *
 * @author kviiri
 */
public class TapePanel extends JPanel {
    private AMachine machine;
    private int tapeIndex;
    public TapePanel(AMachine machine, int tapeIndex) {
        this.machine = machine;
        this.tapeIndex = tapeIndex;
        updateGUI();
    }
    
    public final void updateGUI() {
        this.removeAll();
        this.setSize(new Dimension(machine.getTape(tapeIndex).length() * 50, 60));
        for(int i = 0; i < machine.getTape(tapeIndex).length(); i++) {
           this.add(new CellPanel(this, i));
        }
    }

    public Tape getTape() {
        return machine.getTape(tapeIndex);
    }
    public AMachine getMachine() {
        return machine;
    }
}
