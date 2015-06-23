package cubetimer;
import javax.swing.*;

import java.awt.*;
import java.util.Random;

public class Actions {
	private long start;
	private long end;
	private double timeSeconds;
	private int timeMinutes;
	public boolean running;

	public Actions() {
		timeSeconds = 0;
		timeMinutes = 0;
	}
	public String startTimer(){
		start = System.currentTimeMillis();
		return "0:0.0";
	}

	public String getTime(int penalty) {
		end = System.currentTimeMillis();
		timeSeconds =    (end - start) / 1000.0 + penalty;
		timeMinutes = 0;
		while (timeSeconds >= 60) {
			timeMinutes++;
			timeSeconds = timeSeconds - 60;
		}
		String Seconds = String.format("%.3f", timeSeconds);
		String Minutes = Integer.toString(timeMinutes);
		return Minutes + ":" + Seconds;
	}
	public double getTimePreviouslyGotenAsDouble(int penalty){
		//return Math.floor((timeSeconds * 1000)/1000);
		//return timeSeconds;
		int theInt = (int) (timeSeconds * 1000);
		return theInt/1000.0;
	}
}
