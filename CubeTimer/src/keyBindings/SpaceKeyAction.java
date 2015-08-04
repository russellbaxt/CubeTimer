package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Actions;
import cubetimer.KeyPresses;
import cubetimer.Paint;
import cubetimer.Scrambler;
import cubetimer.Stackmat;
import fields.Fields;

public class SpaceKeyAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	private Fields fields;
	private Paint paint;
	private Stackmat stackmat;
	private Scrambler scrambler;
	
	public SpaceKeyAction(KeyPresses kp, Fields f, Paint p, Stackmat sm, Scrambler s){
	
		keyPresses = kp;
		fields = f;
		paint = p;
		stackmat = sm;
		scrambler = s;
	}
	
	public void actionPerformed(ActionEvent e){
	
		if(fields.timerStatus.running){
			
			fields.ignoreNextRelese = true;
			stackmat.stopTimer();

		}
		else{
			
			if(! fields.ignoreNextRelese){
				
				fields.greenText = true;
			}
		}
		
		paint.repaint();
	}
	
}
