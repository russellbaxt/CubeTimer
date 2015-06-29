package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class OKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public OKeyPressedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.oPressed();
		
	}
}
