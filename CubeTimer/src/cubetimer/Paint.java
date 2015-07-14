package cubetimer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Paint extends JPanel{
	
	Fields fields;
	
//	private boolean consoleRequiresAttention;
//	private boolean paintComponentDone;
//	
//	private boolean greenText;
//	
//	private int screenWidth;
//	private int screenHeight;
//	
//	private String time;
//	
//	private boolean useStringListForRandomScramble;
//	private String[] randomScrambleAfterSplit;
//	private String randomScramble;
//	private double scrambleSize;
//	private int scrambleLenght;
//	
//	private String avarageOf5;
//	private String currentUserName;
//	private ArrayList<Double> last20Solves;
//	private TwistyPuzzleType twistyPuzzleType;
	
	public Paint(Fields f){
		
		fields = f;
		
//		time = "0:0.0";
//		paintComponentDone = false;
//		randomScramble = "";
//		last20Solves = new ArrayList<Double>();
//		avarageOf5 = "";
//		currentUserName = "";
//		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
		
	}
//	public boolean getPaintComponentDone(){
//		return paintComponentDone;
//	}
	
//	public void repaint(boolean consoleRequiresAttentionIn, boolean greenTextIn, int screenWidthIn, int screenHeightIn,
//			String timeIn, boolean useStringListForRandomScrambleIn, String[] randomScrambleAfterSplitIn,
//			String randomScrambleIn, double scrambleSizeIn,int scrambeLenghtIn,
//			String avarageOf5In, String currentUserNameIn, ArrayList<Double> last20SolvesIn,
//			TwistyPuzzleType twistyPuzzleTypeIn){
//		consoleRequiresAttention = consoleRequiresAttentionIn;
//		greenText = greenTextIn;
//		screenWidth = screenWidthIn;
//		screenHeight = screenHeightIn;
//		time = timeIn;
//		useStringListForRandomScramble = useStringListForRandomScrambleIn;
//		randomScrambleAfterSplit = randomScrambleAfterSplitIn;
//		randomScramble = randomScrambleIn;
//		scrambleSize = scrambleSizeIn;
//		scrambleLenght = scrambeLenghtIn;
//		
//		avarageOf5 = avarageOf5In;
//		currentUserName = currentUserNameIn;
//		last20Solves = last20SolvesIn;
//		twistyPuzzleType = twistyPuzzleTypeIn;
//		
//		repaint();
//	}
	
		
	public void paintComponent(Graphics g){
		
		
		if(fields.getConsoleRequiresAttention()){
			
			super.paintComponents(g);
			
			Images.drawBackGround(Color.GRAY, fields.getScreenWidth(), fields.getScreenHeight(), g);
			Images.typeString("The Console Requires", 0, fields.getScreenHeight() / 2 - fields.getScreenWidth() / 28, fields.getScreenWidth() / 14, false, g);
			Images.typeString("Your Attention", 0, fields.getScreenHeight() / 2 + fields.getScreenWidth() / 28, fields.getScreenWidth() / 14, false, g);
			
			fields.setPaintComponentDone(true);
		
		}
		else{
			
			super.paintComponents(g);
			
			Images.drawBackGround(Color.WHITE, fields.getScreenWidth(), fields.getScreenHeight(), g);
			Images.typeString(fields.getTime(), fields.getScreenWidth() / 2 - 100, fields.getScreenHeight() / 2, fields.getScreenWidth() / 14, fields.getGreenText(), g);
			
			if(fields.getUseStringListForRandomScramble()){
				Images.typeStringListCentered(fields.getRandomScrambleAfterSplit(), fields.getScreenWidth() / 15, fields.getScreenHeight() / 4,
						(int) (fields.getScreenWidth() / fields.getScrambleSize()), g);
			}
			else{
				Images.typeString(fields.getRandomScramble(), fields.getScreenWidth() / 15, fields.getScreenHeight() / 4,
						(int) (fields.getScreenWidth() / fields.getScrambleSize()), false, g);
			}
			
			Images.typeStringListOfTimesGoingDown(fields.getLast20Solves(), 0, fields.getScreenWidth() / 56, fields.getScreenWidth() / 56, g);
			Images.typeString(fields.getAvarageOf5(), 0, (int) (fields.getScreenHeight() - (30 + fields.getScreenWidth() / 56)), fields.getScreenWidth() / 56, false, g);
			Images.typeString(fields.getCurrenUserName(), (int) (fields.getScreenWidth() / 1.2 - 20.0), fields.getScreenWidth() / 40, fields.getScreenWidth() / 56, false, g);
			Images.typeScrambleType(fields.getTwistyPuzzleType(), (int) (fields.getScreenWidth() / 1.2 - 20), fields.getScreenWidth() / 20, fields.getScreenWidth() / 56, g);
			Images.typeString(Integer.toString(fields.getScrambleLength()), (int) (fields.getScreenWidth() / 1.2 - 20), fields.getScreenWidth() / 15, fields.getScreenWidth() / 56, false, g);
		}
	}
}
