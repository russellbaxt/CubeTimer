package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class RightArrowKeyAction extends AbstractAction{
	private Timer timer;
	public RightArrowKeyAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.rightPressed();
		
	}
}
