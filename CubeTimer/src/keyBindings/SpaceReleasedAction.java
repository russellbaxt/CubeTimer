package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.KeyPresses;
import cubetimer.Stackmat;
import fields.Fields;

public class SpaceReleasedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	private Fields fields;
	private Stackmat stackmat;
	
	public SpaceReleasedAction(KeyPresses kp, Fields f, Stackmat sm){
	
		keyPresses = kp;
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
