package cubetimer;

public class AnotherClass{
	
	public static void callMeMany(Fields fields, KeyPresses keyPresses, TimesTracker timesTracker, Timer timer, Paint paint){
	
		if(fields.consoleRequiresAtention){
			
			keyPresses.setAllKeyPressesToFalse();
			
			if(fields.paintComponentDone){
				
				if(fields.addNotChangeUser){
					timesTracker.addUser();
				}
				else{
					timesTracker.changeToUser();
				}
				fields.consoleRequiresAtention = false;
			}
		}
		
		else{
			
			timer.updateTime();
		}
		
		if(fields.countDownRunning){
			
			timer.updateCountdownTime();
			
			paint.repaint();
		}
		
	}
	
	public static void setScrambleInFields(Fields fields, String randomScramble){
		
		if(randomScramble.contains("/n")){
			
			fields.randomScrambleAfterSplit = randomScramble.split("/n");
			fields.scrambleSize = fields.randomScrambleAfterSplit[0].length() / 2.0 + 4.0;
			fields.useStringListForRandomScramble = true;
		}
		
		else{
			
			fields.randomScramble = randomScramble;
			fields.scrambleSize = randomScramble.length() / 2.0 + 4.0;
			fields.useStringListForRandomScramble = false;
		}
		
		if(fields.scrambleSize < 4.0){
			fields.scrambleSize = 4.0;
		}
	}
}
