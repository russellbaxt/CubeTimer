package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class MKeyPressedAction extends AbstractAction{
	
	private Timer timer;
	
	public MKeyPressedAction(Timer t){
	
		timer = t;
	}
	
	public void actionPerformed(ActionEvent e){
	
		timer.mPressed();
		
	}
	
}
