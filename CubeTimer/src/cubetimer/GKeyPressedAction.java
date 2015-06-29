package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class GKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public GKeyPressedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.gPressed();
		
	}
	
}
