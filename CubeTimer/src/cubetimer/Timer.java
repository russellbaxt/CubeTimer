
package cubetimer;
 
import java.awt.Color;
import java.awt.Graphics;
 
import javax.swing.JPanel;
 
 
public class Timer extends JPanel{// we need to extend JPanel in order to call paintComponent
    Images images;
    Actions actions;
    Scrambler scrambler;
    String time;
    String randomScramble;
    boolean countdownRunning;
    long countdownStart;
    long countdownEnd;
     
    public Timer(){
        time = "0:0.0";
        images = new Images();
        actions = new Actions();
        scrambler = new Scrambler();
        randomScramble = scrambler.GenerateRandomScramble();
    }
    public void spacePressed(){
        System.out.println("SpacePressed");
        randomScramble = scrambler.GenerateRandomScramble();
        countdownRunning = false;
        if(actions.running == 0){
          startCountDown();
        }
        else{
        	time = actions.startStopTimer();
        }
        repaint();
    }
    public void startCountDown(){
    	countdownRunning = true;
    	countdownStart = System.currentTimeMillis();
    	repaint();
    	//        while (t>0){
//            time = Integer.toString(t);
//            repaint();
//            System.out.println(time);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            t--;
//        }
    }
    public void updateCountdownTime(){
    	countdownEnd = System.currentTimeMillis();
		if (countdownEnd - countdownStart < 1){
			time = "15";
		}
		else if (countdownEnd - countdownStart < 2){
			time = "14";
		}
		else if (countdownEnd - countdownStart < 3){
			time = "13";
		}
		else if (countdownEnd - countdownStart < 4){
			time = "12";
		}
		else if (countdownEnd - countdownStart < 5){
			time = "11";
		}
		else if (countdownEnd - countdownStart < 6){
			time = "10";
		}
		else if (countdownEnd - countdownStart < 7){
			time = "9";
		}
		else if (countdownEnd - countdownStart < 8){
			time = "8";
		}
		else if (countdownEnd - countdownStart < 9){
			time = "7";
		}
		else if (countdownEnd - countdownStart < 10){
			time = "6";
		}
		else if (countdownEnd - countdownStart < 11){
			time = "5";
		}
		else if (countdownEnd - countdownStart < 12){
			time = "4";
		}
		else if (countdownEnd - countdownStart < 13){
			time = "3";
		}
		else if (countdownEnd - countdownStart < 14){
			time = "2";
		}
		else if (countdownEnd - countdownStart < 15){
			time = "1";
		}
		else{
			time = actions.startStopTimer();
		}
		repaint();
    }
    public void keepTime(){
        if (actions.running == 1){
            time = actions.getTime();
            repaint();
        }
    }
    public void paintComponent (Graphics g){
        System.out.println("called paint component");
        super.paintComponents(g);
        images.drawBackGround(Color.WHITE, g);
        images.typeString(time, 300, 400, 60, g);
        images.typeString(randomScramble,0,200,30,g);
        if (countdownRunning){
            updateCountdownTime();
        }
        else{
        	keepTime();
        }
    }
 
}