
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import turma.AMachine;
import turma.Direction;
import turma.NoTransitionException;
import turma.State;
import turma.Symbol;
import turma.Tape;
import turma.Transition;
import turmagui.AboutDialog;
import turmagui.EditTransitionDialog;
import turmagui.StateSymbolListPanel;
import turmagui.TapePanel;
import turmagui.TransitionListPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kviiri
 */
public class Turma extends JFrame {
    private AMachine am;
    private TapePanel tape;
    private TransitionListPanel transList;
    private StateSymbolListPanel listPanel;
    private JScrollPane tapeScrollPane;
    private JScrollPane transitionScrollPane;
    private JButton advanceStepButton;
    private JButton addTransitionButton;
    private JPanel leftPanel;
    private JMenuBar mainMenuBar;
    private JMenu fileMenu;
    private JMenuItem about;
    public Turma(AMachine machine) {
        am = machine;
        this.setSize(600, 300);
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        bl.setHgap(20);
        tape = new TapePanel(am, 0);
        tapeScrollPane = new JScrollPane(tape);
        tapeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        tapeScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        addTransitionButton = new JButton("New Transition");
        leftPanel.add(addTransitionButton, BorderLayout.NORTH);
        
        transList = new TransitionListPanel(am);
        transitionScrollPane = new JScrollPane(transList);
        leftPanel.add(transitionScrollPane, BorderLayout.CENTER);
        
        addTransitionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                EditTransitionDialog etd = new EditTransitionDialog(am);
                etd.show();
                transList.updateGUI();
                transList.revalidate();
            }
            
        });
        
        
        advanceStepButton = new JButton("Advance");
        advanceStepButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    am.advanceStep();
                    tape.updateGUI();
                    listPanel.updateGUI();
                } catch (NoTransitionException nte) {
                     JOptionPane.showMessageDialog(null, nte, "HUPS", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
        });
        
        listPanel = new StateSymbolListPanel(am);
        this.setTitle("TurMa Press Release");
        
        mainMenuBar = new JMenuBar();
        about = new JMenuItem("About...");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AboutDialog ad = new AboutDialog();
                ad.show();
            }
            
        });
        fileMenu = new JMenu("File");
        fileMenu.add(about);
        mainMenuBar.add(fileMenu);
        this.add(mainMenuBar);        
        this.setJMenuBar(mainMenuBar);
        
        
        this.add(listPanel, BorderLayout.CENTER);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(tapeScrollPane, BorderLayout.NORTH);
        this.add(advanceStepButton, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        State state1 = new State("A", false);
        State state2 = new State("B", false);
        State halt = new State("HALT", true);
        Symbol sym0 = new Symbol("0");
        Symbol sym1 = new Symbol("1");
        AMachine am = new AMachine(sym0, state1);
        am.addState(state1);
        am.addState(state2);
        am.addState(halt);
        am.addSymbol(sym1);
        am.addSymbol(sym0);
        state1.addTransition(sym0, new Transition(sym1, Direction.RIGHT, state2));
        state1.addTransition(sym1, new Transition(sym1, Direction.LEFT, state2));
        state2.addTransition(sym0, new Transition(sym1, Direction.LEFT, state1));
        state2.addTransition(sym1, new Transition(sym1, Direction.RIGHT, halt));
        
        Turma t = new Turma(am);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.show();
    }
}
