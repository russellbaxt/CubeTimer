package keyBindings;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import cubetimer.Actions;
import cubetimer.CloseOperation;
import cubetimer.KeyPresses;
import cubetimer.Paint;
import cubetimer.Scrambler;
import cubetimer.Stackmat;
import fields.Fields;

public class KeyBindings extends JComponent{
	
	private Fields fields;
	private Paint paint;
	private Scrambler scrambler;
	private Actions actions;
	private Stackmat stackmat;
	
	private SpaceKeyAction spaceAction;
	private SpaceReleasedAction spaceReleasedAction;
	
	private EscapeKeyPressedAction escapeAction;
	private EnterKeyPressedAction enterAction;
	private UpArrowPressedAction upAction;
	private DownArrowPressedAction downAction;
	
	public KeyBindings(KeyPresses kp, Fields fieldsIn, Paint paintIn, Scrambler scramblerIn, Actions actionsIn,
			Stackmat stackmatIn){
		
		fields = fieldsIn;
		paint = paintIn;
		scrambler = scramblerIn;
		actions = actionsIn;
		stackmat = stackmatIn;
	
		spaceAction = new SpaceKeyAction(kp, fields, paint, stackmat, scrambler);
		spaceReleasedAction = new SpaceReleasedAction(kp, fields, stackmat);
		
		escapeAction = new EscapeKeyPressedAction(kp, fields, paint);
		enterAction = new EnterKeyPressedAction(kp, fields, paint, scrambler, actions);
		upAction = new UpArrowPressedAction(kp, fields, paint, scrambler);
		downAction = new DownArrowPressedAction(kp, fields, paint, scrambler);
		
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
