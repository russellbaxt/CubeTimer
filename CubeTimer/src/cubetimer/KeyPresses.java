package cubetimer;

public class KeyPresses{
	
	private Timer timer;
	private Scrambler scrambler;
	private TimesTracker timesTracker;
	private Actions actions;
	private Fields fields;
	private Paint paint;
	
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
	private boolean escapePressed;
	
	public KeyPresses(Timer timerIn, Scrambler scramblerIn, TimesTracker timesTrackerIn, Actions actionsIn, Fields fieldsIn, Paint paintIn){
	
		timer = timerIn;
		scrambler = scramblerIn;
		timesTracker = timesTrackerIn;
		actions = actionsIn;
		fields = fieldsIn;
		paint = paintIn;
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
	public void escapePressed(){
		escapePressed = true; 
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
	
		if(spacePressed){
			
			spacePressed = false;
			
			KeyPressActions.spacePressed(fields, timer, timesTracker, scrambler, paint);
		}
		
		if(spaceReleased){
			
			spaceReleased = false;
			
			KeyPressActions.spaceReleased(fields, timer, paint);
		}
		
		if(backSpacePressed){
			
			backSpacePressed = false;
			
			timesTracker.deleteLastSolve();
		}
		
		if(rightPressed){
			
			rightPressed = false;
			
			KeyPressActions.increseScrambleLenghtByOne(fields, scrambler, paint);
		}
		
		if(leftPressed){
			
			leftPressed = false;
			
			KeyPressActions.reduceScrambleLenghtByOne(fields, scrambler, paint);
		}
		
		if(plusPressed){
			
			plusPressed = false;
			
			KeyPressActions.addAUser(fields, paint);
		}
		
		if(dashPressed){
			
			dashPressed = false;
			
			KeyPressActions.changeUser(fields, paint);
			
		}
		
		if(twoPressed){
			
			twoPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube2x2x2, scrambler, timesTracker, paint);
			
		}
		
		if(threePressed){
			
			threePressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube3x3x3, scrambler, timesTracker, paint);
		}
		
		if(fourPressed){
			
			fourPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube4x4x4, scrambler, timesTracker, paint);
		}
		
		if(fivePressed){
			
			fivePressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.cube5x5x5, scrambler, timesTracker, paint);
		}
		
		if(mPressed){
			
			mPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.magaMinx, scrambler, timesTracker, paint);
		}
		
		if(gPressed){
			
			gPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.gearCube, scrambler, timesTracker, paint);
		}
		
		if(aPressed){
			
			aPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.anisatropicGearCube, scrambler, timesTracker, paint);
		}
		
		if(oPressed){
			
			oPressed = false;
			
			KeyPressActions.changeToTwistyPuzzle(fields, TwistyPuzzleType.oneHanded3x3x3, scrambler, timesTracker, paint);
		}
		
		if(rPressed){
			
			rPressed = false;
			
			KeyPressActions.changeToRandomTwistyPuzzleType(fields, scrambler, actions, paint);
		}
		
		if(escapePressed){
			escapePressed = false;
			
			KeyPressActions.openMenu(fields, paint);
		}
		
	}
	
}
