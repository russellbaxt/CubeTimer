package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class RKeyPressedAction extends AbstractAction{
	
	private Timer timer;
	
	public RKeyPressedAction(Timer t){
	
		timer = t;
	}
	
	public void actionPerformed(ActionEvent e){
	
		timer.rPressed();
		
	}
}
