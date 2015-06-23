package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class OKeyPressedAction extends AbstractAction{
	private Timer timer;
	public OKeyPressedAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.oPressed();
		
	}
}
