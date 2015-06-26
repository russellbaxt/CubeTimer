package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class FiveKeyAction extends AbstractAction{
	
	private Timer timer;
	
	public FiveKeyAction(Timer t){
	
		timer = t;
	}
	
	public void actionPerformed(ActionEvent e){
	
		timer.fivePressed();
		
	}
	
}
