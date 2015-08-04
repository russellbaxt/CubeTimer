package cubetimer;

import fields.DisplayState;
import fields.Fields;
import fields.UserAction;

public class AnotherClass{
	
	public static void callMeMany(Fields fields, KeyPresses keyPresses, Stackmat stackmat, Paint paint){
	
		if(fields.displayState == DisplayState.consoleRequiresAttention){
			
//			keyPresses.setAllKeyPressesToFalse();
			
			if(fields.paintComponentDone){
				
				if(fields.userAction == UserAction.add){
					Actions.addUser(fields, paint);
				}
				else{
					Actions.renameCurrentUser(fields);
				}
				
				fields.displayState = DisplayState.timer;
				
				paint.repaint();
			}
		}
		
		else{
			
		//	stackmat.updateTime();
		}
		
		if(fields.timerStatus.countDownRunning){
			
		//	stackmat.updateCountdownTime();
			
		//	paint.repaint();
		}
		
	}
	

}
