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
		running = false;
		timeSeconds = 0;
		timeMinutes = 0;
	}

	public String startStopTimer() {
		if (running == false) {
			running = true;
			start = System.currentTimeMillis();
			timeMinutes = 0;
			timeSeconds = 0;
		} else {
			running = false;
			end = System.currentTimeMillis();
			timeSeconds = (end - start) / 1000.0;
		}
		while (timeSeconds >= 60) {
			timeMinutes++;
			timeSeconds = timeSeconds - 60;
		}
		String Minutes = Integer.toString(timeMinutes);
		String Seconds = Double.toString(timeSeconds);
		return Minutes + ":" + Seconds;
	}

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
