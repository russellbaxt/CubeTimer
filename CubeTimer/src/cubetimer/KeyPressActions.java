package cubetimer;

import fields.DisplayState;
import fields.Fields;
import fields.TwistyPuzzleType;
import fields.UserAction;

public class KeyPressActions{
	
	public static void spacePressed(Fields fields, Timer timer, Scrambler scrambler, Paint paint){
	
		if(fields.timerStatus.running){
			
			scrambler.randomCorrectScrambleInFieldsUsingFields();
			timer.startStopTimer();
			fields.ignoreNextRelese = true;
			Actions.addTime(fields, paint, timer.getTimeAsDouble());
		}
		else{
			
			if(! fields.ignoreNextRelese){
				
				fields.greenText = true;
			}
		}
		
		paint.repaint();
	}
	
	public static void spaceReleased(Fields fields, Timer timer, Paint paint){
	
		fields.greenText = false;
		
		if(fields.ignoreNextRelese){
			fields.ignoreNextRelese = false;
		}
		
		else{
			if(! fields.timerStatus.running){
				
				fields.displayedDada.scrambleDada.randomScramble = "";
				
				if(fields.timerStatus.countDownRunning){
					
					fields.timerStatus.countDownRunning = false;
					timer.startStopTimer();
				}
				else{
					timer.StartCountDown();
				}
			}
		}
		
		paint.repaint();
	}
	
	public static void reduceScrambleLenghtByOne(Fields fields, Scrambler scrambler, Paint paint){
	
		if(fields.displayedDada.scrambleDada.scrambleLenght > 1){
			fields.displayedDada.scrambleDada.scrambleLenght --;
			
			paint.repaint();
		}
		
		scrambler.randomCorrectScrambleInFieldsUsingFields();
	}
	
	public static void increseScrambleLenghtByOne(Fields fields, Scrambler scrambler, Paint paint){
	
		fields.displayedDada.scrambleDada.scrambleLenght ++;
		scrambler.randomCorrectScrambleInFieldsUsingFields();
		
		paint.repaint();
	}
	
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
	}
	
	public static void changeUser(Fields fields, Paint paint){
	
		fields.displayState = DisplayState.changeUser;
		
		paint.repaint();
	}
	
	public static void changeUserName(Fields fields, Paint paint){
	
		fields.displayState = DisplayState.consoleRequiresAttention;
		fields.userAction = UserAction.rename;
		fields.paintComponentDone = false;
		
		paint.repaint();
	}
	
	public static void deleteCurrentUser(Fields fields, Paint paint){
	
		Actions.deleteCurrentUser(fields, paint);
	}
	
	public static void openMenu(Fields fields, Paint paint){
	
		if(fields.displayState == DisplayState.timer){
			fields.displayState = DisplayState.menu;
		}
		
		paint.repaint();
	}
	
	public static void select(Fields fields, Paint paint, Scrambler scrambler, Actions actions){
	
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
				fields.close = true;
			}
			
			else{
				fields.displayState = DisplayState.timer;
			}
		}
		
		else if(fields.displayState == DisplayState.changeTwistyPuzzle){
			
			if(fields.menu.twistyPuzzleMenu.get2x2x2()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.cube2x2x2, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.get3x3x3()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.cube3x3x3, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.get4x4x4()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.cube4x4x4, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.get5x5x5()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.cube5x5x5, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getMegaMinx()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.megaMinx, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getGearCube()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.gearCube, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getAnisatropicGearCube()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.anisatropicGearCube, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getOneHanded3x3x3()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.oneHanded3x3x3, scrambler, paint);
			}
			
			else if(fields.menu.twistyPuzzleMenu.getRandomTwistyPuzzle()){
				
				changeToRandomTwistyPuzzleType(fields, scrambler, actions, paint);
			}
			
			fields.displayState = DisplayState.timer;
			
			if(fields.menu.twistyPuzzleMenu.getExit()){
				fields.displayState = DisplayState.menu;
			}
		}
		
		else if(fields.displayState == DisplayState.userMenu){
			
			if(fields.menu.userActionsMenu.getAddUser()){
				
				addAUser(fields, paint);
			}
			
			else if(fields.menu.userActionsMenu.getChangeUser()){
				
				changeUser(fields, paint);
			}
			
			else if(fields.menu.userActionsMenu.getDeleteCurrentUser()){
				
				deleteCurrentUser(fields, paint);
			}
			
			else if(fields.menu.userActionsMenu.getRenameCurrentUser()){
				
				changeUserName(fields, paint);
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
	
	public static void upOne(Fields fields, Paint paint){
	
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
		}
		
		else if(fields.displayState == DisplayState.changeUser){
			
			fields.menu.userActionsMenu.userMenuUpOne(fields.allUsers.getSize());
		}
		
		paint.repaint();
	}
	
	public static void downOne(Fields fields, Paint paint){
	
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
			
			fields.displayedDada.scrambleDada.scrambleLenght --;
		}
		
		else if(fields.displayState == DisplayState.changeUser){
			
			fields.menu.userActionsMenu.userMenuDownOne(fields.allUsers.getSize());
		}
		paint.repaint();
	}
	
}
