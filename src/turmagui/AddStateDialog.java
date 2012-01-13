/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import javax.swing.JDialog;
import turma.AMachine;

/**
 *
 * @author kviiri
 */
public class AddStateDialog extends JDialog {
    private AMachine machine;
    public AddStateDialog(AMachine am) {
        machine = am;
    }
}
