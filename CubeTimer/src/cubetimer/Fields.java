package cubetimer;

import java.util.ArrayList;
import java.util.Random;

public class Fields{

	public String randomScramble;

	public int screenWidth;
	public int screenHeight;

	public TwistyPuzzleType twistyPuzzleType;

	public boolean greenText;
	public int scrambleLenght;
	public double scrambleSize;
	public String[] randomScrambleAfterSplit;
	public boolean useStringListForRandomScramble;

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
		randomScramble = "";
		time = "0:0.0";
		scrambleSize = 28.0;
		scrambleLenght = 20;
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