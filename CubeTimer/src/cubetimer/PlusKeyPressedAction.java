package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class PlusKeyPressedAction extends AbstractAction{
	private Timer timer;
	public PlusKeyPressedAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.plusPressed();
		
	}
}
