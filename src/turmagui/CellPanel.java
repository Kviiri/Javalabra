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
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.BevelBorder;
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
    private BorderLayout bl;
    
    public CellPanel(Tape t, int index, TapePanel parent) {
        this.setPreferredSize(new Dimension(40, 40));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        bl = new BorderLayout();
        bl.setHgap(10);
        this.setLayout(bl);
        currentTape = t;
        cellIndex = index;
        parentPanel = parent;
        
        indexLabel = new JLabel(index + "");
        indexLabel.setVerticalAlignment(JLabel.TOP);
        symbolTextLabel = new JLabel(currentTape.getSymbol(cellIndex).getName());
        symbolTextLabel.setHorizontalAlignment(JLabel.CENTER);
        
        if(t.getRwi() == cellIndex) {
            indexLabel.setOpaque(true);
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
        this.add(indexLabel, BorderLayout.NORTH);
        this.add(symbolTextLabel, BorderLayout.CENTER);
    }
}
