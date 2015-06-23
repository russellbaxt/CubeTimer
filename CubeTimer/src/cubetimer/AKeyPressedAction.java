package cubetimer;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class AKeyPressedAction extends AbstractAction{
	private Timer timer;
	public AKeyPressedAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.aPressed();
		
	}
	
}
