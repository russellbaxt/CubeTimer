package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.KeyPresses;


public class EscapeKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public EscapeKeyPressedAction(KeyPresses kp){
		keyPresses = kp;
	}

	public void actionPerformed(ActionEvent e){
	
		keyPresses.escapePressed();
		
	}
}
