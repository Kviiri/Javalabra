
import javax.swing.JFrame;
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
    TapePanel tp;
    public Turma(Tape t) {
        this.setSize(600, 300);
        tp = new TapePanel(t);
        this.add(tp);
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
        Turma t = new Turma(am.getTape(0));
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.show();
    }
}
