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
			
			fields.scrambleDada.randomScrambleAfterSplit = randomScramble.split("/n");
			fields.scrambleDada.scrambleSize = fields.scrambleDada.randomScrambleAfterSplit[0].length() / 2.0 + 4.0;
			fields.scrambleDada.useStringListForRandomScramble = true;
		}
		
		else{
			
			fields.scrambleDada.randomScramble = randomScramble;
			fields.scrambleDada.scrambleSize = randomScramble.length() / 2.0 + 4.0;
			fields.scrambleDada.useStringListForRandomScramble = false;
		}
		
		if(fields.scrambleDada.scrambleSize < 4.0){
			fields.scrambleDada.scrambleSize = 4.0;
		}
	}
}
