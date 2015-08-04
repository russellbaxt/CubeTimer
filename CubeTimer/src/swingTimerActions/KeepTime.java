package swingTimerActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import cubetimer.IntAndDouble;
import cubetimer.Paint;
import fields.Fields;


public class KeepTime implements ActionListener{
	
	public Fields fields;
	public Paint paint;
	
	public int minutes;
	public double seconds;

	public KeepTime(Fields fieldsIn, Paint paintIn){
		
		fields = fieldsIn;
		paint = paintIn;
		seconds = 0;
		
		paint.repaint();
	}
	
	public IntAndDouble getTime(){
		
		return new IntAndDouble(minutes, seconds);
	}
	
	public void actionPerformed(ActionEvent e){
	
		seconds += .01;
		
		if(seconds >= 60){
			
			seconds -= 60;
			minutes ++;
		}
		
		if(minutes > 0){
			
			fields.displayedDada.time = Integer.toString(minutes) + ":" + Double.toString(seconds);
		}
		
		else{
			fields.displayedDada.time = Double.toString(seconds);
		}
		
		paint.repaint();
	}
	
}
