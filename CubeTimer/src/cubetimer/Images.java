package cubetimer;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class Images{
	
	public Images(){
	
	}
	
	public static void typeStringListCentered(String[] string, int x, int y, int fontSize, Graphics g){
	
		Font font = new Font("Arial", Font.PLAIN, fontSize);
		g.setFont(font);
		g.setColor(Color.BLACK);
		
		for(int i = 0; i < string.length; i ++){
			g.drawString(string[i], x, y - (string.length / 2 - i) * fontSize);
		}
		
	}
	
	public static void typeStringListOfTimesGoingDown(ArrayList<Double> arrayList, int x, int y, int fontSize, Graphics g){
	
		int timeMinutes;
		ArrayList<Double> list = (ArrayList<Double>) arrayList.clone();
		
		Font font = new Font("Arial", Font.PLAIN, fontSize);
		g.setFont(font);
		g.setColor(Color.BLACK);
		
		for(int i = 0; i < list.size(); i ++){
			
			timeMinutes = 0;
			while(list.get(i) > 60){
				timeMinutes = timeMinutes + 1;
				list.set(i, list.get(i) - 60.0);
			}
			
			g.drawString(Integer.toString(timeMinutes) + ":" + (String.format("%.3f", (double) list.get(i))), x, y + (i * fontSize));
		}
	}
	
	public static void typeString(String string, int x, int y, int fontSize, boolean green, Graphics g){
	
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
	
	public static void typeScrambleType(TwistyPuzzleType twistyPuzzleType, int x, int y, int fontSize, Graphics g){
	
		Font font = new Font("Arial", Font.PLAIN, fontSize);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(twistyPuzzleType.toString(), x, y);
	}
	
	public static void drawBackGround(Color color, int screenWidth, int screenHeight, Graphics g){
		
		g.drawRect(30, 30, 100, 100);
		g.setColor(color);
		g.fillRect(0, 0, screenWidth, screenHeight);
	}
}
