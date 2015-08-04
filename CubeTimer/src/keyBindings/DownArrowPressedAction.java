package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.KeyPresses;
import cubetimer.Paint;
import cubetimer.Scrambler;
import fields.DisplayState;
import fields.Fields;

public class DownArrowPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	private Fields fields;
	private Paint paint;
	private Scrambler scrambler;
	
	public DownArrowPressedAction(KeyPresses kp, Fields f, Paint p, Scrambler s){
	
		keyPresses = kp;
		fields = f;
		paint = p;
		scrambler = s;
		
	}
	
	public void actionPerformed(ActionEvent e){
	
		if(fields.displayState == DisplayState.menu){
			fields.menu.downOne();
		}
		
		else if(fields.displayState == DisplayState.changeTwistyPuzzle){
			fields.menu.twistyPuzzleMenu.downOne();
		}
		
		else if(fields.displayState == DisplayState.userMenu){
			fields.menu.userActionsMenu.downOne();
		}
		
		else if(fields.displayState == DisplayState.changeScrambleLenght){
			
			if(fields.displayedDada.scrambleDada.scrambleLenght > 1){
				fields.displayedDada.scrambleDada.scrambleLenght --;
			}
			
			scrambler.randomCorrectScrambleInFieldsUsingFields();
		}
		
		else if(fields.displayState == DisplayState.changeUser){
			
			fields.menu.userActionsMenu.userMenuDownOne(fields.allUsers.getSize());
		}
		paint.repaint();
	}
}
