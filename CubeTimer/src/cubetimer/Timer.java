package cubetimer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Timer extends JPanel{
	
	private Images images;
	private Actions actions;
	private Scrambler scrambler;
	private DadaTracker dadaTracker;
	private Random random;
	
	private String time;
	private String randomScramble;
	
	private int screenWidth;
	private int screenHeight;
	
	private TwistyPuzzleType twistyPuzzleType;
	
	private int inspectionExtendedBy;
	private int timePenalty;
	private boolean countdownRunning;
	private double countdownStart;
	private double countdownEnd;
	private boolean running;
	private boolean ignoreNextRelease;
	private boolean greenText;
	private int scrambleLenght;
	private double scrambleSize;
	private String[] randomScrambleAfterSplit;
	private boolean useStringListForRandomScramble;
	
	private boolean consoleRequiresAtention;
	private boolean addNotChangeUser;
	private boolean paintComponentDone;
	
	private boolean spacePressed;
	private boolean spaceReleased;
	
	private boolean deletePressed;
	
	private boolean leftPressed;
	private boolean rightPressed;

	private boolean plusPressed;
	private boolean dashPressed;
	
	private boolean threePressed;
	private boolean twoPressed;
	private boolean fourPressed;
	private boolean fivePressed;
	private boolean mPressed;
	private boolean gPressed;
	private boolean aPressed;
	private boolean vPressed;
	private boolean oPressed;
	private boolean rPressed;

	public Timer(){
	
		dadaTracker = new DadaTracker();
		images = new Images();
		actions = new Actions();
		scrambler = new Scrambler();
		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
		random = new Random();
		
		scrambleSize = 28.0;
		scrambleLenght = 20;
		running = false;
		time = "0:0.0";
		randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
		countdownRunning = false;
		inspectionExtendedBy = 0;
	}
	
	public void spacePressed(){
	
		spacePressed = true;
	}
	
	public void spaceReleased(){
	
		spaceReleased = true;
	}
	
	public void threePressed(){
	
		threePressed = true;
	}
	
	public void twoPressed(){
	
		twoPressed = true;
	}
	
	public void fourPressed(){
	
		fourPressed = true;
	}
	
	public void fivePressed(){
	
		fivePressed = true;
	}
	
	public void leftPressed(){
	
		leftPressed = true;
	}
	
	public void rightPressed(){
	
		rightPressed = true;
	}
	
	public void rPressed(){
	
		rPressed = true;
	}
	
	public void mPressed(){
	
		mPressed = true;
	}
	
	public void gPressed(){
	
		gPressed = true;
	}
	
	public void aPressed(){
	
		aPressed = true;
	}
	
	public void oPressed(){
	
		oPressed = true;
	}
	
	public void vPressed(){
	
		vPressed = true;
	}
	
	public void deletePressed(){
	
		deletePressed = true;
	}
	
	public void plusPressed(){
	
		plusPressed = true;
	}
	
	public void dashPressed(){
	
		dashPressed = true;
	}
	
	public void startCountDown(){
	
		countdownRunning = true;
		countdownStart = (double) (System.currentTimeMillis() / 1000.0);
		repaint();
	}
	
	public void updateCountdownTime(){
	
		countdownEnd = (double) System.currentTimeMillis() / 1000.0;
		if(countdownEnd - countdownStart < 15){
			int timeInspected = (int) (countdownEnd - countdownStart);
			String timeLeftOfInspection = Integer.toString(15 - timeInspected);
			time = timeLeftOfInspection;
			
		}
		else{
			if(countdownEnd - countdownStart > 15 + inspectionExtendedBy){
				if(inspectionExtendedBy > 0){
					time = "DNF";
					running = false;
					countdownRunning = false;
					randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
					timePenalty = 0;
					inspectionExtendedBy = 0;
					
				}
				else{
					timePenalty = timePenalty + 2;
					time = "+2";
					inspectionExtendedBy = 2;
				}
			}
		}
		repaint();
	}
	
	public void randomTwistyPuzzle(){
	
		int randomNumber = random.nextInt(TwistyPuzzleType.values().length);
		twistyPuzzleType = TwistyPuzzleType.values()[randomNumber];
		
		if(twistyPuzzleType == TwistyPuzzleType.magaMinx){
			scrambleLenght = 40;
		}
		else{
			scrambleLenght = 20;
		}
		randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
	}
	
	public void keepTime(int width, int height){
	
		screenWidth = width;
		screenHeight = height;
		
		if(consoleRequiresAtention){
			spacePressed = false;
			spaceReleased = false;
			threePressed = false;
			twoPressed = false;
			leftPressed = false;
			rightPressed = false;
			fourPressed = false;
			fivePressed = false;
			rPressed = false;
			mPressed = false;
			gPressed = false;
			aPressed = false;
			vPressed = false;
			oPressed = false;
			deletePressed = false;
			plusPressed = false;
			
			if(paintComponentDone){
				
				if(addNotChangeUser){
					dadaTracker.addUser();
				}
				else{
					dadaTracker.changeToUser();
				}
				consoleRequiresAtention = false;
				
			}
		}
		else{
			if(running){
				time = actions.getTime(0);
			}
			if(spacePressed){
				
				spacePressed = false;
				
				if(running){
					
					randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
					running = false;
					time = actions.getTime(timePenalty);
					ignoreNextRelease = true;
					timePenalty = 0;
					inspectionExtendedBy = 0;
					dadaTracker.addTime(twistyPuzzleType, actions.getTimePreviouslyGotenAsDouble());
				}
				else{
					
					if(! ignoreNextRelease){
						greenText = true;
					}
				}
			}
			if(spaceReleased){
				
				spaceReleased = false;
				greenText = false;
				
				if(ignoreNextRelease){
					ignoreNextRelease = false;
				}
				else{
					if(!running){
						
						randomScramble = "";
						
						if(countdownRunning){
							
							countdownRunning = false;
							running = true;
							time = actions.startTimer();
						}
						else{
							startCountDown();
						}
					}
				}
			}
			if(threePressed){
				
				threePressed = false;
				twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
				scrambleLenght = 20;
			}
			if(twoPressed){
				
				twoPressed = false;
				twistyPuzzleType = TwistyPuzzleType.cube2x2x2;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
				scrambleLenght = 20;
			}
			if(fourPressed){
				
				fourPressed = false;
				twistyPuzzleType = TwistyPuzzleType.cube4x4x4;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
				scrambleLenght = 20;
			}
			if(fivePressed){
				
				fivePressed = false;
				twistyPuzzleType = TwistyPuzzleType.cube5x5x5;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
				scrambleLenght = 20;
			}
			if(leftPressed){
				
				leftPressed = false;
				
				if(scrambleLenght > 1){
					scrambleLenght --;
				}
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
			}
			if(rightPressed){
				
				rightPressed = false;
				scrambleLenght ++;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
			}
			if(rPressed){
				
				rPressed = false;
				randomTwistyPuzzle();
			}
			if(mPressed){
				
				mPressed = false;
				twistyPuzzleType = TwistyPuzzleType.magaMinx;
				scrambleLenght = 40;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
			}
			if(gPressed){
				gPressed = false;
				twistyPuzzleType = TwistyPuzzleType.gearCube;
				scrambleLenght = 20;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
			}
			if(aPressed){
				
				aPressed = false;
				twistyPuzzleType = TwistyPuzzleType.anisatropicGearCube;
				scrambleLenght = 20;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
			}
			if(oPressed){
				
				oPressed = false;
				twistyPuzzleType = TwistyPuzzleType.oneHanded3x3x3;
				scrambleLenght = 20;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
			}
			if(vPressed){
				
				vPressed = false;
				twistyPuzzleType = TwistyPuzzleType.voidChalangeCube;
				scrambleLenght = 20;
				randomScramble = scrambler.randomCorrectScramble(twistyPuzzleType, scrambleLenght);
			}
			if(deletePressed){
				
				deletePressed = false;
				dadaTracker.deleteLastSolve();
			}
			if(plusPressed){
				
				plusPressed = false;
				consoleRequiresAtention = true;
				addNotChangeUser = true;
				repaint();
			}
			if(dashPressed){
				
				dashPressed = false;
				consoleRequiresAtention = true;
				addNotChangeUser = false;
				repaint();
			}
			if(countdownRunning){
				updateCountdownTime();
			}
			if(randomScramble.contains("/n")){
				
				randomScrambleAfterSplit = randomScramble.split("/n");
				scrambleSize = randomScrambleAfterSplit[0].length() / 2 + 4;
				useStringListForRandomScramble = true;
			}
			else{
				
				scrambleSize = randomScramble.length() / 2;
				useStringListForRandomScramble = false;
			}
			if(scrambleSize < 4){
				scrambleSize = 4;
			}
			repaint();
			
		}
	}
	
	public void paintComponent(Graphics g){
	
		if(consoleRequiresAtention){
			
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
			
			images.typeStringListOfTimesGoingDown(dadaTracker.getlast20Solves(twistyPuzzleType), 0, screenWidth / 56, screenWidth / 56, g);
			images.typeString(dadaTracker.getAvarageOf5(twistyPuzzleType), 0, (int) (screenHeight - (30 + screenWidth / 56)), screenWidth / 56, false, g);
			images.typeString(dadaTracker.getCurrentUserName(), (int) (screenWidth / 1.2 - 20.0), screenWidth / 40, screenWidth / 56, false, g);
			images.typeScrambleType(twistyPuzzleType, (int) (screenWidth / 1.2 - 20), screenWidth / 20, screenWidth / 56, g);
			images.typeString(Integer.toString(scrambleLenght), (int) (screenWidth / 1.2 - 20), screenWidth / 15, screenWidth / 56, false, g);
		}
	}
	
}
