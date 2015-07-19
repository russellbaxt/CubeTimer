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
	
	private void consoleRequiresAttention(Graphics g){
		
		Images.drawBackGround(Color.GRAY, fields.windowSize.windowWidth, fields.windowSize.windowHeight, g);
		Images.typeString("The Console Requires", 0,
				fields.windowSize.windowHeight / 2 - fields.windowSize.windowWidth / 28,
				fields.windowSize.windowWidth / 14, false, g);
		Images.typeString("Your Attention", 0, fields.windowSize.windowHeight / 2 + fields.windowSize.windowWidth / 28,
				fields.windowSize.windowWidth / 14, false, g);
		
		fields.paintComponentDone = true;
	}
	
	private void timer(Graphics g){
		
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
	
	private void menu(Graphics g){
		
		Images.drawBackGround(Color.WHITE, fields.windowSize.windowWidth, fields.windowSize.windowHeight, g);
		
		Images.typeString("Change Twisty Puzzle Type", 0,
				fields.windowSize.windowHeight / 16 + fields.windowSize.windowWidth / 20, 
				fields.windowSize.windowWidth / 16, fields.menuItems.getChangeTwistyPuzzle(), g);
		
		
		Images.typeString("User Menu", 0,
				fields.windowSize.windowHeight / 16 + (fields.windowSize.windowWidth / 20) * 2 + fields.windowSize.windowWidth / 50,
				fields.windowSize.windowWidth / 16, fields.menuItems.getUserMenu(), g);
		
		Images.typeString("Change Scramble Lenght", 0,
				fields.windowSize.windowHeight / 16 + (fields.windowSize.windowWidth / 20) * 3 + (fields.windowSize.windowWidth / 50 ) * 2,
				fields.windowSize.windowWidth / 16, fields.menuItems.getChangeScrambleLenght(), g);
		
		Images.typeString("Exit", 0,
				fields.windowSize.windowHeight / 16 + (fields.windowSize.windowWidth / 20) * 4 + (fields.windowSize.windowWidth / 50) * 3,
				fields.windowSize.windowWidth / 16, fields.menuItems.getExit(), g);
				
	}
	
	private void changeTwistyPuzzle(Graphics g){
		
		Images.drawBackGround(Color.WHITE, fields.windowSize.windowWidth, fields.windowSize.windowHeight, g);
		
		Images.typeString("2x2x2", 0, fields.windowSize.windowWidth / 16 + fields.windowSize.windowWidth / 40,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.get2x2x2(), g);
		
		Images.typeString("3x3x3", 0,
				fields.windowSize.windowHeight / 16 + (fields.windowSize.windowWidth / 40) * 2 + fields.windowSize.windowWidth / 100,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.get3x3x3(), g);
		
		Images.typeString("4x4x4", 0,
				fields.windowSize.windowHeight / 16 + (fields.windowSize.windowWidth / 40) * 3 + (fields.windowSize.windowWidth / 100) * 2,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.get4x4x4(), g);
		
		Images.typeString("5x5x5", 0,
				fields.windowSize.windowWidth / 16 + (fields.windowSize.windowWidth / 40) * 4 + (fields.windowSize.windowWidth / 100) * 3,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.get5x5x5(), g);
		
		Images.typeString("Mega minx", 0,
				fields.windowSize.windowWidth / 16 + (fields.windowSize.windowWidth / 40) * 5 + (fields.windowSize.windowWidth / 100) * 4,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.getMegaMinx(), g);
	
		Images.typeString("Gear Cube", 0,
				fields.windowSize.windowWidth / 16 + (fields.windowSize.windowWidth / 40) * 6 + (fields.windowSize.windowWidth / 100) * 5,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.getGearCube(), g);
		
		Images.typeString("Anisatropic Gear Cube", 0,
				fields.windowSize.windowWidth / 16 + (fields.windowSize.windowWidth / 40) * 7 + (fields.windowSize.windowWidth / 100) * 6,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.getAnisatropicGearCube(), g);
		
		Images.typeString("One Handed 3x3x3", 0,
				fields.windowSize.windowWidth / 16 + (fields.windowSize.windowWidth / 40) * 8 + (fields.windowSize.windowWidth / 100) * 7,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.getOneHanded3x3x3(), g);
		
		Images.typeString("Random Twisty Puzzle", 0,
				fields.windowSize.windowWidth / 16 + (fields.windowSize.windowWidth / 40) * 9 + (fields.windowSize.windowWidth / 100) * 8,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.getRandomTwistyPuzzle(), g);
		
		Images.typeString("Exit", 0,
				fields.windowSize.windowWidth / 16 + (fields.windowSize.windowWidth / 40) * 10 + (fields.windowSize.windowWidth / 100) * 9,
				fields.windowSize.windowWidth / 32, fields.menuItems.twistyPuzzleMenu.getExit(), g);
		
	}
		
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		if(fields.consoleRequiresAtention){
			consoleRequiresAttention(g);
		}
		
		else if(fields.displayState == DisplayState.menu){
			
			menu(g);
		}
		
		else if(fields.displayState == DisplayState.changeTwistyPuzzle){
			
			changeTwistyPuzzle(g);
		}
		
		else{
			
			timer(g);
		}
	}
}
