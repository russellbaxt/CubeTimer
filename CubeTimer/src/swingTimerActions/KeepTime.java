package swingTimerActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import cubetimer.Paint;
import fields.Fields;

public class KeepTime implements ActionListener{
	
	public Fields fields;
	public Paint paint;
	
	public double startTime;
	public double currentTime;
	
	public double timeSeconds;
	public int timeMinutes;
	
	public KeepTime(Fields fieldsIn, Paint paintIn){
	
		fields = fieldsIn;
		paint = paintIn;
		
		startTime = (double) System.currentTimeMillis() / 1000.0;
		
		fields.displayedDada.time = "0.00";
		
		paint.repaint();
	}
	
	public double getEndResultForSaving(){
		
		currentTime = (double) System.currentTimeMillis() / 1000.0;
		
		timeSeconds = currentTime - startTime;
		timeMinutes = 0;
		
		double timeInSecondsToBeReturned = timeSeconds;
		
		timeSeconds = timeSeconds + fields.penalty.timePenalty;
		
		if(timeSeconds >= 60){
			
			timeSeconds -= 60;
			timeMinutes ++;
		}
		
		if(timeMinutes > 0){
			
			fields.displayedDada.time = String.format("%.2f", timeSeconds + ":" + Integer.toString(timeMinutes));
		}
		
		else{
			
			fields.displayedDada.time = String.format("%.2f", timeSeconds);
		}
		
		paint.repaint();
		
		return timeInSecondsToBeReturned;
	}
	
	public void actionPerformed(ActionEvent e){
	
		currentTime = (double) System.currentTimeMillis() / 1000.0;
		
		timeSeconds = currentTime - startTime;
		timeMinutes = 0;
		
		if(timeSeconds >= 60){
			
			timeSeconds -= 60;
			timeMinutes ++;
		}
		
		if(timeMinutes > 0){
			
			fields.displayedDada.time = String.format("%.2f", timeSeconds) + ":" + Integer.toString(timeMinutes);
		}
		
		else{
			fields.displayedDada.time = String.format("%.2f", timeSeconds);
		}
		
		paint.repaint();
	}
	
}
