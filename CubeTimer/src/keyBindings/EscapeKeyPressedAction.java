package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.KeyPresses;
import cubetimer.Paint;
import fields.DisplayState;
import fields.Fields;


public class EscapeKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	private Fields fields;
	private Paint paint;
	
	public EscapeKeyPressedAction(KeyPresses kp, Fields f, Paint p){
		keyPresses = kp;
		fields = f;
		paint = p;
	}

	public void actionPerformed(ActionEvent e){
	
		if(fields.displayState == DisplayState.timer){
			fields.displayState = DisplayState.menu;
		}
		
		paint.repaint();
		
	}
}
