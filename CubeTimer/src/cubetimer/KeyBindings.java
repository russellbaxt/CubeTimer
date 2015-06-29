package cubetimer;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class KeyBindings extends JComponent{
	
	private Fields fields;
	
	private SpaceKeyAction spaceAction;
	private SpaceReleasedAction spaceReleasedAction;
	private BackSpaceKeyPressedAction backSpaceAction;
	
	private TwoKeyAction twoAction;
	private ThreeKeyAction threeAction;
	private FourKeyAction fourAction;
	private FiveKeyAction fiveAction;
	private MKeyPressedAction mAction;
	private GKeyPressedAction gAction;
	private AKeyPressedAction aAction;
	private VKeyPressedAction vAction;
	private OKeyPressedAction oAction;
	
	private RKeyPressedAction rAction;
	
	private RightArrowKeyAction rightAction;
	private LeftArrowKeyAction leftAction;

	private PlusKeyPressedAction plusAction;
	private DashKeyPressedAction dashAction;
	
	public KeyBindings(KeyPresses kp){
	
		
		spaceAction = new SpaceKeyAction(kp);
		spaceReleasedAction = new SpaceReleasedAction(kp);
		backSpaceAction = new BackSpaceKeyPressedAction(kp);
		
		twoAction = new TwoKeyAction(kp);
		threeAction = new ThreeKeyAction(kp);
		fourAction = new FourKeyAction(kp);
		fiveAction = new FiveKeyAction(kp);
		mAction = new MKeyPressedAction(kp);
		gAction = new GKeyPressedAction(kp);
		aAction = new AKeyPressedAction(kp);
		vAction = new VKeyPressedAction(kp);
		oAction = new OKeyPressedAction(kp);
		
		rAction = new RKeyPressedAction(kp);
		
		leftAction = new LeftArrowKeyAction(kp);
		rightAction = new RightArrowKeyAction(kp);
		
		plusAction = new PlusKeyPressedAction(kp);
		dashAction = new DashKeyPressedAction(kp);
		
		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SpacePressed");
		this.getActionMap().put("SpacePressed", spaceAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "SpaceReleased");
		this.getActionMap().put("SpaceReleased", spaceReleasedAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "BackspacePressed");
		this.getActionMap().put("BackspacePressed", backSpaceAction);
		
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
		
		this.getInputMap().put(KeyStroke.getKeyStroke("R"), "RPressed");
		this.getActionMap().put("RPressed", rAction);

		this.getInputMap().put(KeyStroke.getKeyStroke("EQUALS"), "PlusPressed");
		this.getActionMap().put("PlusPressed", plusAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("MINUS"), "DashPressed");
		this.getActionMap().put("DashPressed", dashAction);
		
	}
	
}
