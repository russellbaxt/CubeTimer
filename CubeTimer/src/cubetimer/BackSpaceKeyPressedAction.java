package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class BackSpaceKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public BackSpaceKeyPressedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.deletePressed();
		
	}
}
