package cubetimer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.Timer;

import fields.DisplayState;
import fields.Fields;
import fields.TwistyPuzzleType;
import savedData.User;
import swingTimerActions.ChangeUser;

public class Actions {

	public static void callUponOpen(Fields fields) {

		fields.getAllUsers().addUser(new User());

		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is your first Users Name?");
		String userName = userInput.nextLine();
		fields.getAllUsers().getUser(0).setUserName(userName);
		fields.getAllUsers().setCurrentUserIndex(0);
		fields.changeSinceLastRepaint();
	}

	public static void addUser(Fields fields, Paint paint) {

		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);

		System.out.println("What is your new users name?");
		String userName = userInput.nextLine();
		fields.getAllUsers().addUser(new User());
		fields.getAllUsers().setCurrentUserIndex(fields.getAllUsers().getSize() - 1);
		fields.getAllUsers().getUser().setUserName(userName);
		fields.setDisplayState(DisplayState.timer);
		fields.getAllUsers().getUser().getTwistyPuzzle().setLastAvarageOf5();
		fields.changeSinceLastRepaint();

		paint.repaint();
	}

	public static void changeUser(Fields fields, Paint paint) {

		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);

		System.out
				.println("What is the name of user you would like to swich to?");
		String userName = userInput.nextLine();

		if (fields.getAllUsers().getIndexOfUserWithUserName(userName) < 0) {
			System.out
					.println("That user does not exist. You may have typed it wrong. Good luck if you try again.");
		} else {
			fields.getAllUsers().setCurrentUserUsingUserName(userName);
		}

		fields.getAllUsers().getUser().getTwistyPuzzle().setLastAvarageOf5();
		fields.changeSinceLastRepaint();

		paint.repaint();
	}

	public static void deleteCurrentUser(Fields fields, Paint paint) {

		if (fields.getAllUsers().getSize() > 1) {

			fields.getAllUsers().remove();
			fields.changeSinceLastRepaint();

			paint.repaint();

			Timer changeUser = new Timer(0, new ChangeUser(fields));
			changeUser.setRepeats(false);

			fields.setDisplayState(DisplayState.changeUser);
		}

		else {

			fields.setDisplayState(DisplayState.timer);
			fields.changeSinceLastRepaint();
			
			paint.repaint();
		}

	}

	public static void renameCurrentUser(Fields fields, Paint paint) {

		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);

		System.out.println("What is you users new name?");
		String userName = userInput.nextLine();
		fields.getAllUsers().getUser().setUserName(userName);
		fields.setDisplayState(DisplayState.timer);
		fields.changeSinceLastRepaint();

		paint.repaint();
	}

	public static void randomTwistyPuzzle(Fields fields) {

		Random random = new Random();

		int randomNumber = random.nextInt(TwistyPuzzleType.values().length);
		fields.getAllUsers().getUser().setTwistyPuzzleType(
				TwistyPuzzleType.values()[randomNumber]);

		if (fields.getAllUsers().getUser().getTwistyPuzzleType() == TwistyPuzzleType.megaMinx) {
			fields.getDisplayedData().getScrambleData().setScrambleLenght(40);
		} else {
			fields.getDisplayedData().getScrambleData().setScrambleLenght(20);
		}
		
		fields.changeSinceLastRepaint();

	}

	public static void
			setScrambleInFields(Fields fields, String randomScramble) {

		if (randomScramble.contains("/n")) {

			fields.getDisplayedData().getScrambleData().setRandomScrambleAfterSplit(randomScramble.split("/n"));
			fields.getDisplayedData().getScrambleData().setScrambleSize(fields.getDisplayedData().getScrambleData().getRandomScrambleAfterSplit()[0]
					.length() / 2.0 + 4.0);
			fields.getDisplayedData().getScrambleData().setUseStringListForRandomScramble(true);
		}

		else {

			fields.getDisplayedData().getScrambleData().setRandomScramble(randomScramble);
			fields.getDisplayedData().getScrambleData().setScrambleSize(randomScramble.length() / 2.0 + 4.0);
			fields.getDisplayedData().getScrambleData().setUseStringListForRandomScramble(false);
		}

		if (fields.getDisplayedData().getScrambleData().getScrambleSize() < 4.0) {
			fields.getDisplayedData().getScrambleData().setScrambleSize(4.0);
		}
		
		fields.changeSinceLastRepaint();
	}

	public static ArrayList<Integer> getDefaultWindowSize() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) ((screenSize.getWidth() * 2) / 3);
		int height = (int) ((screenSize.getHeight() * 2) / 3);

		ArrayList<Integer> windowSize = new ArrayList<Integer>();
		windowSize.addAll(Arrays.asList(new Integer[] { width, height }));
		return windowSize;
	}

}
