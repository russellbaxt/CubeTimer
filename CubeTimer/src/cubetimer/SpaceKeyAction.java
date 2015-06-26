package cubetimer;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class SpaceKeyAction extends AbstractAction{
	
	private Timer timer;
	
	public SpaceKeyAction(Timer timerIn){
	
		timer = timerIn;
	}
	
	public void actionPerformed(ActionEvent e){
	
		timer.spacePressed();
	}
	
}
