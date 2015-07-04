package cubetimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimesTracker{
	
	private Fields fields;
	
	private AllUsers allUsers;
	private int currentUserNumber;
	
	Scanner userInput;
	
	public TimesTracker(Fields f){
	
		fields = f;
		
		allUsers = new AllUsers();
		allUsers.addUser(new User());
		
		userInput = new Scanner(System.in);
		System.out.println("What is your first Users Name? Make sure you can remember it.");
		String userName = userInput.nextLine();
		allUsers.getUser(0).setUserName(userName);
		currentUserNumber = 0;
		fields.setCurrentUserName(userName);
		
	}
	
	public void addUser(){
	
		// TODO make it not tell the user to remember their user name and not
		// tell the user that they told them to remember their username when
		// they try to change it
		System.out.println("What is your new users name? Make sure to remember it.");
		String userName = userInput.nextLine();
		allUsers.addUser(new User());
		currentUserNumber = allUsers.getSize() - 1;
		allUsers.getUser(currentUserNumber).setUserName(userName);
		fields.setCurrentUserName(userName);
		setLast20SolvesInFieldsUsingFields();
	}
	
	public void changeToUser(){
	
		System.out.println("What is the name of your user? I told you to remember it.");
		String userName = userInput.nextLine();
		
		if(allUsers.getIndexOfUserWithUserName(userName) < 0){
			System.out.println("That user does not exist. You may have typed it wrong. Good luck if you try again.");
		}
		else{
			currentUserNumber = allUsers.getIndexOfUserWithUserName(userName);
			fields.setCurrentUserName(userName);
		}
		
		setLast20SolvesInFieldsUsingFields();
	}
	
	public void addTime(TwistyPuzzleType twistyPuzzleType, double time){
	
		allUsers.getUser(currentUserNumber).getTwistyPuzzle(twistyPuzzleType).addTime(time);
		
		setLast20SolvesInFieldsUsingFields();
		setAvarageOf5InFieldsUsingFields();
		
	}
	
	public void setAvarageOf5InFieldsUsingFields(){
	
		fields.setAvarageOf5(allUsers.getUser(currentUserNumber).getAvarageOf5(fields.getTwistyPuzzleType()));
	}
	
	public void deleteLastSolve(){
	
		allUsers.getUser(currentUserNumber).getTwistyPuzzle(fields.getTwistyPuzzleType()).removeLastElementInTimes();
		
		setLast20SolvesInFieldsUsingFields();
		setAvarageOf5InFieldsUsingFields();
	}
	
	public void setLast20SolvesInFieldsUsingFields(){
	
		fields.setLast20Solves(allUsers.getUser(currentUserNumber).getTwistyPuzzle(fields.getTwistyPuzzleType()).getTimes());
	}
	
	public String getCurrentUserName(){
	
		return allUsers.getUser(currentUserNumber).getUserName();
	}
}
