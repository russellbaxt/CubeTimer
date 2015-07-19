package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class DownArrowPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public DownArrowPressedAction(KeyPresses kp){
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
	keyPresses.downPressed();	
	}
}
