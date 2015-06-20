
package cubetimer;
 
import java.awt.Color;
import java.awt.Graphics;
 
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
     
    public Timer(){
    	running = false;
        time = "0:0.0";
        images = new Images();
        actions = new Actions();
        scrambler = new Scrambler();
        randomScramble = scrambler.GenerateRandomScramble();
        countdownRunning = false;
    }
    public void spacePressed(){
    	spacePressed = true;
    }
    public void spaceReleased(){
    	spaceReleased = true;
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
    		running = false;
    		time = "DNF";
    		countdownRunning = false;
    		randomScramble = scrambler.GenerateRandomScramble();
    	}
		repaint();
    }
    public void keepTime(int width, int height){
    	screenWidth = width;
    	screenHeight = height;
        if (running){
            time = actions.getTime();
        }
        if (spacePressed){
        	spacePressed = false;
        	if(running){
            	randomScramble = scrambler.GenerateRandomScramble();
        		running = false;
        		time = actions.getTime();
        		ignoreNextRelease = true;
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
        if (countdownRunning){
        	updateCountdownTime();
        }
        repaint();
    }
    public void paintComponent (Graphics g){
        super.paintComponents(g);
        images.drawBackGround(Color.WHITE, screenWidth, screenHeight, g);
        images.typeString(time, screenWidth/2 - 100, screenHeight/2, 60, greenText, g);
        images.typeString(randomScramble,0, screenHeight/4,30, false, g);
    }
 
}