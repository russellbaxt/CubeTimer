package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Stackmat;
import fields.Fields;

@SuppressWarnings("serial")
public class SpaceReleasedAction extends AbstractAction{
	
	private Fields fields;
	private Stackmat stackmat;
	
	public SpaceReleasedAction(Fields f, Stackmat sm){
	
		fields = f;
		stackmat = sm;
	}
	
	public void actionPerformed(ActionEvent e){
	
		fields.greenText = false;
		
		if(fields.ignoreNextRelese){
			fields.ignoreNextRelese = false;
		}
		
		else{
			if(! fields.timerStatus.running){
				
				fields.displayedDada.scrambleDada.randomScramble = "";
				
				if(fields.timerStatus.countDownRunning){
					
					stackmat.stopCountDown();
					stackmat.startTimer();
				}
				else{
					stackmat.StartCountDown();
				}
			}
		}
		
	}
	
}
