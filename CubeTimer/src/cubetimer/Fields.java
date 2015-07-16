package cubetimer;

import java.util.ArrayList;
import java.util.Random;

public class Fields{
	
	public DisplayedDada displayedDada;
	public TimerStatus timerStatus;

	public int screenWidth;
	public int screenHeight;

	public TwistyPuzzleType twistyPuzzleType;

	public boolean greenText;

	public boolean ignoreNextRelese;
	
	public boolean DNF;
	public int timePenalty;

	public boolean consoleRequiresAtention;
	public boolean addNotChangeUser;
	public boolean paintComponentDone;

	public Fields() {
		
		displayedDada = new DisplayedDada();
		timerStatus = new TimerStatus();
		
		DNF = false;
		timePenalty = 0;
		paintComponentDone = false;

		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
	}

	public void setScreenSize(int screenWidthIn, int screenHeightIn) {

		screenWidth = screenWidthIn;
		screenHeight = screenHeightIn;
	}
}