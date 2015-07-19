package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class UpArrowPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public UpArrowPressedAction(KeyPresses kp){
		keyPresses = kp;
	}

	public void actionPerformed(ActionEvent e){
	
		keyPresses.upPressed();
	}
}
