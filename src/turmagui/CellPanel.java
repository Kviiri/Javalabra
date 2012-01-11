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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.BevelBorder;
import turma.Symbol;
import turma.EmptyTapeException;

/**
 *
 * @author kviiri
 */
public class CellPanel extends JPanel {

    private int cellIndex;
    private TapePanel parentPanel;
    private JPopupMenu cellMenu;    //cellMenu is shown when the CellPanel is right-clicked
    private JLabel symbolTextLabel;
    private JLabel indexLabel;
    private BorderLayout bl;

    public CellPanel(TapePanel parent, int index) {
        this.setPreferredSize(new Dimension(40, 40));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        bl = new BorderLayout();
        bl.setHgap(10);
        this.setLayout(bl);
        cellIndex = index;
        parentPanel = parent;

        indexLabel = new JLabel(index + "");
        indexLabel.setVerticalAlignment(JLabel.TOP);
        symbolTextLabel = new JLabel(parent.getTape().getSymbol(cellIndex).getName());
        symbolTextLabel.setHorizontalAlignment(JLabel.CENTER);

        if (parent.getTape().getHead() == cellIndex) {
            indexLabel.setOpaque(true);
            indexLabel.setBackground(Color.RED);
        }
        cellMenu = new JPopupMenu();
        JMenuItem setHeadHere = new JMenuItem("Set head here");
        JMenu changeSymbol = new JMenu("Change symbol");
        JMenuItem deleteCell = new JMenuItem("Delete this cell");
        JMenu insertCellBefore = new JMenu("Insert before");
        JMenu insertCellAfter = new JMenu("Insert after");
        
        
        deleteCell.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    parentPanel.getTape().deleteCell(cellIndex, true);
                    parentPanel.updateGUI();
                }
                catch(EmptyTapeException ete) {
                    JOptionPane.showMessageDialog(null, ete, "HUPS", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });

        for (final Symbol s : parent.getMachine().getSymbols()) {
            CellMenuItem menuItemChangeSymbol = new CellMenuItem(s.getName(), s);
            menuItemChangeSymbol.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    parentPanel.getTape().setSymbol(cellIndex, s);
                    parentPanel.updateGUI();
                }
            });
            
            CellMenuItem menuItemInsertBefore = new CellMenuItem(s.getName(), s);
            menuItemInsertBefore.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    parentPanel.getTape().insertSymbol(cellIndex, s, true);
                    parentPanel.updateGUI();
                }
                
            });
            
            CellMenuItem menuItemInsertAfter = new CellMenuItem(s.getName(), s);
            menuItemInsertAfter.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    parentPanel.getTape().insertSymbol(cellIndex + 1, s, true);
                    parentPanel.updateGUI();
                }
                
            });
            
            changeSymbol.add(menuItemChangeSymbol);
            insertCellBefore.add(menuItemInsertBefore);
            insertCellAfter.add(menuItemInsertAfter);
        }

        setHeadHere.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.getTape().setHead(cellIndex);
                parentPanel.updateGUI();
            }
        });
        
        cellMenu.add(setHeadHere);
        cellMenu.add(changeSymbol);
        cellMenu.add(insertCellBefore);
        cellMenu.add(insertCellAfter);
        cellMenu.add(deleteCell);
        
        
        this.add(indexLabel, BorderLayout.NORTH);
        this.add(symbolTextLabel, BorderLayout.CENTER);
        this.addMouseListener(new PopupListener());
    }

    class PopupListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getButton() == MouseEvent.BUTTON3) {
                cellMenu.show(me.getComponent(), me.getX(), me.getY());
            }
        }
    }
}
