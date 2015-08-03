package cubetimer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import fields.DisplayState;
import fields.Fields;

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
		
		Images.typeStringListOfTimesGoingDown(fields.allUsers.getUser().getTwistyPuzzle().getTimes(), 0, fields.windowSize.windowWidth / 56,
				fields.windowSize.windowWidth / 56, g);
		Images.typeString(fields.displayedDada.avarageOf5, 0,
				(int) (fields.windowSize.windowHeight - (30 + fields.windowSize.windowWidth / 56)),
				fields.windowSize.windowWidth / 56, false, g);
		Images.typeString(fields.allUsers.getUser().getUserName(), (int) (fields.windowSize.windowWidth / 1.2 - 20.0),
				fields.windowSize.windowWidth / 40, fields.windowSize.windowWidth / 56, false, g);
		Images.typeScrambleType(fields.allUsers.getUser().getTwistyPuzzleType(), (int) (fields.windowSize.windowWidth / 1.2 - 20),
				fields.windowSize.windowWidth / 20, fields.windowSize.windowWidth / 56, g);
		Images.typeString(Integer.toString(fields.displayedDada.scrambleDada.scrambleLenght),
				(int) (fields.windowSize.windowWidth / 1.2 - 20), fields.windowSize.windowWidth / 15,
				fields.windowSize.windowWidth / 56, false, g);
	}
	
	private void menu(Graphics g){
	
		String[] menuItems =
				new String[] {"Change Twisty Puzzle", "User Menu", "Change Scramble Lenght", "Delete Last Solve",
						"New Scramble", "Options", "Exit", "Quit"};
		
		Boolean[] greenText =
				new Boolean[] {fields.menu.getChangeTwistyPuzzle(), fields.menu.getUserMenu(),
						fields.menu.getChangeScrambleLenght(), fields.menu.getDeleteLastSolve(),
						fields.menu.getNewScramble(), fields.menu.getOptions(), fields.menu.getExit(),
						fields.menu.getQuit()};
		
		Images.drawMenuList(menuItems, fields.windowSize.windowWidth / 16, greenText, fields.windowSize.windowHeight,
				fields.windowSize.windowWidth, 1, g);
		
	}
	
	private void changeTwistyPuzzle(Graphics g){
	
		String[] menuItems =
				new String[] {"2x2x2", "3x3x3", "4x4x4", "5x5x5", "Mega Minx", "Gear Cube", "Anisatropic Gear Cube",
						"One Handed 3x3x3", "Random Twisty Puzzle", "Exit"};
		
		Boolean[] greenText =
				new Boolean[] {fields.menu.twistyPuzzleMenu.get2x2x2(),
						fields.menu.twistyPuzzleMenu.get3x3x3(), fields.menu.twistyPuzzleMenu.get4x4x4(),
						fields.menu.twistyPuzzleMenu.get5x5x5(), fields.menu.twistyPuzzleMenu.getMegaMinx(),
						fields.menu.twistyPuzzleMenu.getGearCube(),
						fields.menu.twistyPuzzleMenu.getAnisatropicGearCube(),
						fields.menu.twistyPuzzleMenu.getOneHanded3x3x3(),
						fields.menu.twistyPuzzleMenu.getRandomTwistyPuzzle(),
						fields.menu.twistyPuzzleMenu.getExit()};
		
		Images.drawMenuList(menuItems, fields.windowSize.windowWidth / 32, greenText, fields.windowSize.windowHeight,
				fields.windowSize.windowWidth, 2, g);
	}
	
	public void userMenu(Graphics g){
	
		String[] menuItems =
				new String[] {"Add User", "Change User", "Delete Current User", "Rename Current User", "Exit"};
		
		Boolean[] greenText =
				new Boolean[] {fields.menu.userActionsMenu.getAddUser(),
						fields.menu.userActionsMenu.getChangeUser(),
						fields.menu.userActionsMenu.getDeleteCurrentUser(),
						fields.menu.userActionsMenu.getRenameCurrentUser(),
						fields.menu.userActionsMenu.getExit()};
		
		Images.drawMenuList(menuItems, fields.windowSize.windowWidth / 32, greenText, fields.windowSize.windowHeight,
				fields.windowSize.windowWidth, 2, g);
	}
	
	public void changeScrambleLenght(Graphics g){
	
		Images.drawBackGround(Color.WHITE, fields.windowSize.windowWidth, fields.windowSize.windowHeight, g);
		
		Images.typeString(Integer.toString(fields.displayedDada.scrambleDada.scrambleLenght),
				fields.windowSize.windowWidth / 2 - 100, fields.windowSize.windowHeight / 2,
				fields.windowSize.windowWidth / 12, true, g);
	}
	
	public void changeUser(Graphics g){
		
		ArrayList<String> arrayListMenuItems = new ArrayList<String>();
		
		for(int i = 0; i < fields.allUsers.getSize(); i++){
			
			arrayListMenuItems.add(fields.allUsers.getUser(i).getUserName());
		}
		
		String[] menuItems = new String[arrayListMenuItems.size()];
		menuItems = (String[]) arrayListMenuItems.toArray(menuItems);
		
		ArrayList<Boolean> arrayListGreenTexts = new ArrayList<Boolean>();
		
		for(int i = 0; i < fields.allUsers.getSize(); i++){
			
			arrayListGreenTexts.add(fields.menu.userActionsMenu.getSelectedUserIndex() == i);
		}
		
		Boolean[] greenTexts = new Boolean[arrayListGreenTexts.size()];
		greenTexts = (Boolean[]) arrayListGreenTexts.toArray(greenTexts);
		
		Images.drawMenuList(menuItems, 32, greenTexts, fields.windowSize.windowHeight, fields.windowSize.windowWidth, 2, g);
	}
	
	public void options(Graphics g){
		
		Images.drawBackGround(Color.WHITE, fields.windowSize.windowWidth, fields.windowSize.windowHeight, g);
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
		
		else if(fields.displayState == DisplayState.changeUser){
			changeUser(g);
		}
		
		else if(fields.displayState == DisplayState.options){
			
		}
		
		else{
			
			timer(g);
		}
	}
}
