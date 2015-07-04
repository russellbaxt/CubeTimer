package cubetimer;

public class AnotherClass{
	
	public static void callMeMany(Fields fields, KeyPresses keyPresses, TimesTracker timesTracker, Timer timer){
	
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
		
		if(fields.getCountDownRunning()){
			
			timer.updateCountdownTime();
			
			fields.repaint();
		}
		
	}
}
