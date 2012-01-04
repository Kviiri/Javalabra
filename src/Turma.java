
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import turma.AMachine;
import turma.State;
import turma.Symbol;
import turma.Tape;
import turmagui.TapePanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kviiri
 */
public class Turma extends JFrame {
    private TapePanel tp;
    private JScrollPane scrollArea;
    private JButton advanceStepButton;
    public Turma(Tape t) {
        this.setSize(600, 300);
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        bl.setHgap(20);
        tp = new TapePanel(t);
        scrollArea = new JScrollPane(tp);
        scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        advanceStepButton = new JButton("Advance");
        
        this.add(scrollArea, BorderLayout.NORTH);
        this.add(advanceStepButton, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        AMachine am = new AMachine();
        State state1 = new State("Asd", false, am.getSymbols());
        Symbol sym1 = new Symbol("A");
        Symbol sym2 = new Symbol("B");
        am.addState(state1);
        am.addSymbol(sym1);
        am.addSymbol(sym2);
        am.getTape(0).setSymbol(1, sym1);
        am.getTape(0).setSymbol(2, sym2);
        am.getTape(0).setSymbol(0, sym2);
        am.getTape(0).setSymbol(3, sym1);
        am.getTape(0).setSymbol(4, sym2);
        am.getTape(0).setSymbol(5, sym2);
        am.getTape(0).setSymbol(6, sym1);
        am.getTape(0).setSymbol(7, sym2);
        am.getTape(0).setSymbol(8, sym2);
        am.getTape(0).setSymbol(9, sym1);
        am.getTape(0).setSymbol(10, sym2);
        am.getTape(0).setSymbol(11, sym2);
        am.getTape(0).setSymbol(12, sym1);
        am.getTape(0).setSymbol(13, sym2);
        am.getTape(0).setSymbol(14, sym2);
        am.getTape(0).setSymbol(15, sym1);
        am.getTape(0).setSymbol(16, sym2);
        am.getTape(0).setSymbol(17, sym2);
        Turma t = new Turma(am.getTape(0));
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.show();
    }
}
