package cubetimer;
 
import javax.swing.JComponent;
import javax.swing.KeyStroke;
 
public class KeyBindings extends JComponent{
     
    private Timer timer;
    private SpaceKeyAction spaceAction;
    private SpaceReleasedAction spaceReleasedAction;
     
    public KeyBindings (Timer timerIn){
        timer = timerIn;
        spaceAction = new SpaceKeyAction(timer);
        spaceReleasedAction = new SpaceReleasedAction(timer);
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SpacePressed");
        this.getActionMap().put("SpacePressed", spaceAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "SpaceReleased");
        this.getActionMap().put("SpaceReleased", spaceReleasedAction);
    }
 
}