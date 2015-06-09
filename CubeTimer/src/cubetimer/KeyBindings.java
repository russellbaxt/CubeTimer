package cubetimer;
 
import javax.swing.JComponent;
import javax.swing.KeyStroke;
 
public class KeyBindings extends JComponent{//extends JComponent because JComponent has KeyBindings
     
    private Timer timer;//makes object timer of class Timer
    private SpaceKeyAction spaceAction;
     
    public KeyBindings (Timer timerIn){//the constructor takes argument of class Timer to assign it to timer
        timer = timerIn;//assigns timerIn to timer
        spaceAction = new SpaceKeyAction(timer);//Initializes spaceAction as a new object of class SpaceAction
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SpacePressed"); //when you hit space it now looks on the action map for an action called SpacePressed
        this.getActionMap().put("SpacePressed", spaceAction);//when you look on the action map for soomething called SpacePressed you will now find an action that tells you to call the spaceAction object's actionPreforemed method
    }
 
}