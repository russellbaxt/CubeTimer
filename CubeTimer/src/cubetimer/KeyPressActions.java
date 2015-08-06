package cubetimer;

import javax.swing.Timer;

import swingTimerActions.AddUser;
import swingTimerActions.RenameUser;
import fields.DisplayState;
import fields.Fields;
import fields.TwistyPuzzleType;
import fields.UserAction;

public class KeyPressActions{
	
	public static void changeToRandomTwistyPuzzleType(Fields fields, Scrambler scrambler, Actions actions, Paint paint){
	
		Actions.randomTwistyPuzzle(fields);
		scrambler.randomCorrectScrambleInFieldsUsingFields();
		
		paint.repaint();
	}
	
	public static void changeToTwistyPuzzle(Fields fields, TwistyPuzzleType twistyPuzzleType, Scrambler scrambler,
			Paint paint){
	
		fields.allUsers.getUser().setTwistyPuzzleType(twistyPuzzleType);
		
		if(twistyPuzzleType == TwistyPuzzleType.megaMinx){
			fields.displayedDada.scrambleDada.scrambleLenght = 40;
		}
		
		else if(twistyPuzzleType == TwistyPuzzleType.cube2x2x2){
			fields.displayedDada.scrambleDada.scrambleLenght = 10;
		}
		else{
			fields.displayedDada.scrambleDada.scrambleLenght = 20;
		}
		
		scrambler.randomCorrectScrambleInFieldsUsingFields();
		
		paint.repaint();
		
	}
	
	public static void addAUser(Fields fields, Paint paint){
	
		fields.displayState = DisplayState.consoleRequiresAttention;
		fields.userAction = UserAction.add;
		fields.paintComponentDone = false;
		
		paint.repaint();
		
		Timer timer = new Timer(0, new AddUser(fields, paint));
		timer.setRepeats(false);
		timer.start();
	}
	
	public static void changeUserName(Fields fields, Paint paint){
	
		fields.displayState = DisplayState.consoleRequiresAttention;
		fields.userAction = UserAction.rename;
		fields.paintComponentDone = false;
		
		paint.repaint();
		
		Timer timer = new Timer(0, new RenameUser(fields, paint));
		timer.setRepeats(false);
		timer.start();
	}
}
