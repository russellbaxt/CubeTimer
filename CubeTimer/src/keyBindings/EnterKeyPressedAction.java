package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Actions;
import cubetimer.KeyPressActions;
import cubetimer.KeyPresses;
import cubetimer.Paint;
import cubetimer.Scrambler;
import fields.DisplayState;
import fields.Fields;
import fields.TwistyPuzzleType;


public class EnterKeyPressedAction extends AbstractAction{
	
	private KeyPresses keyPresses;
	private Fields fields;
	private Paint paint;
	private Scrambler scrambler;
	private Actions actions;
	
	public EnterKeyPressedAction(KeyPresses kp, Fields f, Paint p, Scrambler s, Actions a){
		keyPresses = kp;
		fields = f;
		paint = p;
		scrambler = s;
		actions = a;
	}
	
	public void actionPerformed(ActionEvent e){
	
		if(fields.displayState == DisplayState.menu){
			
			if(fields.menu.getChangeTwistyPuzzle()){
				fields.displayState = DisplayState.changeTwistyPuzzle;
			}
			
			else if(fields.menu.getUserMenu()){
				fields.displayState = DisplayState.userMenu;
			}
			
			else if(fields.menu.getChangeScrambleLenght()){
				fields.displayState = DisplayState.changeScrambleLenght;
			}
			
			else if(fields.menu.getDeleteLastSolve()){
				fields.displayState = DisplayState.timer;
				Actions.deleteLastSolve(fields, paint);
			}
			
			else if(fields.menu.getNewScramble()){
				scrambler.randomCorrectScrambleInFieldsUsingFields();
				fields.displayState = DisplayState.timer;
			}
			
			else if(fields.menu.getQuit()){
				System.exit(0);
			}
			
			else{
				fields.displayState = DisplayState.timer;
			}
		}
		
		else if(fields.displayState == DisplayState.changeTwistyPuzzle){
			
			if(fields.menu.twistyPuzzleMenu.get2x2x2()){
				
				KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube2x2x2, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.get3x3x3()){
				
				KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube3x3x3, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.get4x4x4()){
				
				KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube4x4x4, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.get5x5x5()){
				
				KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube5x5x5, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getMegaMinx()){
				
				KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.megaMinx, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getGearCube()){
				
				KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.gearCube, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getAnisatropicGearCube()){
				
				KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.anisatropicGearCube, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getOneHanded3x3x3()){
				
				KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.oneHanded3x3x3, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getRandomTwistyPuzzle()){
				
				KeyPressActions.changeToRandomTwistyPuzzleType(fields, scrambler, actions, paint);
			}
			
			fields.displayState = DisplayState.timer;
			
			if(fields.menu.twistyPuzzleMenu.getExit()){
				fields.displayState = DisplayState.menu;
			}
		}
		
		else if(fields.displayState == DisplayState.userMenu){
			
			if(fields.menu.userActionsMenu.getAddUser()){
				
				KeyPressActions.addAUser(fields, paint);
			}
			
			else if(fields.menu.userActionsMenu.getChangeUser()){
				
				fields.displayState = DisplayState.changeUser;
			}
			
			else if(fields.menu.userActionsMenu.getDeleteCurrentUser()){
				
				Actions.deleteCurrentUser(fields, paint);
			}
			
			else if(fields.menu.userActionsMenu.getRenameCurrentUser()){
				
				KeyPressActions.changeUserName(fields, paint);
			}
			
			else{
				fields.displayState = DisplayState.menu;
			}
		}
		
		else if(fields.displayState == DisplayState.changeScrambleLenght){
			
			scrambler.randomCorrectScrambleInFieldsUsingFields();
			
			fields.displayState = DisplayState.timer;
		}
		
		else if(fields.displayState == DisplayState.changeUser){
			
			fields.allUsers.setCurrentUserIndex(fields.menu.userActionsMenu.getSelectedUserIndex());
			fields.displayState = DisplayState.timer;
		}
		
		paint.repaint();
		
	}
	
	
	
}
