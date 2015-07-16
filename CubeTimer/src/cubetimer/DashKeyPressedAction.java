package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class DashKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public DashKeyPressedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.dashPressed();
		
	}
}
