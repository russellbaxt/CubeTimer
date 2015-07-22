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
	
	private EscapeKeyPressedAction escapeAction;
	private EnterKeyPressedAction enterAction;
	private UpArrowPressedAction upAction;
	private DownArrowPressedAction downAction;
	
	public KeyBindings(KeyPresses kp){
	
		
		spaceAction = new SpaceKeyAction(kp);
		spaceReleasedAction = new SpaceReleasedAction(kp);
		backSpaceAction = new BackSpaceKeyPressedAction(kp);
		
		twoAction = new TwoKeyAction(kp);
		threeAction = new ThreeKeyAction(kp);
		fourAction = new FourKeyAction(kp);
		fiveAction = new FiveKeyAction(kp);
		
		escapeAction = new EscapeKeyPressedAction(kp);
		enterAction = new EnterKeyPressedAction(kp);
		upAction = new UpArrowPressedAction(kp);
		downAction = new DownArrowPressedAction(kp);
		
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
		this.getInputMap().put(KeyStroke.getKeyStroke("4"), "FourPressed");
		this.getActionMap().put("FourPressed", fourAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("5"), "FivePressed");
		this.getActionMap().put("FivePressed", fiveAction);
		
		this.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "EscapePressed");
		this.getActionMap().put("EscapePressed", escapeAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "EnterPressed");
		this.getActionMap().put("EnterPressed", enterAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "UpPressed");
		this.getActionMap().put("UpPressed", upAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DownPressed");
		this.getActionMap().put("DownPressed", downAction);
		
		
	}
	
}
