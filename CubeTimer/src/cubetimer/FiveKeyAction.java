package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class FiveKeyAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public FiveKeyAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.fivePressed();
		
	}
	
}
