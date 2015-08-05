package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.KeyPresses;
import cubetimer.Paint;
import cubetimer.Scrambler;
import fields.DisplayState;
import fields.Fields;


@SuppressWarnings("serial")
public class UpArrowPressedAction extends AbstractAction{
	
	private Fields fields;
	private Paint paint;
	private Scrambler scrambler;
	
	public UpArrowPressedAction(KeyPresses kp, Fields f, Paint p, Scrambler s){
		fields = f;
		paint = p;
		scrambler = s;
	}

	public void actionPerformed(ActionEvent e){
	
		if(fields.displayState == DisplayState.menu){
			fields.menu.upOne();
		}
		
		else if(fields.displayState == DisplayState.changeTwistyPuzzle){
			fields.menu.twistyPuzzleMenu.upOne();
		}
		
		else if(fields.displayState == DisplayState.userMenu){
			fields.menu.userActionsMenu.upOne();
		}
		
		else if(fields.displayState == DisplayState.changeScrambleLenght){
			
			fields.displayedDada.scrambleDada.scrambleLenght ++;
			
			scrambler.randomCorrectScrambleInFieldsUsingFields();
		}
		
		else if(fields.displayState == DisplayState.changeUser){
			
			fields.menu.userActionsMenu.userMenuUpOne(fields.allUsers.getSize());
		}
		
		paint.repaint();
	}
}
