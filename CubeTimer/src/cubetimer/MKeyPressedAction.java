package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class MKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public MKeyPressedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.mPressed();
		
	}
	
}
