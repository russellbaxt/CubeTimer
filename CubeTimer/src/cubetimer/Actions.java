package cubetimer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Actions{
	
	public static void callUponOpen(Fields fields){
		
		fields.allUsers.addUser(new User());
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is your first Users Name?");
		String userName = userInput.nextLine();
		fields.allUsers.getUser(0).setUserName(userName);
		fields.allUsers.setCurrentUserIndex(0);
	}
	
	public static void addUser(Fields fields, Paint paint){
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("What is your new users name?");
		String userName = userInput.nextLine();
		fields.allUsers.addUser(new User());
		fields.allUsers.setCurrentUserIndex(fields.allUsers.getSize() - 1);
		fields.allUsers.getUser().setUserName(userName);
		setAvarageOf5(fields, paint);
		
		paint.repaint();
	}
	
	public static void changeUser(Fields fields, Paint paint){
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("What is the name of user you would like to swich to?");
		String userName = userInput.nextLine();
		
		if(fields.allUsers.getIndexOfUserWithUserName(userName) < 0){
			System.out.println("That user does not exist. You may have typed it wrong. Good luck if you try again.");
		}
		else{
			fields.allUsers.setCurrentUserUsingUserName(userName);
		}
		
		setAvarageOf5(fields, paint);
		
		paint.repaint();
	}
	
	public static void deleteCurrentUser(Fields fields, Paint paint){
		
		if(fields.allUsers.getSize() > 1){
			
			fields.allUsers.remove();
			KeyPressActions.changeUser(fields, paint);
		}
		
		else{
			
			fields.displayState = DisplayState.timer;
		}
		
	}
	
	public static void renameCurrentUser(Fields fields){
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("What is you users new name?");
		String userName = userInput.nextLine();
		fields.allUsers.getUser().setUserName(userName);
	}
	
	public static void addTime(Fields fields, Paint paint, double time){
		
		if(fields.penalty.DNF){
			fields.allUsers.getUser().getTwistyPuzzle().addTime(0);
		}
		else{
			fields.allUsers.getUser().getTwistyPuzzle().addTime(time + fields.penalty.timePenalty);
			
		}
		setAvarageOf5(fields, paint);
		
	}
	
	public static void deleteLastSolve(Fields fields, Paint paint){
		
		fields.allUsers.getUser().getTwistyPuzzle().removeLastElementInTimes();
		
		setAvarageOf5(fields, paint);
		
		paint.repaint();
	}
	
	public static void setAvarageOf5(Fields fields, Paint paint){
		
		fields.displayedDada.avarageOf5 = fields.allUsers.getUser().getAvarageOf5();
		
		paint.repaint();
	}
	
	public static void randomTwistyPuzzle(Fields fields){
		
		Random random = new Random();
	
		int randomNumber = random.nextInt(TwistyPuzzleType.values().length);
		fields.allUsers.getUser().setTwistyPuzzleType(TwistyPuzzleType.values()[randomNumber]);
		
		if(fields.allUsers.getUser().getTwistyPuzzleType() == TwistyPuzzleType.megaMinx){
			fields.displayedDada.scrambleDada.scrambleLenght = 40;
		}
		else{
			fields.displayedDada.scrambleDada.scrambleLenght = 20;
		}
		
	}
	
	public static void setScrambleInFields(Fields fields, String randomScramble){
		
		if(randomScramble.contains("/n")){
			
			fields.displayedDada.scrambleDada.randomScrambleAfterSplit = randomScramble.split("/n");
			fields.displayedDada.scrambleDada.scrambleSize = fields.displayedDada.scrambleDada.randomScrambleAfterSplit[0].length() / 2.0 + 4.0;
			fields.displayedDada.scrambleDada.useStringListForRandomScramble = true;
		}
		
		else{
			
			fields.displayedDada.scrambleDada.randomScramble = randomScramble;
			fields.displayedDada.scrambleDada.scrambleSize = randomScramble.length() / 2.0 + 4.0;
			fields.displayedDada.scrambleDada.useStringListForRandomScramble = false;
		}
		
		if(fields.displayedDada.scrambleDada.scrambleSize < 4.0){
			fields.displayedDada.scrambleDada.scrambleSize = 4.0;
		}
	}
	
	public static ArrayList <Integer> getDefaultWindowSize(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) ((screenSize.getWidth() * 2) / 3);
		int height = (int) ((screenSize.getHeight() * 2) / 3);
		
		ArrayList <Integer> windowSize = new ArrayList <Integer>();
		windowSize.addAll(Arrays.asList(new Integer[] {width, height}));
		return windowSize;
	}
	
}
