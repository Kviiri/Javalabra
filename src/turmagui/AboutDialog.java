/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmagui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author kviiri
 */
public class AboutDialog extends JDialog {
    private JLabel text;
    private JButton closeButton;
    private JPanel spaceBalancePanel;
    public AboutDialog() {
        this.setLayout(new BorderLayout());
        this.setSize(512, 128);
        text = new JLabel("TurMa v.0.000000... Designed and Developed by Kalle Viiri");
        text.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
            
        });
        spaceBalancePanel = new JPanel();
        spaceBalancePanel.add(closeButton);
        this.add(text, BorderLayout.CENTER);
        this.add(spaceBalancePanel, BorderLayout.SOUTH);
        
    }
}
