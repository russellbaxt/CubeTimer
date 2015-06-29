package cubetimer;

import java.util.ArrayList;
import java.util.Random;

public class Fields{
	
	private Paint paint;
	
	private String randomScramble;
	
	private int screenWidth;
	private int screenHeight;
	
	private TwistyPuzzleType twistyPuzzleType;
	
	private boolean greenText;
	private int scrambleLenght;
	private double scrambleSize;
	private String[] randomScrambleAfterSplit;
	private boolean useStringListForRandomScramble;
	
	private String time;
	
	private ArrayList<Double> last20Solves;
	private String currentUserName;
	private String avarageOf5;
	
	private boolean ignoreNextRelese;
	private boolean running;
	private boolean countDownRunning;
	
	private boolean consoleRequiresAtention;
	private boolean addNotChangeUser;
	
	public Fields(Paint p){
	
		paint = p;
		
		randomScramble = "";
		time = "0:0.0";
		scrambleSize = 28.0;
		scrambleLenght = 20;
		last20Solves = new ArrayList<Double>();
		avarageOf5 = "";
		currentUserName = "";
		
		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
	}
	
	public void repaint(){
	
		paint.repaint(consoleRequiresAtention, greenText, screenWidth, screenHeight, time, useStringListForRandomScramble, randomScrambleAfterSplit, randomScramble, scrambleSize, scrambleLenght, avarageOf5, currentUserName, last20Solves, twistyPuzzleType);
		
	}
	
	
	
	//TODO organize the following methods
	public void setLast20Solves(ArrayList<Double> last20SolvesIn){
	
		last20Solves = last20SolvesIn;
	}
	
	public String getRandomScramble(){
		return randomScramble;
	}
	
	public void setRandomScramble(String randomScrambleIn){
		randomScramble = randomScrambleIn;
	}
	
	public TwistyPuzzleType getTwistyPuzzleType(){
		return twistyPuzzleType;
	}
	
	
	public String getTime(){
		return time;
	}
	
	public void setTime(String timeIn){
		time = timeIn;
	}
	public boolean getIgnoreNextRelese(){
		return ignoreNextRelese;
	}
	public void setIgnoreNextRelese(boolean ignoreNextReleseIn){
		ignoreNextRelese = ignoreNextReleseIn;
	}
	public void setGreenText(boolean greenTextIn){
		greenText = greenTextIn;
	}
	public boolean getRunning(){
		return running;
	}
	public boolean getCountDownRunning(){
		return countDownRunning;
	}
	public void setCountDownRunning(boolean countDownRunningIn){
		countDownRunning = countDownRunningIn;
	}
	public void setTwistyPuzzleType(TwistyPuzzleType twistyPuzzleTypeIn){
		twistyPuzzleType = twistyPuzzleTypeIn;
	}
	public void setScrambleLenght(int scrambleLenghtIn){
		scrambleLenght = scrambleLenghtIn;
	}
	public int getScrambleLength(){
		return scrambleLenght;
	}
	public boolean getConsoleRequiresAttention(){
		return consoleRequiresAtention;
	}
	public void setConsoleRequiresAttention(boolean consoleRequresAttentionIn){
		consoleRequiresAtention = consoleRequresAttentionIn;
	}
	public void setAddNotChangeUser(boolean addNotChangeUserIn){
		addNotChangeUser = addNotChangeUserIn;
	}
	public boolean getPaintComponentDone(){
		return paint.getPaintComponentDone();
	}
	public boolean getAddNotChangeUser(){
		return addNotChangeUser;
	}
	public void setRandomScrambleAfterSplit(String[] randomScrambleAfterSplitIn){
		randomScrambleAfterSplit = randomScrambleAfterSplitIn;
	}
	public void setScrambleSize(double scrambleSizeIn){
		scrambleSize = scrambleSizeIn;
	}
	public String[] getRandomScrambleAfterSplit(){
		return randomScrambleAfterSplit;
	}
	public void setUseStringListForRandomScramble(boolean useStringListForRandomScrambleIn){
		useStringListForRandomScramble = useStringListForRandomScrambleIn;
	}
	public double getScrambleSize(){
		return scrambleSize;
	}
	public void setCurrentUserName(String currentUserNameIn){
		currentUserName = currentUserNameIn;
	}
	public void setAvarageOf5(String avarageOf5In){
		avarageOf5 = avarageOf5In;
	}
	public void setRunning(boolean runningIn){
		running = runningIn;
	}
}
