package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class GKeyPressedAction extends AbstractAction{
	private Timer timer;
	public GKeyPressedAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.gPressed();
		
	}
	
}
