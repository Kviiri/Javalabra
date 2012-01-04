/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import turma.Tape;
/**
 *
 * @author kviiri
 */
public class TapePanel extends JPanel {
    private Tape sourceTape;
    public TapePanel(Tape tape) {
        sourceTape = tape;
        this.setSize(new Dimension(tape.length() * 50, 60));        
        updateGUI();
    }
    
    public final void updateGUI() {
        for(int i = 0; i < sourceTape.length(); i++) {
           this.add(new CellPanel(sourceTape, i, this));
        }
    }
}
