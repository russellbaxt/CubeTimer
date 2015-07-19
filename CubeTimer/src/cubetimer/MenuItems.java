package cubetimer;

public class MenuItems{
	
	public UserActionsMenu userActionsMenu;
	public TwistyPuzzleMenu twistyPuzzleMenu;
	
	private boolean changeTwistyPuzzle;
	private boolean userMenu;
	private boolean changeScrambleLenght;
	
	private boolean exit;
	
	public MenuItems(){
		
		userActionsMenu = new UserActionsMenu();
		twistyPuzzleMenu = new TwistyPuzzleMenu();
	
		changeTwistyPuzzle = true;
		userMenu = false;
		changeScrambleLenght = false;
		exit = false;
	}
	
	private void allFalse(){
	
		changeTwistyPuzzle = false;
		userMenu = false;
		changeScrambleLenght = false;
		exit = false;
	}
	
	public void resetChoice(){
	
		changeTwistyPuzzle = true;
		userMenu = false;
		changeScrambleLenght = false;
		exit = false;
	}
	
	public void downOne(){
	
		if(changeTwistyPuzzle){
			allFalse();
			userMenu = true;
		}
		else if(userMenu){
			allFalse();
			changeScrambleLenght = true;
		}
		else if(changeScrambleLenght){
			allFalse();
			exit = true;
		}
		else{
			allFalse();
			changeTwistyPuzzle = true;
		}
	}
	
	public void upOne(){
	
		if(changeTwistyPuzzle){
			allFalse();
			exit = true;
		}
		else if(userMenu){
			allFalse();
			changeTwistyPuzzle = true;
		}
		else if(changeScrambleLenght){
			allFalse();
			userMenu = true;
		}
		else{
			allFalse();
			changeScrambleLenght = true;
		}
	}
	
	public boolean getChangeTwistyPuzzle(){
	
		return changeTwistyPuzzle;
	}
	
	public boolean getUserMenu(){
	
		return userMenu;
	}
	
	public boolean getChangeScrambleLenght(){
	
		return changeScrambleLenght;
	}
	
	public boolean getExit(){
	
		return exit;
	}
	
}
