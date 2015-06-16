package cubetimer;
 
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Display extends JFrame{
    private JPanel gp;
    private KeyBindings kb;
     
    public Display(Timer t){
        gp = (JPanel) getGlassPane();
        gp.setVisible(true);
        kb = new KeyBindings(t);
        gp.setLayout(new GridLayout(1,1));
        this.setLayout(new GridLayout(1,1));
        gp.add(t);
        this.add(kb);
    }
}