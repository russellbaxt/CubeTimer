package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.KeyPresses;


public class UpArrowPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public UpArrowPressedAction(KeyPresses kp){
		keyPresses = kp;
	}

	public void actionPerformed(ActionEvent e){
	
		keyPresses.upPressed();
	}
}
