package swingTimerActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import cubetimer.Actions;
import cubetimer.Paint;
import fields.Fields;

public class KeepCountDown implements ActionListener{
	
	public boolean plusTwo;
	public int timeLeft;
	public Fields fields;
	public Paint paint;
	public double countDownStart;
	public Timer myTimer;
	
	public KeepCountDown(Fields fieldsIn, Paint paintIn, Timer myTimerIn){
	
		countDownStart = (double) System.currentTimeMillis() / 1000.0;
		timeLeft = 15;
		plusTwo = false;
		fields = fieldsIn;
		paint = paintIn;
		fields.displayedDada.time = Integer.toString(timeLeft);
		myTimer = myTimerIn;
		
		paint.repaint();
	}
	
	public void actionPerformed(ActionEvent e){
	
		System.out.println("Hi");
		
		timeLeft --;
		
		if(timeLeft > 0){
			
			fields.displayedDada.time = Integer.toString(timeLeft);
		}
		
		else{
			
			if(plusTwo){
				
				fields.displayedDada.time = "DNF";
				fields.penalty.DNF = true;
				fields.penalty.timePenalty = 0;
				Actions.addTime(fields, paint, 0.0);
				fields.timerStatus.countDownRunning = false;
				myTimer.stop();
			}
			
			else{
				
				fields.displayedDada.time = "+2";
				timeLeft = 2;
				fields.penalty.timePenalty = 2;
				plusTwo = true;
			}
		}
		
		paint.repaint();
	}
}
