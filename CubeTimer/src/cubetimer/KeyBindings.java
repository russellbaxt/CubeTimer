package cubetimer;
 
import javax.swing.JComponent;
import javax.swing.KeyStroke;
 
public class KeyBindings extends JComponent{
     
    private Timer timer;
    private SpaceKeyAction spaceAction;
    private SpaceReleasedAction spaceReleasedAction;
    private TwoKeyAction twoAction;
    private ThreeKeyAction threeAction;
     
    public KeyBindings (Timer timerIn){
        timer = timerIn;
        spaceAction = new SpaceKeyAction(timer);
        spaceReleasedAction = new SpaceReleasedAction(timer);
        twoAction = new TwoKeyAction(timer);
        threeAction = new ThreeKeyAction(timer);
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SpacePressed");
        this.getActionMap().put("SpacePressed", spaceAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "SpaceReleased");
        this.getActionMap().put("SpaceReleased", spaceReleasedAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("2"), "TwoPressed");
        this.getActionMap().put("TwoPressed", twoAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("3"), "ThreePressed");
        this.getActionMap().put("ThreePressed", threeAction);
    }
 
}