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
		
	public void paintComponent(Graphics g){
		
		
		if(fields.consoleRequiresAtention){
			
			super.paintComponents(g);
			
			Images.drawBackGround(Color.GRAY, fields.screenWidth, fields.screenHeight, g);
			Images.typeString("The Console Requires", 0, fields.screenHeight / 2 - fields.screenWidth / 28,
					fields.screenWidth / 14, false, g);
			Images.typeString("Your Attention", 0, fields.screenHeight / 2 + fields.screenWidth / 28,
					fields.screenWidth / 14, false, g);
			
			fields.paintComponentDone = true;;
		
		}
		else{
			
			super.paintComponents(g);
			
			Images.drawBackGround(Color.WHITE, fields.screenWidth, fields.screenHeight, g);
			Images.typeString(fields.displayedDada.time, fields.screenWidth / 2 - 100, fields.screenHeight / 2, fields.screenWidth / 14,
					fields.greenText, g);
			
			if(fields.displayedDada.scrambleDada.useStringListForRandomScramble){
				Images.typeStringListCentered(fields.displayedDada.scrambleDada.randomScrambleAfterSplit, fields.screenWidth / 15,
						fields.screenHeight / 4, (int) (fields.screenWidth / fields.displayedDada.scrambleDada.scrambleSize), g);
			}
			else{
				Images.typeString(fields.displayedDada.scrambleDada.randomScramble, fields.screenWidth / 15, fields.screenHeight / 4,
						(int) (fields.screenWidth / fields.displayedDada.scrambleDada.scrambleSize), false, g);
			}
			
			Images.typeStringListOfTimesGoingDown(fields.displayedDada.last20Solves, 0, fields.screenWidth / 56,
					fields.screenWidth / 56, g);
			Images.typeString(fields.displayedDada.avarageOf5, 0, (int) (fields.screenHeight - (30 + fields.screenWidth / 56)),
					fields.screenWidth / 56, false, g);
			Images.typeString(fields.displayedDada.currentUserName, (int) (fields.screenWidth / 1.2 - 20.0), fields.screenWidth / 40,
					fields.screenWidth / 56, false, g);
			Images.typeScrambleType(fields.twistyPuzzleType, (int) (fields.screenWidth / 1.2 - 20), fields.screenWidth / 20,
					fields.screenWidth / 56, g);
			Images.typeString(Integer.toString(fields.displayedDada.scrambleDada.scrambleLenght), (int) (fields.screenWidth / 1.2 - 20),
					fields.screenWidth / 15, fields.screenWidth / 56, false, g);
		}
	}
}
