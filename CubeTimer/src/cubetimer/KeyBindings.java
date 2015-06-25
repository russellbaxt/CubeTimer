package cubetimer;
 
import javax.swing.JComponent;
import javax.swing.KeyStroke;
 
public class KeyBindings extends JComponent{
     
    private Timer timer;
    private SpaceKeyAction spaceAction;
    private SpaceReleasedAction spaceReleasedAction;
    private TwoKeyAction twoAction;
    private ThreeKeyAction threeAction;
    private FourKeyAction fourAction;
    private FiveKeyAction fiveAction;
    private RightArrowKeyAction rightAction;
    private LeftArrowKeyAction leftAction;
    private RKeyPressedAction rAction;
    private MKeyPressedAction mAction;
    private GKeyPressedAction gAction;
    private AKeyPressedAction aAction;
    private VKeyPressedAction vAction;
    private OKeyPressedAction oAction;
    private DeletePressedAction deleteAction;
    private PlusKeyPressedAction plusAction;
     
    public KeyBindings (Timer timerIn){
        timer = timerIn;
        spaceAction = new SpaceKeyAction(timer);
        spaceReleasedAction = new SpaceReleasedAction(timer);
        twoAction = new TwoKeyAction(timer);
        threeAction = new ThreeKeyAction(timer);
        fourAction = new FourKeyAction(timer);
        fiveAction = new FiveKeyAction(timer);
        leftAction = new LeftArrowKeyAction(timer);
        rightAction = new RightArrowKeyAction(timer);
        rAction = new RKeyPressedAction(timer);
        mAction = new MKeyPressedAction(timer);
        gAction = new GKeyPressedAction(timer);
        aAction = new AKeyPressedAction(timer);
        vAction = new VKeyPressedAction(timer);
        oAction = new OKeyPressedAction(timer);
        deleteAction = new DeletePressedAction(timer);
        plusAction = new PlusKeyPressedAction(timer);
       
        
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
        this.getInputMap().put(KeyStroke.getKeyStroke("4"), "FourPressed");
        this.getActionMap().put("FourPressed", fourAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("5"), "FivePressed");
        this.getActionMap().put("FivePressed", fiveAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("R"), "RPressed");
        this.getActionMap().put("RPressed", rAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("M"), "MPressed");
        this.getActionMap().put("MPressed", mAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("G"), "GPressed");
        this.getActionMap().put("GPressed", gAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("A"), "APressed");
        this.getActionMap().put("APressed", aAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("O"), "OPressed");
        this.getActionMap().put("OPressed", oAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("V"), "VPressed");
        this.getActionMap().put("VPressed", vAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("DELETE"), "BackspacePressed");
        this.getActionMap().put("BackspacePressed", deleteAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("EQUALS"), "PlusPressed");
        this.getActionMap().put("PlusPressed", plusAction);
        
    }
 
}