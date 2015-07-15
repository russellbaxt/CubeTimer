package cubetimer;

import java.util.ArrayList;
import java.util.Random;

public class Fields{
	
	public ScrambleDada scrambleDada;

	public int screenWidth;
	public int screenHeight;

	public TwistyPuzzleType twistyPuzzleType;

	public boolean greenText;

	public String time;

	public ArrayList<Double> last20Solves;
	public String currentUserName;
	public String avarageOf5;

	public boolean ignoreNextRelese;
	public boolean running;
	public boolean countDownRunning;
	public boolean DNF;
	public int timePenalty;

	public boolean consoleRequiresAtention;
	public boolean addNotChangeUser;
	public boolean paintComponentDone;

	public Fields() {
		
		scrambleDada = new ScrambleDada();
		
		time = "0:0.0";
		last20Solves = new ArrayList<Double>();
		avarageOf5 = "No Avarage Of 5 Yet";
		currentUserName = "";
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