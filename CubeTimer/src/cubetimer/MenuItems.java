package cubetimer;

public class MenuItems{
	
	public UserActionsMenu userActionsMenu;
	public TwistyPuzzleMenu twistyPuzzleMenu;
	public OptionsMenu optionsMenu;
	
	private boolean changeTwistyPuzzle;
	private boolean userMenu;
	private boolean changeScrambleLenght;
	private boolean newScramble;
	private boolean options;
	
	private boolean exit;
	
	public MenuItems(){
	
		userActionsMenu = new UserActionsMenu();
		twistyPuzzleMenu = new TwistyPuzzleMenu();
		optionsMenu = new OptionsMenu();
		
		changeTwistyPuzzle = true;
		userMenu = false;
		changeScrambleLenght = false;
		newScramble = false;
		options = false;
		exit = false;
	}
	
	private void allFalse(){
	
		changeTwistyPuzzle = false;
		userMenu = false;
		changeScrambleLenght = false;
		newScramble = false;
		options = false;
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
			newScramble = true;
		}
		
		else if(newScramble){
			allFalse();
			options = true;
		}
		
		else if(options){
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
		
		else if(newScramble){
			allFalse();
			changeScrambleLenght = true;
		}
		
		else if(options){
			allFalse();
			newScramble = true;
		}
	
		else{
			allFalse();
			options = true;
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
	
	public boolean getNewScramble(){
	
		return newScramble;
	}
	
	public boolean getOptions(){
	
		return options;
	}
	
	public boolean getExit(){
	
		return exit;
	}
	
}
