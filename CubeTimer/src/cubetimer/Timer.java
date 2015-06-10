
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
     
    public Timer(){
        time = "0:0.0";
        images = new Images();
        actions = new Actions();
        scrambler = new Scrambler();
        randomScramble = scrambler.GenerateRandomScramble();
    }
    public void spacePressed(){
        System.out.println("SpacePressed");
        if(actions.running == 0){
//          countDown(15);
        }
        time = actions.StartStopTimer();
        randomScramble = scrambler.GenerateRandomScramble();
        repaint();
    }
    public void countDown(int t ){
        while (t>0){
            time = Integer.toString(t);
            repaint();
            System.out.println(time);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            t--;
        }
    }
    public void keepTime(){
        if (actions.running == 1){
            time = actions.GetTime();
            repaint();
        }
    }
    public void paintComponent (Graphics g){
        System.out.println("called paint component");
        super.paintComponents(g);
        images.drawBackGround(Color.WHITE, g);
        images.typeString(time, 300, 400, 60, g);
        images.typeString(randomScramble,0,200,30,g);
        keepTime();
    }
 
}