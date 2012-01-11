
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import turma.AMachine;
import turma.State;
import turma.Symbol;
import turma.Tape;
import turmagui.EditTransitionDialog;
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
    private JScrollPane tapeScrollPane;
    private JScrollPane transitionScrollPane;
    private JButton advanceStepButton;
    private JButton addTransitionButton;
    private JPanel leftPanel;
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
            }
            
        });
        
        
        advanceStepButton = new JButton("Advance");
        
        
        
        this.add(leftPanel, BorderLayout.WEST);
        this.add(tapeScrollPane, BorderLayout.NORTH);
        this.add(advanceStepButton, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        AMachine am = new AMachine();
        State state1 = new State("Asd", false);
        Symbol sym1 = new Symbol("A");
        Symbol sym2 = new Symbol("B");
        am.addState(state1);
        am.addSymbol(sym1);
        am.addSymbol(sym2);
        am.getTape(0).setSymbol(1, sym1);
        am.getTape(0).setSymbol(2, sym2);
        am.getTape(0).setSymbol(0, sym2);
        Turma t = new Turma(am);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.show();
    }
}
