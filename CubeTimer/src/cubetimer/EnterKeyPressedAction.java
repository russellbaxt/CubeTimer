package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class EnterKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public EnterKeyPressedAction(KeyPresses kp){
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.enterPressed();
		
	}
	
	
	
}
