
package cubetimer;
 
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
 
 
public class Timer extends JPanel{
    private Images images;
    private Actions actions;
    private Scrambler scrambler;
    private String time;
    private String randomScramble;
    private boolean countdownRunning;
    private double countdownStart;
    private double countdownEnd;
    private boolean spacePressed;
    private boolean running;
    private boolean ignoreNextRelease;
    private boolean spaceReleased;
    private boolean greenText;
    private int screenWidth;
    private int screenHeight;
    private boolean threePressed;
    private boolean twoPressed;
    private ScrambleType scrambleType;
    private int inspectionExtendedBy;
    private int timePenalty;
    private int scrambleLenght;
    private boolean leftPressed;
    private boolean rightPressed;
    private double scrambleSize;
    private boolean fourPressed;
    private boolean fivePressed;
    private Random random;
    private boolean rPressed;
     
    public Timer(){
    	scrambleSize = 28.0;
        scrambleLenght = 20;
    	running = false;
        time = "0:0.0";
        images = new Images();
        actions = new Actions();
        scrambler = new Scrambler();
        scrambleType = ScrambleType.threeLayeredCube;
        randomScramble = scrambler.randomCorrectScramble(scrambleType, scrambleLenght);
        countdownRunning = false;
        inspectionExtendedBy = 0;
        random = new Random();
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
    public void startCountDown(){
    	countdownRunning = true;
    	countdownStart =  (double) (System.currentTimeMillis()/1000.0);
    	repaint();
    }
    public void updateCountdownTime(){
    	countdownEnd = (double) System.currentTimeMillis()/1000.0;
    	if (countdownEnd - countdownStart < 15){
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
    				randomScramble = scrambler.randomCorrectScramble(scrambleType, scrambleLenght);
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
    	int randomNumber = random.nextInt(ScrambleType.values().length);
    	scrambleType = ScrambleType.values()[randomNumber];
    	randomScramble = scrambler.randomCorrectScramble(scrambleType, scrambleLenght);
    }
    public void keepTime(int width, int height){
    	screenWidth = width;
    	screenHeight = height;
        if (running){
            time = actions.getTime(0);
        }
        if (spacePressed){
        	spacePressed = false;
        	if(running){
            	randomScramble = scrambler.randomCorrectScramble(scrambleType, scrambleLenght);
        		running = false;
        		time = actions.getTime(timePenalty);
        		ignoreNextRelease = true;
        		timePenalty = 0;
        		inspectionExtendedBy = 0;
        	}
        	else{
        		if(!ignoreNextRelease){
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
        			if (countdownRunning){
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
        	scrambleType = ScrambleType.threeLayeredCube;
        	randomScramble = scrambler.randomCorrectScramble(scrambleType, scrambleLenght);
        }
        if(twoPressed){
        	twoPressed = false;
        	scrambleType = ScrambleType.twoLayeredCube;
        	randomScramble = scrambler.randomCorrectScramble(scrambleType, scrambleLenght);
        }
        if(fourPressed){
        	fourPressed = false;
        	scrambleType = ScrambleType.fourLayeredCube;
        	randomScramble = scrambler.randomCorrectScramble(scrambleType, scrambleLenght);
        }
        if(fivePressed){
        	fivePressed = false;
        	scrambleType = ScrambleType.fiveLayeredCube;
        	randomScramble = scrambler.randomCorrectScramble(scrambleType, scrambleLenght);
        }
        if(leftPressed){
        	leftPressed = false;
        	if(scrambleLenght > 1){
            	scrambleLenght--;
        	}
        	randomScramble = scrambler.randomCorrectScramble(scrambleType, scrambleLenght);
        }
        if(rightPressed){
        	rightPressed = false;
        	scrambleLenght++;
        	randomScramble = scrambler.randomCorrectScramble(scrambleType,scrambleLenght);
        }
        if(rPressed){
        	rPressed = false;
        	randomTwistyPuzzle();
        }
        if (countdownRunning){
        	updateCountdownTime();
        }
        scrambleSize = randomScramble.length()/2.0;
        if (scrambleSize < 4){
        	scrambleSize = 4;
        }
        repaint();
    }
    public void paintComponent (Graphics g){
        super.paintComponents(g);
        images.drawBackGround(Color.WHITE, screenWidth, screenHeight, g);
        images.typeString(time, screenWidth/2 - 100, screenHeight/2, screenWidth/14, greenText, g);
        images.typeString(randomScramble, 0, screenHeight/4, (int) (screenWidth/scrambleSize), false, g);
        images.typeScrambleType(scrambleType, 10, screenWidth/40, screenWidth/56, g);
        images.typeString(Integer.toString(scrambleLenght), 10, screenWidth/20, screenWidth/56, false, g);
    }
 
}