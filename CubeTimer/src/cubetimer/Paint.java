package cubetimer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Paint extends JPanel{
	
	Fields fields;
	
	public Paint(Fields f){
	
		fields = f;
	}
	
	private void consoleRequiresAttention(Graphics g){
	
		Images.drawBackGround(Color.GRAY, fields.windowSize.windowWidth, fields.windowSize.windowHeight, g);
		Images.typeString("The Console Requires", 0, fields.windowSize.windowHeight / 2 - fields.windowSize.windowWidth
				/ 28, fields.windowSize.windowWidth / 14, false, g);
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
				fields.windowSize.windowWidth / 40, fields.windowSize.windowWidth / 56, false, g);
		Images.typeScrambleType(fields.twistyPuzzleType, (int) (fields.windowSize.windowWidth / 1.2 - 20),
				fields.windowSize.windowWidth / 20, fields.windowSize.windowWidth / 56, g);
		Images.typeString(Integer.toString(fields.displayedDada.scrambleDada.scrambleLenght),
				(int) (fields.windowSize.windowWidth / 1.2 - 20), fields.windowSize.windowWidth / 15,
				fields.windowSize.windowWidth / 56, false, g);
	}
	
	private void menu(Graphics g){
	
		String[] menuItems =
				new String[] {"Change Twisty Puzzle", "User Menu", "Change Scramble Lenght", "New Scramble", "Options",
						"Exit"};
		
		Boolean[] greenText =
				new Boolean[] {fields.menuItems.getChangeTwistyPuzzle(), fields.menuItems.getUserMenu(),
						fields.menuItems.getChangeScrambleLenght(), fields.menuItems.getNewScramble(),
						fields.menuItems.getOptions(), fields.menuItems.getExit()};
		
		Images.drawMenuList(menuItems, fields.windowSize.windowHeight / 16, greenText, fields.windowSize.windowHeight,
				fields.windowSize.windowWidth, 1, g);
		
	}
	
	private void changeTwistyPuzzle(Graphics g){
	
		String[] menuItems =
				new String[] {"2x2x2", "3x3x3", "4x4x4", "5x5x5", "Mega Minx", "Gear Cube", "Anisatropic Gear Cube",
						"One Handed 3x3x3", "Random Twisty Puzzle", "Exit"};
		
		Boolean[] greenText =
				new Boolean[] {fields.menuItems.twistyPuzzleMenu.get2x2x2(),
						fields.menuItems.twistyPuzzleMenu.get3x3x3(), fields.menuItems.twistyPuzzleMenu.get4x4x4(),
						fields.menuItems.twistyPuzzleMenu.get5x5x5(), fields.menuItems.twistyPuzzleMenu.getMegaMinx(),
						fields.menuItems.twistyPuzzleMenu.getGearCube(),
						fields.menuItems.twistyPuzzleMenu.getAnisatropicGearCube(),
						fields.menuItems.twistyPuzzleMenu.getOneHanded3x3x3(),
						fields.menuItems.twistyPuzzleMenu.getRandomTwistyPuzzle(),
						fields.menuItems.twistyPuzzleMenu.getExit()};
		
		Images.drawMenuList(menuItems, fields.windowSize.windowWidth / 32, greenText, fields.windowSize.windowHeight,
				fields.windowSize.windowWidth, 2, g);
	}
	
	public void userMenu(Graphics g){
	
		String[] menuItems =
				new String[] {"Add User", "Change User", "Delete Current User", "Change Current User Name", "Exit"};
		
		Boolean[] greenText =
				new Boolean[] {fields.menuItems.userActionsMenu.getAddUser(),
						fields.menuItems.userActionsMenu.getChangeUser(),
						fields.menuItems.userActionsMenu.getDeleteCurrentUser(),
						fields.menuItems.userActionsMenu.getChangeCurrentUserName(),
						fields.menuItems.userActionsMenu.getExit()};
		
		Images.drawMenuList(menuItems, fields.windowSize.windowWidth / 32, greenText, fields.windowSize.windowHeight,
				fields.windowSize.windowWidth, 2, g);
	}
	
	public void changeScrambleLenght(Graphics g){
		
		Images.drawBackGround(Color.WHITE, fields.windowSize.windowWidth, fields.windowSize.windowHeight, g);
	
		Images.typeString(Integer.toString(fields.displayedDada.scrambleDada.scrambleLenght),
				fields.windowSize.windowWidth / 2 - 100, fields.windowSize.windowHeight / 2,
				fields.windowSize.windowWidth / 12, true, g);
	}
	
	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
		if(fields.displayState == DisplayState.consoleRequiresAttention){
			consoleRequiresAttention(g);
		}
		
		else if(fields.displayState == DisplayState.menu){
			
			menu(g);
		}
		
		else if(fields.displayState == DisplayState.changeTwistyPuzzle){
			
			changeTwistyPuzzle(g);
		}
		
		else if(fields.displayState == DisplayState.userMenu){
			
			userMenu(g);
		}
		
		else if(fields.displayState == DisplayState.changeScrambleLenght){
			changeScrambleLenght(g);
		}
		
		else{
			
			timer(g);
		}
	}
}
