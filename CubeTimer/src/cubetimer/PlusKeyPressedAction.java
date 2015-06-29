package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class PlusKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public PlusKeyPressedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.plusPressed();
		
	}
}
