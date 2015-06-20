package cubetimer;
 
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Display extends JFrame{
    private JPanel gp;
    private KeyBindings kb;
     
    public Display(Timer t){
    	Dimension size = getSize();
        gp = (JPanel) getGlassPane();
        gp.setVisible(true);
        kb = new KeyBindings(t);
        gp.setLayout(new GridLayout(1,1));
        this.setLayout(new GridLayout(1,1));
        gp.add(t);
        this.add(kb);
    }
    public int getWidth(){
    	Dimension size = getSize();
    	return size.width;
    }
    public int getHeight(){
    	Dimension size = getSize();
    	return size.height;
    }
}