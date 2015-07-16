package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class RKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public RKeyPressedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.rPressed();
		
	}
}
