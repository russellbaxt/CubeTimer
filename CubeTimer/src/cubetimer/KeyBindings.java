package cubetimer;
 
import javax.swing.JComponent;
import javax.swing.KeyStroke;
 
public class KeyBindings extends JComponent{
     
    private Timer timer;
    private SpaceKeyAction spaceAction;
    private SpaceReleasedAction spaceReleasedAction;
    private TwoKeyAction twoAction;
    private ThreeKeyAction threeAction;
    private RightArrowKeyAction rightAction;
    private LeftArrowKeyAction leftAction;
     
    public KeyBindings (Timer timerIn){
        timer = timerIn;
        spaceAction = new SpaceKeyAction(timer);
        spaceReleasedAction = new SpaceReleasedAction(timer);
        twoAction = new TwoKeyAction(timer);
        threeAction = new ThreeKeyAction(timer);
        leftAction = new LeftArrowKeyAction(timer);
        rightAction = new RightArrowKeyAction(timer);
        
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SpacePressed");
        this.getActionMap().put("SpacePressed", spaceAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "SpaceReleased");
        this.getActionMap().put("SpaceReleased", spaceReleasedAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("2"), "TwoPressed");
        this.getActionMap().put("TwoPressed", twoAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("3"), "ThreePressed");
        this.getActionMap().put("ThreePressed", threeAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LeftPressed");
        this.getActionMap().put("LeftPressed", leftAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RightPressed");
        this.getActionMap().put("RightPressed", rightAction);
    }
 
}