package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SpaceReleasedAction extends AbstractAction{
	
	private Timer timer;
	
	public SpaceReleasedAction(Timer t){
	
		timer = t;
	}
	
	public void actionPerformed(ActionEvent e){
	
		timer.spaceReleased();
		
	}
	
}
