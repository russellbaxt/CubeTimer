package keyBindings;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import cubetimer.KeyPresses;
import fields.Fields;

public class KeyBindings extends JComponent{
	
	private Fields fields;
	
	private SpaceKeyAction spaceAction;
	private SpaceReleasedAction spaceReleasedAction;
	
	private EscapeKeyPressedAction escapeAction;
	private EnterKeyPressedAction enterAction;
	private UpArrowPressedAction upAction;
	private DownArrowPressedAction downAction;
	
	public KeyBindings(KeyPresses kp){
	
		
		spaceAction = new SpaceKeyAction(kp);
		spaceReleasedAction = new SpaceReleasedAction(kp);
		
		escapeAction = new EscapeKeyPressedAction(kp);
		enterAction = new EnterKeyPressedAction(kp);
		upAction = new UpArrowPressedAction(kp);
		downAction = new DownArrowPressedAction(kp);
		
		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SpacePressed");
		this.getActionMap().put("SpacePressed", spaceAction);
		this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "SpaceReleased");
		this.getActionMap().put("SpaceReleased", spaceReleasedAction);
		
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LeftPressed");
		
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
