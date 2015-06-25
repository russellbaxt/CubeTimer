package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class DashKeyPressedAction extends AbstractAction{
	private Timer timer;
	public DashKeyPressedAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.dashPressed();
		
	}
}
