package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class LeftArrowKeyAction extends AbstractAction{
	private Timer timer;
	public LeftArrowKeyAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.leftPressed();
		
	}
	
}
