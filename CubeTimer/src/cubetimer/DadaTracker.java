package cubetimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DadaTracker {
	
	private ArrayList allUsers;
	private ArrayList user1;
	private ArrayList user2;
	private ArrayList user3;
	private ArrayList user4;
	private int userNumber;
	
	private ArrayList cube2x2x2;
	private ArrayList cube3x3x3;
	private ArrayList cube4x4x4;
	private ArrayList cube5x5x5;
	private ArrayList megaMinx;
	private ArrayList curvyCopter;
	private ArrayList voidChalangeCube;
	private ArrayList anisatropicGearCube;
	private ArrayList gearCube;
	private ArrayList oneHanded3x3x3;
	
	private TwistyPuzzleType twistyPuzzleType;
	private boolean consoleNeedsAtention;
	Scanner userInput;
	
	public DadaTracker(){
		
		allUsers = new <ArrayList>ArrayList();
		user1 = new ArrayList();
		user2 = new ArrayList();
		user3 = new ArrayList();
		user4 = new ArrayList();
		
		cube2x2x2 = new <Double>ArrayList();
		cube3x3x3 = new <Double>ArrayList();
		cube4x4x4 = new <Double>ArrayList();
		cube5x5x5 = new <Double>ArrayList();
		megaMinx = new <Double>ArrayList();
		curvyCopter = new <Double>ArrayList();
		voidChalangeCube = new <Double>ArrayList();
		anisatropicGearCube = new <Double>ArrayList();
		gearCube = new <Double>ArrayList();
		oneHanded3x3x3 = new <Double>ArrayList();
		
		
		user1.add("");
		user1.add(cube2x2x2);
		user1.add(cube3x3x3);
		user1.add(cube4x4x4);
		user1.add(cube5x5x5);
		user1.add(megaMinx);
		user1.add(curvyCopter);
		user1.add(voidChalangeCube);
		user1.add(anisatropicGearCube);
		user1.add(gearCube);
		user1.add(oneHanded3x3x3);
		
		user2.add("");
		user2.add(cube2x2x2);
		user2.add(cube3x3x3);
		user2.add(cube4x4x4);
		user2.add(cube5x5x5);
		user2.add(megaMinx);
		user2.add(curvyCopter);
		user2.add(voidChalangeCube);
		user2.add(anisatropicGearCube);
		user2.add(gearCube);
		user2.add(oneHanded3x3x3);
		
		user3.add("");
		user3.add(cube2x2x2);
		user3.add(cube3x3x3);
		user3.add(cube4x4x4);
		user3.add(cube5x5x5);
		user3.add(megaMinx);
		user3.add(curvyCopter);
		user3.add(voidChalangeCube);
		user3.add(anisatropicGearCube);
		user3.add(gearCube);
		user3.add(oneHanded3x3x3);
		
		user4.add("");
		user4.add(cube2x2x2);
		user4.add(cube3x3x3);
		user4.add(cube4x4x4);
		user4.add(cube5x5x5);
		user4.add(megaMinx);
		user4.add(curvyCopter);
		user4.add(voidChalangeCube);
		user4.add(anisatropicGearCube);
		user4.add(gearCube);
		user4.add(oneHanded3x3x3);
		
		allUsers.add(user1);
		allUsers.add(user2);
		allUsers.add(user3);
		allUsers.add(user4);
		
		ArrayList currentUserClone = new ArrayList();
		ArrayList currentUserRemote = new ArrayList();
		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
		userInput = new Scanner(System.in);
		System.out.println("What is your first Users Name? Make sure you can remember it.");
		currentUserRemote = (ArrayList) allUsers.get(0);
		currentUserClone = (ArrayList) currentUserRemote.clone();
		String userName = userInput.nextLine();
		currentUserClone.set(0, userName);
		allUsers.set(0,currentUserClone);
		userNumber = 0;
		
	}
	public void addUser(){
		ArrayList currentUserRemote = new ArrayList();
		System.out.println("What is your new users name?");
		String userName = userInput.nextLine();
		if(((ArrayList) allUsers.get(0)).get(0) == ""){
			currentUserRemote.set(0, userName);
			allUsers.set(1, currentUserRemote);
			userNumber = 0 ;
			System.out.println("You are the 1 user");
		}
		else if(((ArrayList) allUsers.get(1)).get(0) == ""){
			currentUserRemote = (ArrayList) allUsers.get(1);
			currentUserRemote.set(0, userName);
			userNumber = 1;
			System.out.println("You are the 2 user");
		}
		else if(((ArrayList) allUsers.get(2)).get(0) == ""){
			currentUserRemote = (ArrayList) allUsers.get(2);
			currentUserRemote.set(0, userName);
			userNumber = 2;
			System.out.println("You Are the 3 user");
		}
		else if(((ArrayList) allUsers.get(3)).get(0) == ""){
			currentUserRemote = (ArrayList) allUsers.get(3);
			currentUserRemote.set(0, userName);
			userNumber = 3;
			System.out.println("you are teh 4 user");
		}
		else System.out.println("You have too many users already");
	}
	public void changeTooUser(){
		ArrayList currentUserRemote = new ArrayList();
		System.out.println("What is the name of the user you want to swich to? I told you to remember it");
		String userName = userInput.nextLine();
		if(((ArrayList) allUsers.get(0)).get(0) == userName){
			userNumber = 0;
		}
		else if(((ArrayList) allUsers.get(1)).get(0) == userName){
			userNumber = 1;
		}
		else if(((ArrayList) allUsers.get(2)).get(0) == userName){
			userNumber = 2;
		}
		else if(((ArrayList) allUsers.get(3)).get(0) == userName){
			userNumber = 3;
		}
		else{
			System.out.print("That name does not exist. You must of typed it wrong.");
		}
	}
	public void addTime(TwistyPuzzleType twistyPuzzleTypeIn, double time){
		ArrayList currentUserRemote = new ArrayList();
		ArrayList currentArrayListRemote  = new ArrayList();
		ArrayList currentUserClone = new ArrayList();
		twistyPuzzleType = twistyPuzzleTypeIn;
		currentUserRemote = (ArrayList) allUsers.get(userNumber);
		currentUserClone = (ArrayList) currentUserRemote.clone();
		currentArrayListRemote = (ArrayList) currentUserClone.get(twistyPuzzleType.ordinal() + 1);
		currentArrayListRemote.add(time);
		if(currentArrayListRemote.size() > 20){
			currentArrayListRemote.remove(1);
		}
		allUsers.set(userNumber,currentUserClone);
	}
	public String getAvarageOf5(TwistyPuzzleType twistyPuzzleTypeIn){
		ArrayList currentUserClone = new ArrayList();
		ArrayList currentUserRemote = new ArrayList();
		ArrayList currentArrayListRemote = new ArrayList();
		ArrayList currentArrayListClone = new ArrayList();
		currentUserRemote = (ArrayList) allUsers.get(userNumber);
		currentUserClone = (ArrayList) currentUserRemote.clone();
		twistyPuzzleType = twistyPuzzleTypeIn;
		double maximum;
		double minimum;
		double sumForAvarageOf5 = 0;
		double avarageOf5Seconds;
		currentArrayListRemote = (ArrayList) currentUserClone.get(twistyPuzzleType.ordinal() + 1);
		currentArrayListClone = (ArrayList) currentArrayListRemote.clone();
		while(currentArrayListClone.size() > 5){
			currentArrayListClone.remove(0);
		}
		if(currentArrayListClone.size() == 5){
			maximum = (double) currentArrayListClone.get(0);
			for(int i = 1; i<currentArrayListClone.size(); i++){
				if((double)(currentArrayListClone.get(i)) > maximum){
					maximum = (double) currentArrayListClone.get(i);
				}
			}
			currentArrayListClone.remove(maximum);
			minimum = (double) currentArrayListClone.get(0);
			for(int i = 1; i < currentArrayListClone.size(); i++){
				if((double)(currentArrayListClone.get(i)) < minimum){
					minimum = (double) currentArrayListClone.get(i);
				}
			}
			currentArrayListClone.remove(minimum);
			for(int i = 0; i < currentArrayListClone.size(); i++){
				sumForAvarageOf5 = sumForAvarageOf5 + (double) currentArrayListClone.get(i);
			}
			avarageOf5Seconds = sumForAvarageOf5/currentArrayListClone.size();
			int timeMinutes = 0;
			while (avarageOf5Seconds > 60){
				timeMinutes++;
				avarageOf5Seconds = avarageOf5Seconds - 60;
			}
			return timeMinutes + ":" + String.format("%.3f", avarageOf5Seconds);
		}
		else{
			return "no avarage of 5 yet";
		}
	}
	public void deleteLastSolve(){
		ArrayList currentUserClone = new ArrayList();
		ArrayList currentUserRemote = new ArrayList();
		ArrayList currentArrayListRemote = new ArrayList();
		currentUserRemote = (ArrayList) allUsers.get(userNumber);
		currentUserClone = (ArrayList) currentUserRemote.clone();
		currentArrayListRemote = (ArrayList) currentUserClone.get(twistyPuzzleType.ordinal());
		if(!currentArrayListRemote.isEmpty()){
			currentArrayListRemote.remove(currentArrayListRemote.size() - 1);
			currentUserClone.set(twistyPuzzleType.ordinal(), currentArrayListRemote);
		}
	}
	public ArrayList getlast20Solves(TwistyPuzzleType twistyPuzzleTypeIn){
		ArrayList currentUserClone = new ArrayList();
		ArrayList currentUserRemote = new ArrayList();
		System.out.println(userNumber);
		currentUserRemote = (ArrayList) allUsers.get(userNumber);
		currentUserClone = (ArrayList) currentUserRemote.clone();
		System.out.println(currentUserClone.get(0));
//		List<String> last5Solves = new List<String>();
//		currentArrayList = (ArrayList) masterArrayList.get(twistyPuzzleType.ordinal());
//		currentArrayListClone = (ArrayList) currentArrayList.clone();
//		for(int i = 0; i < currentArrayListClone.size(); i++){
//			last5Solves.add(Double.toString((double) currentArrayListClone.get(i)));
//		}
		return (ArrayList) currentUserClone.get(twistyPuzzleTypeIn.ordinal() + 1);
	}
}
