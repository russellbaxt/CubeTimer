package menus;


public class Menu{
	
	public UserActionsMenu userActionsMenu;
	public TwistyPuzzleMenu twistyPuzzleMenu;
	public OptionsMenu optionsMenu;
	
	private boolean changeTwistyPuzzle;
	private boolean userMenu;
	private boolean changeScrambleLength;
	private boolean deleteLastSolve;
	private boolean newScramble;
	private boolean timeMenu;
	private boolean options;
	private boolean exit;
	private boolean quit;
	
	public Menu(){
	
		userActionsMenu = new UserActionsMenu();
		twistyPuzzleMenu = new TwistyPuzzleMenu();
		optionsMenu = new OptionsMenu();
		
		changeTwistyPuzzle = true;
		userMenu = false;
		changeScrambleLength = false;
		deleteLastSolve = false;
		newScramble = false;
		timeMenu = false;
		options = false;
		exit = false;
		quit = false;
	}
	
	private void allFalse(){
	
		changeTwistyPuzzle = false;
		userMenu = false;
		changeScrambleLength = false;
		newScramble = false;
		timeMenu = false;
		options = false;
		exit = false;
		quit = false;
	}
	
	public void downOne(){
	
		if(changeTwistyPuzzle){
			changeTwistyPuzzle = false;
			userMenu = true;
		}
		
		else if(userMenu){
			userMenu = false;
			changeScrambleLength = true;
		}
		
		else if(changeScrambleLength){
			changeScrambleLength = false;
			deleteLastSolve = true;
		}
		
		else if(deleteLastSolve){
			deleteLastSolve = false;
			newScramble = true;
		}
		
		else if(newScramble){
			newScramble = false;
			timeMenu = true;
		}
		
		else if(timeMenu){
			timeMenu = false;
			options = true;
		}
		
		else if(options){
			options = false;
			exit = true;
		}
		
		else if(exit){
			exit = false;
			quit = true;
		}
		
		else{
			allFalse();
			changeTwistyPuzzle = true;
		}
	}
	
	public void upOne(){
	
		if(changeTwistyPuzzle){
			changeTwistyPuzzle = false;
			quit = true;
		}
		
		else if(userMenu){
			userMenu = false;
			changeTwistyPuzzle = true;
		}
		
		else if(changeScrambleLength){
			changeScrambleLength = false;
			userMenu = true;
		}
		
		else if(deleteLastSolve){
			deleteLastSolve = false;
			changeScrambleLength = true;
		}
		
		else if(newScramble){
			newScramble = false;
			deleteLastSolve = true;
		}
		
		else if(timeMenu){
			timeMenu = false;
			newScramble = true;
		}
		
		else if(options){
			options = false;
			timeMenu = true;
		}
	
		else if(exit){
			exit = false;
			options = true;
		}
		
		else{
			allFalse();
			exit = true;
		}
	}
	
	public boolean getChangeTwistyPuzzle(){
	
		return changeTwistyPuzzle;
	}
	
	public boolean getUserMenu(){
	
		return userMenu;
	}
	
	public boolean getChangeScrambleLenght(){
	
		return changeScrambleLength;
	}
	
	public boolean getDeleteLastSolve(){
		
		return deleteLastSolve;
	}
	
	public boolean getNewScramble(){
	
		return newScramble;
	}
	
	public boolean getTimeMenu(){
		
		return timeMenu;
	}
	
	public boolean getOptions(){
	
		return options;
	}
	
	public boolean getExit(){
	
		return exit;
	}
	
	public boolean getQuit(){
		
		return quit;
	}
	
}
