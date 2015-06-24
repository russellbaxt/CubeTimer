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
		while (timeSeconds >= 10) {
			timeMinutes++;
			timeSeconds = timeSeconds - 10;
		}
		String seconds = String.format("%.3f", timeSeconds);
		String minutes = Integer.toString(timeMinutes);
		return minutes + ":" + seconds;
	}
	public double getTimePreviouslyGotenAsDouble(){
		//return Math.floor((timeSeconds * 1000)/1000);
		//return timeSeconds;
		int theInt = (int) ((timeSeconds + timeMinutes * 60.0) * 1000.0);
		return theInt/1000.0;
	}
}
