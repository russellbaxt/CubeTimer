package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.KeyPresses;

public class SpaceKeyAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public SpaceKeyAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.spacePressed();
	}
	
}
