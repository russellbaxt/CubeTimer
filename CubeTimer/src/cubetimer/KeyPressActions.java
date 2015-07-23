package cubetimer;

public class KeyPressActions{
	
	public static void spacePressed(Fields fields, Timer timer, TimesTracker timesTracker, Scrambler scrambler,
			Paint paint){
	
		if(fields.timerStatus.running){
			
			scrambler.randomCorrectScrambleInFieldsUsingFields();
			timer.startStopTimer();
			fields.ignoreNextRelese = true;
			timesTracker.addTime(timer.getTimeAsDouble());
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
	
		TwistyPuzzleTypeAndInt twistyPuzzleTypeAndScrambleLenght = actions.randomTwistyPuzzle();
		fields.allUsers.getUser().setTwistyPuzzleType(twistyPuzzleTypeAndScrambleLenght.twistyPuzzleType);
		fields.displayedDada.scrambleDada.scrambleLenght = twistyPuzzleTypeAndScrambleLenght.integer;
		scrambler.randomCorrectScrambleInFieldsUsingFields();
		
		paint.repaint();
	}
	
	public static void changeToTwistyPuzzle(Fields fields, TwistyPuzzleType twistyPuzzleType, Scrambler scrambler,
			TimesTracker timesTracker, Paint paint){
	
		fields.allUsers.getUser().setTwistyPuzzleType(twistyPuzzleType);
		timesTracker.setLast20SolvesInFieldsUsingFields();
		timesTracker.setAvarageOf5InFieldsUsingFields();
		
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
	
		fields.displayState = DisplayState.consoleRequiresAttention;
		fields.userAction = UserAction.change;
		fields.paintComponentDone = false;
		
		paint.repaint();
	}
	
	public static void changeUserName(Fields fields, Paint paint){
	
		fields.displayState = DisplayState.consoleRequiresAttention;
		fields.userAction = UserAction.rename;
		fields.paintComponentDone = false;
		
		paint.repaint();
	}
	
	public static void deleteCurrentUser(TimesTracker timesTracker){
	
		timesTracker.deleteCurrentUser();
	}
	
	public static void openMenu(Fields fields, Paint paint){
	
		if(fields.displayState == DisplayState.timer){
			fields.displayState = DisplayState.menu;
		}
		
		paint.repaint();
	}
	
	public static void select(Fields fields, Paint paint, Scrambler scrambler, TimesTracker timesTracker,
			Actions actions){
	
		if(fields.displayState == DisplayState.menu){
			
			if(fields.menuItems.getChangeTwistyPuzzle()){
				fields.displayState = DisplayState.changeTwistyPuzzle;
			}
			
			else if(fields.menuItems.getUserMenu()){
				fields.displayState = DisplayState.userMenu;
			}
			
			else if(fields.menuItems.getChangeScrambleLenght()){
				fields.displayState = DisplayState.changeScrambleLenght;
			}
			
			else if(fields.menuItems.getDeleteLastSolve()){
				fields.displayState = DisplayState.timer;
				timesTracker.deleteLastSolve();
			}
			
			else if(fields.menuItems.getNewScramble()){
				scrambler.randomCorrectScrambleInFieldsUsingFields();
				fields.displayState = DisplayState.timer;
			}
			
			else if(fields.menuItems.getQuit()){
				fields.close = true;
			}
			
			else{
				fields.displayState = DisplayState.timer;
			}
		}
		
		else if(fields.displayState == DisplayState.changeTwistyPuzzle){
			
			if(fields.menuItems.twistyPuzzleMenu.get2x2x2()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.cube2x2x2, scrambler, timesTracker, paint);
			}
			
			else if(fields.menuItems.twistyPuzzleMenu.get3x3x3()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.cube3x3x3, scrambler, timesTracker, paint);
			}
			
			else if(fields.menuItems.twistyPuzzleMenu.get4x4x4()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.cube4x4x4, scrambler, timesTracker, paint);
			}
			
			else if(fields.menuItems.twistyPuzzleMenu.get5x5x5()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.cube5x5x5, scrambler, timesTracker, paint);
			}
			
			else if(fields.menuItems.twistyPuzzleMenu.getMegaMinx()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.megaMinx, scrambler, timesTracker, paint);
			}
			
			else if(fields.menuItems.twistyPuzzleMenu.getGearCube()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.gearCube, scrambler, timesTracker, paint);
			}
			
			else if(fields.menuItems.twistyPuzzleMenu.getAnisatropicGearCube()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.anisatropicGearCube, scrambler, timesTracker, paint);
			}
			
			else if(fields.menuItems.twistyPuzzleMenu.getOneHanded3x3x3()){
				
				changeToTwistyPuzzle(fields, TwistyPuzzleType.oneHanded3x3x3, scrambler, timesTracker, paint);
			}
			
			else if(fields.menuItems.twistyPuzzleMenu.getRandomTwistyPuzzle()){
				
				changeToRandomTwistyPuzzleType(fields, scrambler, actions, paint);
			}
			
			fields.displayState = DisplayState.timer;
			
			if(fields.menuItems.twistyPuzzleMenu.getExit()){
				fields.displayState = DisplayState.menu;
			}
		}
		
		else if(fields.displayState == DisplayState.userMenu){
			
			if(fields.menuItems.userActionsMenu.getAddUser()){
				
				addAUser(fields, paint);
			}
			
			else if(fields.menuItems.userActionsMenu.getChangeUser()){
				
				changeUser(fields, paint);
			}
			
			else if(fields.menuItems.userActionsMenu.getDeleteCurrentUser()){
				
				deleteCurrentUser(timesTracker);
			}
			
			else if(fields.menuItems.userActionsMenu.getChangeCurrentUserName()){
				
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
		
		paint.repaint();
	}
	
	public static void upOne(Fields fields, Paint paint){
	
		if(fields.displayState == DisplayState.menu){
			fields.menuItems.upOne();
		}
		
		else if(fields.displayState == DisplayState.changeTwistyPuzzle){
			fields.menuItems.twistyPuzzleMenu.upOne();
		}
		
		else if(fields.displayState == DisplayState.userMenu){
			fields.menuItems.userActionsMenu.upOne();
		}
		
		else if(fields.displayState == DisplayState.changeScrambleLenght){
			
			fields.displayedDada.scrambleDada.scrambleLenght ++;
		}
		
		paint.repaint();
	}
	
	public static void downOne(Fields fields, Paint paint){
	
		if(fields.displayState == DisplayState.menu){
			fields.menuItems.downOne();
		}
		
		else if(fields.displayState == DisplayState.changeTwistyPuzzle){
			fields.menuItems.twistyPuzzleMenu.downOne();
		}
		
		else if(fields.displayState == DisplayState.userMenu){
			fields.menuItems.userActionsMenu.downOne();
		}
		
		else if(fields.displayState == DisplayState.changeScrambleLenght){
			
			fields.displayedDada.scrambleDada.scrambleLenght --;
		}
		paint.repaint();
	}
	
}
