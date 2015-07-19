package cubetimer;

public class AnotherClass{
	
	public static void callMeMany(Fields fields, KeyPresses keyPresses, TimesTracker timesTracker, Timer timer, Paint paint){
	
		if(fields.displayState == DisplayState.consoleRequiresAttention){
			
			keyPresses.setAllKeyPressesToFalse();
			
			if(fields.paintComponentDone){
				
				if(fields.userAction == UserAction.add){
					timesTracker.addUser();
				}
				
				else if(fields.userAction == UserAction.change){
					timesTracker.changeToUser();
				}
				
				else{
					timesTracker.changeCurrentUserName();
				}
				
				fields.displayState = DisplayState.timer;
				
				paint.repaint();
			}
		}
		
		else{
			
			timer.updateTime();
		}
		
		if(fields.timerStatus.countDownRunning){
			
			timer.updateCountdownTime();
			
			paint.repaint();
		}
		
	}
	
	public static void setScrambleInFields(Fields fields, String randomScramble){
		
		if(randomScramble.contains("/n")){
			
			fields.displayedDada.scrambleDada.randomScrambleAfterSplit = randomScramble.split("/n");
			fields.displayedDada.scrambleDada.scrambleSize = fields.displayedDada.scrambleDada.randomScrambleAfterSplit[0].length() / 2.0 + 4.0;
			fields.displayedDada.scrambleDada.useStringListForRandomScramble = true;
		}
		
		else{
			
			fields.displayedDada.scrambleDada.randomScramble = randomScramble;
			fields.displayedDada.scrambleDada.scrambleSize = randomScramble.length() / 2.0 + 4.0;
			fields.displayedDada.scrambleDada.useStringListForRandomScramble = false;
		}
		
		if(fields.displayedDada.scrambleDada.scrambleSize < 4.0){
			fields.displayedDada.scrambleDada.scrambleSize = 4.0;
		}
	}
}
