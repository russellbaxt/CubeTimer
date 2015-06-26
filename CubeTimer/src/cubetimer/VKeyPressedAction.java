package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class VKeyPressedAction extends AbstractAction{
	
	private Timer timer;
	
	public VKeyPressedAction(Timer t){
	
		timer = t;
	}
	
	public void actionPerformed(ActionEvent e){
	
		timer.vPressed();
		
	}
	
}
