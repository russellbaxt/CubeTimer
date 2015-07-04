package cubetimer;

public class KeyPresses{
	
	private Timer timer;
	private Scrambler scrambler;
	private TimesTracker timesTracker;
	private Actions actions;
	private Fields fields;
	
	private boolean spacePressed;
	private boolean spaceReleased;
	
	private boolean backSpacePressed;
	
	private boolean leftPressed;
	private boolean rightPressed;
	
	private boolean plusPressed;
	private boolean dashPressed;
	
	private boolean twoPressed;
	private boolean threePressed;
	private boolean fourPressed;
	private boolean fivePressed;
	private boolean mPressed;
	private boolean gPressed;
	private boolean aPressed;
	private boolean vPressed;
	private boolean oPressed;
	private boolean rPressed;
	
	public KeyPresses(Timer timerIn, Scrambler scramblerIn, TimesTracker timesTrackerIn, Actions actionsIn, Fields fieldsIn){
	
		timer = timerIn;
		scrambler = scramblerIn;
		timesTracker = timesTrackerIn;
		actions = actionsIn;
		fields = fieldsIn;
	}
	
	public void spacePressed(){
	
		spacePressed = true;
	}
	
	public void spaceReleased(){
	
		spaceReleased = true;
	}
	
	public void threePressed(){
	
		threePressed = true;
	}
	
	public void twoPressed(){
	
		twoPressed = true;
	}
	
	public void fourPressed(){
	
		fourPressed = true;
	}
	
	public void fivePressed(){
	
		fivePressed = true;
	}
	
	public void leftPressed(){
	
		leftPressed = true;
	}
	
	public void rightPressed(){
	
		rightPressed = true;
	}
	
	public void rPressed(){
	
		rPressed = true;
	}
	
	public void mPressed(){
	
		mPressed = true;
	}
	
	public void gPressed(){
	
		gPressed = true;
	}
	
	public void aPressed(){
	
		aPressed = true;
	}
	
	public void oPressed(){
	
		oPressed = true;
	}
	
	public void vPressed(){
	
		vPressed = true;
	}
	
	public void deletePressed(){
	
		backSpacePressed = true;
	}
	
	public void plusPressed(){
	
		plusPressed = true;
	}
	
	public void dashPressed(){
	
		dashPressed = true;
	}
	
	public void setAllKeyPressesToFalse(){
	
		spacePressed = false;
		spaceReleased = false;
		threePressed = false;
		twoPressed = false;
		leftPressed = false;
		rightPressed = false;
		fourPressed = false;
		fivePressed = false;
		rPressed = false;
		mPressed = false;
		gPressed = false;
		aPressed = false;
		vPressed = false;
		oPressed = false;
		backSpacePressed = false;
		plusPressed = false;
		
	}
	
	public void trigerActionsForKeyPresses(){
		
		//TODO sort the following if statements
	
		if(spacePressed){
			
			spacePressed = false;
			
			KeyPressActions.spacePressed(fields, timer, timesTracker, scrambler);
		}
		
		if(spaceReleased){
			
			spaceReleased = false;
			
			KeyPressActions.spaceReleased(fields, timer);
		}
		
		if(threePressed){
			
			threePressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube3x3x3, scrambler, timesTracker);
		}
		
		if(twoPressed){
			
			twoPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube2x2x2, scrambler, timesTracker);
			
		}
		
		if(fourPressed){
			
			fourPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube4x4x4, scrambler, timesTracker);
		}
		
		if(fivePressed){
			
			fivePressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube5x5x5, scrambler, timesTracker);
		}
		
		if(leftPressed){
			
			leftPressed = false;
			
			KeyPressActions.reduceScrambleLenghtByOne(fields, scrambler);
		}
		
		if(rightPressed){
			
			rightPressed = false;
			
			KeyPressActions.increseScrambleLenghtByOne(fields, scrambler);
		}
		
		if(rPressed){
			
			rPressed = false;
			
			KeyPressActions.changeToRandomTwistyPuzzleType(fields, scrambler, actions);
		}
		
		if(mPressed){
			
			mPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.magaMinx, scrambler, timesTracker);
		}
		
		if(gPressed){
			
			gPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.gearCube, scrambler, timesTracker);
		}
		
		if(aPressed){
			
			aPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.anisatropicGearCube, scrambler, timesTracker);
		}
		
		if(oPressed){
			
			oPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.oneHanded3x3x3, scrambler, timesTracker);
		}
		
		if(vPressed){
			
			vPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.voidChalangeCube, scrambler, timesTracker);
		}
		
		if(backSpacePressed){
			
			backSpacePressed = false;
			
			timesTracker.deleteLastSolve();
		}
		
		if(plusPressed){
			
			plusPressed = false;
			
			KeyPressActions.addAUser(fields);
		}
		
		if(dashPressed){
			
			dashPressed = false;
			
			KeyPressActions.changeUser(fields);
			
		}
		
	}
	
}
