/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import turma.Tape;
/**
 *
 * @author kviiri
 */
public class CellPanel extends JPanel {
    private Tape currentTape;
    private int cellIndex;
    private TapePanel parentPanel;
    private JPopupMenu cellMenu;    //cellMenu is shown when the CellPanel is right-clicked
    private JLabel symbolTextLabel;
    private JLabel indexLabel;
    
    public CellPanel(Tape t, int index, TapePanel parent) {
        this.setPreferredSize(new Dimension(80, 80));
        currentTape = t;
        cellIndex = index;
        parentPanel = parent;
        symbolTextLabel = new JLabel(currentTape.getSymbol(cellIndex).getName());
        indexLabel = new JLabel(index + "");
        this.add(indexLabel, BorderLayout.WEST);
        this.add(symbolTextLabel, BorderLayout.CENTER);
        if(t.getRwi() == cellIndex) {
            indexLabel.setBackground(Color.RED);
        }
        cellMenu = new JPopupMenu();
        JMenuItem setHeadHere = new JMenuItem("Set head here");
        setHeadHere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTape.setRwi(cellIndex);
                parentPanel.updateGUI();
            }
        });
    }
}
