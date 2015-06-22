
package cubetimer;
import javax.swing.*;

import java.awt.*;
public class Images {
    public Images (){
    }
 
    public void typeStringList(String[] string, int x, int y, int fontSize, Graphics g){
        Font font = new Font("Arial", Font.PLAIN,fontSize);
        g.setFont(font);
        for(int i = 0; i < string.length; i++){
        	g.drawString(string[i], x, y - (string.length/2 + i) * fontSize);
        }
//        g.drawString(string,x,y);
 
 
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
    public void typeScrambleType(ScrambleType scrambleType, int x, int y, int fontSize, Graphics g){
    	Font font = new Font("Arial", Font.PLAIN,fontSize);
    	g.setFont(font);
    	g.setColor(Color.BLACK);
    	g.drawString(scrambleType.toString(), x, y);
    }
    public void drawBackGround(Color color, int screenWidth, int screenHeight, Graphics g){
        g.setColor(color);
        g.fillRect(0, 0, screenWidth, screenHeight);
    }
}