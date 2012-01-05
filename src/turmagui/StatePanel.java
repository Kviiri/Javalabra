/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import turma.AMachine;

/**
 *
 * @author kviiri
 */
public class StatePanel extends JPanel {
    private AMachine machine;
    private ArrayList<JTextField> stateDescriptions;
    private ArrayList<JButton> editButtons;
    private GroupLayout gl;
    public StatePanel(AMachine machine) {
        gl = new GroupLayout(this);
        this.setLayout(gl);
        this.machine = machine;
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        
    }
    
}
