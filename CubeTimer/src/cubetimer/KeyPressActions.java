package cubetimer;

public class KeyPressActions{
	
	public static void spacePressed(Fields fields, Timer timer, TimesTracker timesTracker, Scrambler scrambler){
	
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
	}
	
	public static void spaceReleased(Fields fields, Timer timer){
	
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
	}
	
	public static void reduceScrambleLenghtByOne(Fields fields, Scrambler scrambler){
	
	 if(fields.getScrambleLength() > 1){
	 fields.setScrambleLenght(fields.getScrambleLength() - 1);
	 }
	 scrambler.randomCorrectScrambleInFieldsUsingFields();
	 }
	 
	
	 public static void increseScrambleLenghtByOne(Fields fields, Scrambler scrambler){
	
	 fields.setScrambleLenght(fields.getScrambleLength() + 1);
	 scrambler.randomCorrectScrambleInFieldsUsingFields();
	 }
	
	 public static void changeToRandomTwistyPuzzleType(Fields fields,
	 Scrambler scrambler, Actions actions){
	
	 TwistyPuzzleTypeAndInt twistyPuzzleTypeAndScrambleLenght =
	 actions.randomTwistyPuzzle();
	 fields.setTwistyPuzzleType(twistyPuzzleTypeAndScrambleLenght.twistyPuzzleType);
	 fields.setScrambleLenght(twistyPuzzleTypeAndScrambleLenght.integer);
	 scrambler.randomCorrectScrambleInFieldsUsingFields();
	 }

	 public static void changeToTwistyPuzzle(Fields fields, TwistyPuzzleType twistyPuzzleType, Scrambler scrambler, TimesTracker timesTracker){

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
		
	}
	
	public static void addAUser(Fields fields){
	
		fields.setConsoleRequiresAttention(true);
		fields.setAddNotChangeUser(true);
		fields.repaint();
	}
	
	public static void changeUser(Fields fields){
	
		fields.setConsoleRequiresAttention(true);
		fields.setAddNotChangeUser(false);
		fields.repaint();
	}
	
}
