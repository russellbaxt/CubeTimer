package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class FourKeyAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public FourKeyAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.fourPressed();
		
	}
}
