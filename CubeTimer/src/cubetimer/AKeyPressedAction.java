package cubetimer;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class AKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	
	public AKeyPressedAction(KeyPresses kp){
	
		keyPresses = kp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
	
		keyPresses.aPressed();
		
	}
	
}
