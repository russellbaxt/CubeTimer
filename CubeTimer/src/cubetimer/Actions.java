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
//	public String stopTimer(){
//		end = System.currentTimeMillis();
//		timeSeconds = (end - start) / 1000.0;
//		while (timeSeconds >= 60){
//			timeMinutes++;
//			timeSeconds = timeSeconds - 60;
//		}
//		String minutes = Integer.toString(timeMinutes);
//		String seconds = Double.toString(timeSeconds);
//		return minutes + ":" + seconds;
//	}

	public String getTime() {
		end = System.currentTimeMillis();
		timeSeconds = (end - start) / 1000.0;
		while (timeSeconds >= 60) {
			timeMinutes++;
			timeSeconds = timeSeconds - 60;
		}
		String Minutes = Integer.toString(timeMinutes);
		String Seconds = Double.toString(timeSeconds);
		return Minutes + ":" + Seconds;
	}
}
