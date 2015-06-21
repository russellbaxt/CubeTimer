package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class FourKeyAction extends AbstractAction{
	private Timer timer;
	public FourKeyAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.fourPressed();
		
	}
}
