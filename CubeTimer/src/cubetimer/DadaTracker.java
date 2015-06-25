package cubetimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DadaTracker {
	
	private AllUsers allUsers;
	private int currentUserNumber;
	
	
	private TwistyPuzzleType twistyPuzzleType;
	Scanner userInput;
	
	public DadaTracker(){
		
		allUsers = new AllUsers();
		allUsers.addUser(new User());
		
		

		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
		userInput = new Scanner(System.in);
		System.out.println("What is your first Users Name? Make sure you can remember it.");
		String userName = userInput.nextLine();
		allUsers.getUser(0).setUserName(userName);
		currentUserNumber = 0;
		
	}
	public void addUser(){
		
		System.out.println("What is your new users name? Make sure to remember it.");
		String userName = userInput.nextLine();
		allUsers.addUser(new User());
		currentUserNumber = allUsers.getSize() - 1;
		allUsers.getUser(currentUserNumber).setUserName(userName);
	}
	public void changeToUser(){
		System.out.println("What is the name of your user? I told you to remember it.");
		String userName = userInput.nextLine();
		if(allUsers.getIndexOfUserWithUserName(userName) < 0){
			System.out.println("That user does not exist. You may have typed it wrong. Good luck if you try again.");
		}
		else{
			currentUserNumber = allUsers.getIndexOfUserWithUserName(userName);
		}
	}
	public void addTime(TwistyPuzzleType twistyPuzzleTypeIn, double time){
		
		twistyPuzzleType = twistyPuzzleTypeIn;
		allUsers.getUser(currentUserNumber).getTwistyPuzzle(twistyPuzzleType).addTime(time);
	}
	public String getAvarageOf5(TwistyPuzzleType twistyPuzzleTypeIn){

		twistyPuzzleType = twistyPuzzleTypeIn;
		return allUsers.getUser(currentUserNumber).getAvarageOf5(twistyPuzzleType);
	}
	public void deleteLastSolve(){
		
		allUsers.getUser(currentUserNumber).getTwistyPuzzle(twistyPuzzleType).removeLastElementInTimes();
	}
	public ArrayList getlast20Solves(TwistyPuzzleType twistyPuzzleTypeIn){
		
		twistyPuzzleType = twistyPuzzleTypeIn;
		return allUsers.getUser(currentUserNumber).getTwistyPuzzle(twistyPuzzleType).getTimes();
	}
	public String getCurrentUserName(){
		return allUsers.getUser(currentUserNumber).getUserName();
	}
}
