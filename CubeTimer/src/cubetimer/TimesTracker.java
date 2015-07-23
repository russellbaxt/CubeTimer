package cubetimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimesTracker{
	
	private Fields fields;
	private Paint paint;
	
	Scanner userInput;
	
	public TimesTracker(Fields f, Paint p){
	
		fields = f;
		paint = p;
		
		fields.allUsers.addUser(new User());
		
		userInput = new Scanner(System.in);
		System.out.println("What is your first Users Name?");
		String userName = userInput.nextLine();
		fields.allUsers.getUser(0).setUserName(userName);
		fields.allUsers.setCurrentUserIndex(0);
		
	}
	
	public void addUser(){
	
		System.out.println("What is your new users name?");
		String userName = userInput.nextLine();
		fields.allUsers.addUser(new User());
		fields.allUsers.setCurrentUserIndex(fields.allUsers.getSize() - 1);
		fields.allUsers.getUser().setUserName(userName);
		setLast20SolvesInFieldsUsingFields();
		setAvarageOf5InFieldsUsingFields();
		
		paint.repaint();
	}
	
	public void changeToUser(){
	
		System.out.println("What is the name of user you would like to swich to?");
		String userName = userInput.nextLine();
		
		if(fields.allUsers.getIndexOfUserWithUserName(userName) < 0){
			System.out.println("That user does not exist. You may have typed it wrong. Good luck if you try again.");
		}
		else{
			fields.allUsers.setCurrentUserIndex(fields.allUsers.getIndexOfUserWithUserName(userName));
			//TODO made a method in all users that will set the current user index using a user name
		}
		
		setLast20SolvesInFieldsUsingFields();
		setAvarageOf5InFieldsUsingFields();
		
		paint.repaint();
	}
	
	public void deleteCurrentUser(){
	
		if(fields.allUsers.getSize() > 1){
			
			fields.allUsers.remove();
			KeyPressActions.changeUser(fields, paint);
		}
		
		else{
			
			fields.displayState = DisplayState.timer;
		}
		
	}
	
	public void changeCurrentUserName(){
	
		System.out.println("What is you users new name?");
		String userName = userInput.nextLine();
		fields.allUsers.getUser().setUserName(userName);
	}
	
	public void addTime(double time){
	
		if(fields.penalty.DNF){
			fields.allUsers.getUser().getTwistyPuzzle().addTime(0);
		}
		else{
			fields.allUsers.getUser().getTwistyPuzzle().addTime(time + fields.penalty.timePenalty);
			
		}
		setLast20SolvesInFieldsUsingFields();
		setAvarageOf5InFieldsUsingFields();
		
	}
	
	public void setAvarageOf5InFieldsUsingFields(){
	
		fields.displayedDada.avarageOf5 = fields.allUsers.getUser().getAvarageOf5();
		
		paint.repaint();
	}
	
	public void deleteLastSolve(){
	
		fields.allUsers.getUser().getTwistyPuzzle().removeLastElementInTimes();
		
		setLast20SolvesInFieldsUsingFields();
		setAvarageOf5InFieldsUsingFields();
		
		paint.repaint();
	}
	
	public void setLast20SolvesInFieldsUsingFields(){
	
		paint.repaint();
	}
	
	public String getCurrentUserName(){
	
		return fields.allUsers.getUser().getUserName();
	}
}
