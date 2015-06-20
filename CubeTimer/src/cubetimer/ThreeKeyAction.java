package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ThreeKeyAction extends AbstractAction{
	private Timer timer;
	public ThreeKeyAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.threePressed();
		
	}
	
}
