package cubetimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class DeletePressedAction extends AbstractAction{
	private Timer timer;
	public DeletePressedAction(Timer t){
		timer = t;
	}
	public void actionPerformed(ActionEvent e) {
		timer.deletePressed();
		
	}
}
