/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import javax.swing.JMenuItem;
import turma.Symbol;

/**
 *
 * @author kviiri
 */
public class CellMenuItem extends JMenuItem {
    Symbol sym;
    public CellMenuItem(String label, Symbol sym) {
        super(label);
        this.sym = sym;
    }
}
