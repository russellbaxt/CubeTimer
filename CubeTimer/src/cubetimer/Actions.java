package cubetimer;
import javax.swing.*;

import java.awt.*;
import java.util.Random;

public class Actions {
	long start;
	long end;
	double timeSeconds;
	int timeMinutes;
	public int running;

	public Actions() {
		running = 0;
		timeSeconds = 0;
		timeMinutes = 0;
	}

	public String startStopTimer() {
		if (running == 0) {
			running = 1;
			start = System.currentTimeMillis();
			timeMinutes = 0;
			timeSeconds = 0;
		} else {
			running = 0;
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
