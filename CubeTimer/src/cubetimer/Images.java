
package cubetimer;
import javax.swing.*;
 
import java.awt.*;
public class Images {
    public Images (){
    }
 
    public void typeString(String string, int x, int y,int fontSize,Graphics g){
        Font font = new Font("Arial", Font.PLAIN,fontSize);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(string,x,y);
 
 
    }
    public void drawBackGround(Color color, Graphics g){
        g.setColor(color);
        g.fillRect(0, 0, 800, 830);
    }
}