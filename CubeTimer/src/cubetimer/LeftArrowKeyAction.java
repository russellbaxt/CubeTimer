package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class LeftArrowKeyAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public LeftArrowKeyAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.leftPressed();
		
	}
	
}
