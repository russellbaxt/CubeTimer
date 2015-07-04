package cubetimer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Paint extends JPanel{
	private Images images;
	
	private boolean consoleRequiresAttention;
	private boolean paintComponentDone;
	
	private boolean greenText;
	
	private int screenWidth;
	private int screenHeight;
	
	private String time;
	
	private boolean useStringListForRandomScramble;
	private String[] randomScrambleAfterSplit;
	private String randomScramble;
	private double scrambleSize;
	private int scrambleLenght;
	
	private String avarageOf5;
	private String currentUserName;
	private ArrayList<Double> last20Solves;
	private TwistyPuzzleType twistyPuzzleType;
	
	public Paint(){
		images = new Images();
		time = "0:0.0";
		paintComponentDone = false;
		randomScramble = "";
		last20Solves = new ArrayList<Double>();
		avarageOf5 = "";
		currentUserName = "";
		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
		
	}
	public boolean getPaintComponentDone(){
		return paintComponentDone;
	}
	
	public void repaint(boolean consoleRequiresAttentionIn, boolean greenTextIn, int screenWidthIn, int screenHeightIn,
			String timeIn, boolean useStringListForRandomScrambleIn, String[] randomScrambleAfterSplitIn,
			String randomScrambleIn, double scrambleSizeIn,int scrambeLenghtIn,
			String avarageOf5In, String currentUserNameIn, ArrayList<Double> last20SolvesIn,
			TwistyPuzzleType twistyPuzzleTypeIn){
		consoleRequiresAttention = consoleRequiresAttentionIn;
		greenText = greenTextIn;
		screenWidth = screenWidthIn;
		screenHeight = screenHeightIn;
		time = timeIn;
		useStringListForRandomScramble = useStringListForRandomScrambleIn;
		randomScrambleAfterSplit = randomScrambleAfterSplitIn;
		randomScramble = randomScrambleIn;
		scrambleSize = scrambleSizeIn;
		scrambleLenght = scrambeLenghtIn;
		
		avarageOf5 = avarageOf5In;
		currentUserName = currentUserNameIn;
		last20Solves = last20SolvesIn;
		twistyPuzzleType = twistyPuzzleTypeIn;
		
		repaint();
	}
		
	public void paintComponent(Graphics g){
		
		
		if(consoleRequiresAttention){
			
			super.paintComponents(g);
			
			images.drawBackGround(Color.GRAY, screenWidth, screenHeight, g);
			images.typeString("The Console Requires", 0, screenHeight / 2 - screenWidth / 28, screenWidth / 14, false, g);
			images.typeString("Your Attention", 0, screenHeight / 2 + screenWidth / 28, screenHeight / 14, false, g);
			
			paintComponentDone = true;
		}
		else{
			
			super.paintComponents(g);
			
			images.drawBackGround(Color.WHITE, screenWidth, screenHeight, g);
			images.typeString(time, screenWidth / 2 - 100, screenHeight / 2, screenWidth / 14, greenText, g);
			
			if(useStringListForRandomScramble){
				images.typeStringListCentered(randomScrambleAfterSplit, screenWidth / 15, screenHeight / 4, (int) (screenWidth / scrambleSize), g);
			}
			else{
				images.typeString(randomScramble, screenWidth / 15, screenHeight / 4, (int) (screenWidth / scrambleSize), false, g);
			}
			
			images.typeStringListOfTimesGoingDown(last20Solves, 0, screenWidth / 56, screenWidth / 56, g);
			images.typeString(avarageOf5, 0, (int) (screenHeight - (30 + screenWidth / 56)), screenWidth / 56, false, g);
			images.typeString(currentUserName, (int) (screenWidth / 1.2 - 20.0), screenWidth / 40, screenWidth / 56, false, g);
			images.typeScrambleType(twistyPuzzleType, (int) (screenWidth / 1.2 - 20), screenWidth / 20, screenWidth / 56, g);
			images.typeString(Integer.toString(scrambleLenght), (int) (screenWidth / 1.2 - 20), screenWidth / 15, screenWidth / 56, false, g);
		}
	}
}
