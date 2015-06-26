package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class TwoKeyAction extends AbstractAction{
	
	private Timer timer;
	
	public TwoKeyAction(Timer t){
	
		timer = t;
	}
	
	public void actionPerformed(ActionEvent e){
	
		timer.twoPressed();
		
	}
}
