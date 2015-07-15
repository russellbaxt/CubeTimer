package cubetimer;

public class KeyPressActions{
	
	public static void spacePressed(Fields fields, Timer timer, TimesTracker timesTracker, Scrambler scrambler, Paint paint){
	
		if(fields.running){
			
			scrambler.randomCorrectScrambleInFieldsUsingFields();
			timer.startStopTimer();
			fields.ignoreNextRelese = true;
			timesTracker.addTime(fields.twistyPuzzleType, timer.getTimeAsDouble());
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
			if(! fields.running){
				
				fields.scrambleDada.randomScramble = "";
				
				if(fields.countDownRunning){
					
					fields.countDownRunning = false;
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
	
		if(fields.scrambleDada.scrambleLenght > 1){
			fields.scrambleDada.scrambleLenght --;
			
			paint.repaint();
		}
		
		scrambler.randomCorrectScrambleInFieldsUsingFields();
	 }
	 
	
	 public static void increseScrambleLenghtByOne(Fields fields, Scrambler scrambler, Paint paint){
	
		 fields.scrambleDada.scrambleLenght ++;
		 scrambler.randomCorrectScrambleInFieldsUsingFields();
		 
		 paint.repaint();
	 }
	
	 public static void changeToRandomTwistyPuzzleType(Fields fields, Scrambler scrambler, Actions actions, Paint paint){
	
		 TwistyPuzzleTypeAndInt twistyPuzzleTypeAndScrambleLenght = actions.randomTwistyPuzzle();
		 fields.twistyPuzzleType = twistyPuzzleTypeAndScrambleLenght.twistyPuzzleType;
		 fields.scrambleDada.scrambleLenght = twistyPuzzleTypeAndScrambleLenght.integer;
		 scrambler.randomCorrectScrambleInFieldsUsingFields();
		 
		 paint.repaint();
	 }

	 public static void changeToTwistyPuzzle(Fields fields, TwistyPuzzleType twistyPuzzleType, Scrambler scrambler, TimesTracker timesTracker, Paint paint){

		fields.twistyPuzzleType = twistyPuzzleType;
		timesTracker.setLast20SolvesInFieldsUsingFields();
		timesTracker.setAvarageOf5InFieldsUsingFields();
		
		if(twistyPuzzleType == TwistyPuzzleType.magaMinx){
			fields.scrambleDada.scrambleLenght = 40;
		}
		
		else if(twistyPuzzleType == TwistyPuzzleType.cube2x2x2){
			fields.scrambleDada.scrambleLenght = 10;
		}
		else{
			fields.scrambleDada.scrambleLenght = 20;
		}
		
		scrambler.randomCorrectScrambleInFieldsUsingFields();
		
		paint.repaint();
		
	}
	
	public static void addAUser(Fields fields, Paint paint){
	
		fields.consoleRequiresAtention = true;
		fields.addNotChangeUser = true;
		fields.paintComponentDone = false;
		paint.repaint();
	}
	
	public static void changeUser(Fields fields, Paint paint){
	
		fields.consoleRequiresAtention = true;
		fields.addNotChangeUser = false;
		fields.paintComponentDone = false;
		paint.repaint();
	}
	
}
