package cubetimer;


public class AnotherMethod{
	
	public static void callMe(Fields fields, KeyPresses keyPresses, TimesTracker timesTracker, Timer timer){
		if(fields.getConsoleRequiresAttention()){
			keyPresses.setAllKeyPressesToFalse();
			
			if(fields.getPaintComponentDone()){
				
				if(fields.getAddNotChangeUser()){
					timesTracker.addUser();
				}
				else{
					timesTracker.changeToUser();
				}
				fields.setConsoleRequiresAttention(false);
			}
		}
		else{
			timer.updateTime();
		}
		
		if(fields.getRandomScramble().contains("/n")){
			
			fields.setRandomScrambleAfterSplit(fields.getRandomScramble().split("/n"));
			fields.setScrambleSize(fields.getRandomScrambleAfterSplit()[0].length() / 2 + 4);
			fields.setUseStringListForRandomScramble(true);
			
		}
		else{
			
			fields.setScrambleSize(fields.getRandomScramble().length() / 2);
			fields.setUseStringListForRandomScramble(false);
		}
		
		if(fields.getScrambleSize() < 4.0){
			fields.setScrambleSize(4.0);
		}
		fields.repaint();
			
	}
}
