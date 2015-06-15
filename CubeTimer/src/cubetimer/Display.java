package cubetimer;
 
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Display extends JFrame{
    private JPanel gp;//creates object gp of class JPanel
    private KeyBindings kb;//creates object kb of class KeyBindingds
     
    public Display(Timer t){//this is the constructor
        gp = (JPanel) getGlassPane();//Initializes gp to a glass pane
        gp.setVisible(true);//makes the glass pane visible
        kb = new KeyBindings(t);//Initializes kb as a new KeyBindings object. gives t as a parameter
        gp.setLayout(new GridLayout(1,1));//this sets the Layout of the window if the values are more that one, your windows will get spit up for different objects to work with
        this.setLayout(new GridLayout(1,1));//this does the same thing as the line before but just for this class insted of glass pane
        gp.add(t);//adds object t to gp so you can see what the timer paints
        this.add(kb);//you need to add kb to either this object or the object gp. if you add it to gp, it will split up the screen and only half the screen will have anything on it
    }
}