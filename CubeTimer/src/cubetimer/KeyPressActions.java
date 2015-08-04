package cubetimer;

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
		Actions.setAvarageOf5(fields, paint);
		
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
		
		//TODO I think you will have to do more here since we are getting rid of that another class that get called while true
	}
	
	public static void changeUserName(Fields fields, Paint paint){
	
		fields.displayState = DisplayState.consoleRequiresAttention;
		fields.userAction = UserAction.rename;
		fields.paintComponentDone = false;
		
		paint.repaint();
		
		//TODO I think you will have to do more here since we are getting rid of that another class that gets called while true
	}
}
