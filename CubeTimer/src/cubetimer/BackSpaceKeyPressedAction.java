package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class BackSpaceKeyPressedAction extends AbstractAction{
	private Timer timer;
	public BackSpaceKeyPressedAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.deletePressed();
		
	}
}
