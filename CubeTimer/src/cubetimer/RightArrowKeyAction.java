package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class RightArrowKeyAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public RightArrowKeyAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.rightPressed();
		
	}
}
