/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import turma.Tape;
/**
 *
 * @author kviiri
 */
public class TapePanel extends JPanel {
    private Tape sourceTape;
    private JScrollPane scrollArea;
    
    public TapePanel(Tape tape) {
        scrollArea = new JScrollPane(this);
        sourceTape = tape;
        this.setSize(500, 100);
        
        for(int i = 0; i < sourceTape.tapeLength(); i++) {
            this.add(new CellPanel(sourceTape, i, this));
        }       
    }
    
    public void updateGUI() {
        for(int i = 0; i < sourceTape.tapeLength(); i++) {
            this.add(new CellPanel(sourceTape, i, this));
        }
    }
}
