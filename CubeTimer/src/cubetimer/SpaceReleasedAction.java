package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SpaceReleasedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public SpaceReleasedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	public void actionPerformed(ActionEvent e){
	
		keyPresses.spaceReleased();
		
	}
	
}
