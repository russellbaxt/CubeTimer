package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class VKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public VKeyPressedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.vPressed();
		
	}
	
}
