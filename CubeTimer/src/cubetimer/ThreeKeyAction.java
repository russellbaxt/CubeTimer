package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ThreeKeyAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public ThreeKeyAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.threePressed();
		
	}
	
}
