package cubetimer;

public class KeyPressActions{
	
	public static void spacePressed(Fields fields, Timer timer, TimesTracker timesTracker, Scrambler scrambler, Paint paint){
	
		if(fields.getRunning()){
			
			fields.setRandomScramble(scrambler.randomCorrectScramble(fields.getTwistyPuzzleType(), fields.getScrambleLength()));
			timer.startStopTimer();
			fields.setIgnoreNextRelese(true);
			timesTracker.addTime(fields.getTwistyPuzzleType(), timer.getTimeAsDouble());
		}
		else{
			
			if(! fields.getIgnoreNextRelese()){
				
				fields.setGreenText(true);
			}
		}
		
		paint.repaint();
	}
	
	public static void spaceReleased(Fields fields, Timer timer, Paint paint){
	
		fields.setGreenText(false);
		
		if(fields.getIgnoreNextRelese()){
			fields.setIgnoreNextRelese(false);
		}
		
		else{
			if(! fields.getRunning()){
				
				fields.setRandomScramble("");
				
				if(fields.getCountDownRunning()){
					
					fields.setCountDownRunning(false);
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
	
		if(fields.getScrambleLength() > 1){
			fields.setScrambleLenght(fields.getScrambleLength() - 1);
			
			paint.repaint();
		}
		
		scrambler.randomCorrectScrambleInFieldsUsingFields();
	 }
	 
	
	 public static void increseScrambleLenghtByOne(Fields fields, Scrambler scrambler, Paint paint){
	
		 fields.setScrambleLenght(fields.getScrambleLength() + 1);
		 scrambler.randomCorrectScrambleInFieldsUsingFields();
		 
		 paint.repaint();
	 }
	
	 public static void changeToRandomTwistyPuzzleType(Fields fields, Scrambler scrambler, Actions actions, Paint paint){
	
		 TwistyPuzzleTypeAndInt twistyPuzzleTypeAndScrambleLenght = actions.randomTwistyPuzzle();
		 fields.setTwistyPuzzleType(twistyPuzzleTypeAndScrambleLenght.twistyPuzzleType);
		 fields.setScrambleLenght(twistyPuzzleTypeAndScrambleLenght.integer);
		 scrambler.randomCorrectScrambleInFieldsUsingFields();
		 
		 paint.repaint();
	 }

	 public static void changeToTwistyPuzzle(Fields fields, TwistyPuzzleType twistyPuzzleType, Scrambler scrambler, TimesTracker timesTracker, Paint paint){

		fields.setTwistyPuzzleType(twistyPuzzleType);
		timesTracker.setLast20SolvesInFieldsUsingFields();
		
		if(twistyPuzzleType == TwistyPuzzleType.magaMinx){
			fields.setScrambleLenght(40);
		}
		
		else if(twistyPuzzleType == TwistyPuzzleType.cube2x2x2){
			fields.setScrambleLenght(10);
		}
		else{
			fields.setScrambleLenght(20);
		}
		
		scrambler.randomCorrectScrambleInFieldsUsingFields();
		
		paint.repaint();
		
	}
	
	public static void addAUser(Fields fields, Paint paint){
	
		fields.setConsoleRequiresAttention(true);
		fields.setAddNotChangeUser(true);
		fields.setPaintComponentDone(false);
		paint.repaint();
	}
	
	public static void changeUser(Fields fields, Paint paint){
	
		fields.setConsoleRequiresAttention(true);
		fields.setAddNotChangeUser(false);
		fields.setPaintComponentDone(false);
		paint.repaint();
	}
	
}
