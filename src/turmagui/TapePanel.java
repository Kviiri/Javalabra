/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.Dimension;
import javax.swing.JPanel;
import turma.Tape;
/**
 *
 * @author kviiri
 */
public class TapePanel extends JPanel {
    private Tape sourceTape;
    public TapePanel(Tape tape) {
        sourceTape = tape;       
        updateGUI();
    }
    
    public final void updateGUI() {
        this.removeAll();
        this.setSize(new Dimension(sourceTape.length() * 50, 60));
        for(int i = 0; i < sourceTape.length(); i++) {
           this.add(new CellPanel(sourceTape, i, this));
        }
    }
}
