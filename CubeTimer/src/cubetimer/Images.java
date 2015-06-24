
package cubetimer;
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
public class Images {
    public Images (){
    }
 
    public void typeStringListCentered(String[] string, int x, int y, int fontSize, Graphics g){
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        g.setFont(font);
        g.setColor(Color.BLACK);
        for(int i = 0; i < string.length; i++){
        	g.drawString(string[i], x, y - (string.length/2 - i) * fontSize);
        }
//        g.drawString(string,x,y);
 
 
    }
    public void typeStringListGoingDown(ArrayList string, int x, int y, int fontSize, Graphics g){
    	Font font = new Font("Arial", Font.PLAIN, fontSize);
    	g.setFont(font);
    	g.setColor(Color.BLACK);
    	for(int i = 0; i < string.size(); i++){
    		g.drawString(Double.toString((double) string.get(i)), x, y + (i * fontSize));
    	}
    }
    public void typeString(String string, int x, int y, int fontSize, boolean green, Graphics g){
    	Font font = new Font("Arial", Font.PLAIN, fontSize);
    	g.setFont(font);
    	if(green){
    		g.setColor(Color.GREEN);
    	}
    	else{
    		g.setColor(Color.BLACK);
    	}
    	g.drawString(string, x, y);
    }
    public void typeScrambleType(TwistyPuzzleType twistyPuzzleType, int x, int y, int fontSize, Graphics g){
    	Font font = new Font("Arial", Font.PLAIN,fontSize);
    	g.setFont(font);
    	g.setColor(Color.BLACK);
    	g.drawString(twistyPuzzleType.toString(), x, y);
    }
    public void drawBackGround(Color color, int screenWidth, int screenHeight, Graphics g){
        g.setColor(color);
        g.fillRect(0, 0, screenWidth, screenHeight);
    }
}