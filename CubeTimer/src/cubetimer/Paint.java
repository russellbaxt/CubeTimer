package cubetimer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Paint extends JPanel{
	
	Fields fields;
	
	public Paint(Fields f){
		
		fields = f;	
	}
	
	public void consoleRequiresAttention(Graphics g){
		
		Images.drawBackGround(Color.GRAY, fields.windowSize.windowWidth, fields.windowSize.windowHeight, g);
		Images.typeString("The Console Requires", 0,
				fields.windowSize.windowHeight / 2 - fields.windowSize.windowWidth / 28,
				fields.windowSize.windowWidth / 14, false, g);
		Images.typeString("Your Attention", 0, fields.windowSize.windowHeight / 2 + fields.windowSize.windowWidth / 28,
				fields.windowSize.windowWidth / 14, false, g);
		
		fields.paintComponentDone = true;
	}
	
	public void timer(Graphics g){
		
		Images.drawBackGround(Color.WHITE, fields.windowSize.windowWidth, fields.windowSize.windowHeight, g);
		Images.typeString(fields.displayedDada.time, fields.windowSize.windowWidth / 2 - 100,
				fields.windowSize.windowHeight / 2, fields.windowSize.windowWidth / 14, fields.greenText, g);
		
		if(fields.displayedDada.scrambleDada.useStringListForRandomScramble){
			Images.typeStringListCentered(fields.displayedDada.scrambleDada.randomScrambleAfterSplit,
					fields.windowSize.windowWidth / 15, fields.windowSize.windowHeight / 4,
					(int) (fields.windowSize.windowWidth / fields.displayedDada.scrambleDada.scrambleSize), g);
		}
		else{
			Images.typeString(fields.displayedDada.scrambleDada.randomScramble, fields.windowSize.windowWidth / 15,
					fields.windowSize.windowHeight / 4,
					(int) (fields.windowSize.windowWidth / fields.displayedDada.scrambleDada.scrambleSize), false, g);
		}
		
		Images.typeStringListOfTimesGoingDown(fields.displayedDada.last20Solves, 0, fields.windowSize.windowWidth / 56,
				fields.windowSize.windowWidth / 56, g);
		Images.typeString(fields.displayedDada.avarageOf5, 0,
				(int) (fields.windowSize.windowHeight - (30 + fields.windowSize.windowWidth / 56)),
				fields.windowSize.windowWidth / 56, false, g);
		Images.typeString(fields.displayedDada.currentUserName, (int) (fields.windowSize.windowWidth / 1.2 - 20.0),
				fields.windowSize.windowWidth / 40,fields.windowSize.windowWidth / 56, false, g);
		Images.typeScrambleType(fields.twistyPuzzleType, (int) (fields.windowSize.windowWidth / 1.2 - 20),
				fields.windowSize.windowWidth / 20,
				fields.windowSize.windowWidth / 56, g);
		Images.typeString(Integer.toString(fields.displayedDada.scrambleDada.scrambleLenght),
				(int) (fields.windowSize.windowWidth / 1.2 - 20), fields.windowSize.windowWidth / 15,
				fields.windowSize.windowWidth / 56, false, g);
	}
	
	public void menu(Graphics g){
		Images.typeString("Change Twisty Puzzle Type", 0, 0, fields.windowSize.windowWidth / 14,
				fields.menuItems.changeTwistyPuzzle, g);
		
	}
		
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		if(fields.consoleRequiresAtention){
			consoleRequiresAttention(g);
		}
		
		else if(fields.displayState == DisplayState.menu){
			
			menu(g);
		}
		
		else{
			
			timer(g);
		}
	}
}
