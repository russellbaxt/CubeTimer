package cubetimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimesTracker{
	
	private Fields fields;
	private Paint paint;
	
	private AllUsers allUsers;
	private int currentUserNumber;
	
	Scanner userInput;
	
	public TimesTracker(Fields f, Paint p){
	
		fields = f;
		paint = p;
		
		allUsers = new AllUsers();
		allUsers.addUser(new User());
		
		userInput = new Scanner(System.in);
		System.out.println("What is your first Users Name?");
		String userName = userInput.nextLine();
		allUsers.getUser(0).setUserName(userName);
		currentUserNumber = 0;
		fields.currentUserName = userName;
		addTime(fields.twistyPuzzleType, 0);
		deleteLastSolve();
		
	}
	
	public void addUser(){
	
		System.out.println("What is your new users name?");
		String userName = userInput.nextLine();
		allUsers.addUser(new User());
		currentUserNumber = allUsers.getSize() - 1;
		allUsers.getUser(currentUserNumber).setUserName(userName);
		fields.currentUserName = userName;
		setLast20SolvesInFieldsUsingFields();
		
		paint.repaint();
	}
	
	public void changeToUser(){
	
		System.out.println("What is the name of your user?");
		String userName = userInput.nextLine();
		
		if(allUsers.getIndexOfUserWithUserName(userName) < 0){
			System.out.println("That user does not exist. You may have typed it wrong. Good luck if you try again.");
		}
		else{
			currentUserNumber = allUsers.getIndexOfUserWithUserName(userName);
			fields.currentUserName = userName;
		}
		
		setLast20SolvesInFieldsUsingFields();
		setAvarageOf5InFieldsUsingFields();
		
		paint.repaint();
	}
	
	public void addTime(TwistyPuzzleType twistyPuzzleType, double time){
	
		if(fields.DNF){
			allUsers.getUser(currentUserNumber).getTwistyPuzzle(twistyPuzzleType).addTime(0);
		}
		else{
			allUsers.getUser(currentUserNumber).getTwistyPuzzle(twistyPuzzleType).addTime(time + fields.timePenalty);
			
			setLast20SolvesInFieldsUsingFields();
			setAvarageOf5InFieldsUsingFields();
		}
		
		paint.repaint();
		
	}
	
	public void setAvarageOf5InFieldsUsingFields(){
	
		fields.avarageOf5 = allUsers.getUser(currentUserNumber).getAvarageOf5(fields.twistyPuzzleType);
		
		paint.repaint();
	}
	
	public void deleteLastSolve(){
	
		allUsers.getUser(currentUserNumber).getTwistyPuzzle(fields.twistyPuzzleType).removeLastElementInTimes();
		
		setLast20SolvesInFieldsUsingFields();
		setAvarageOf5InFieldsUsingFields();
		
		paint.repaint();
	}
	
	public void setLast20SolvesInFieldsUsingFields(){
	
		fields.last20Solves = allUsers.getUser(currentUserNumber).getTwistyPuzzle(fields.twistyPuzzleType).getTimes();
		
		paint.repaint();
	}
	
	public String getCurrentUserName(){
	
		return allUsers.getUser(currentUserNumber).getUserName();
	}
}
