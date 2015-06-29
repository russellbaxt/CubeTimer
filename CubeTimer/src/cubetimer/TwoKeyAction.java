package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class TwoKeyAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public TwoKeyAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.twoPressed();
		
	}
}
