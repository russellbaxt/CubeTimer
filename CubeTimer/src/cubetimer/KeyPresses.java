package cubetimer;

public class KeyPresses{
	
	private Timer timer;
	private Scrambler scrambler;
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
	private boolean oPressed;
	private boolean rPressed;
	
	private boolean escapePressed;
	private boolean enterPressed;
	private boolean upPressed;
	private boolean downPressed;
	
	public KeyPresses(Timer timerIn, Scrambler scramblerIn, Actions actionsIn, Fields fieldsIn, Paint paintIn){
	
		timer = timerIn;
		scrambler = scramblerIn;
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
	
	public void enterPressed(){
		enterPressed = true;
	}
	
	public void upPressed(){
		upPressed = true;
	}
	
	public void downPressed(){
		downPressed = true;
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
		oPressed = false;
		backSpacePressed = false;
		plusPressed = false;
		
	}
	
	public void trigerActionsForKeyPresses(){
	
		if(spacePressed){
			
			spacePressed = false;
			
			KeyPressActions.spacePressed(fields, timer, scrambler, paint);
		}
		
		if(spaceReleased){
			
			spaceReleased = false;
			
			KeyPressActions.spaceReleased(fields, timer, paint);
		}
		
		if(backSpacePressed){
			
			backSpacePressed = false;
			
			Actions.deleteLastSolve(fields, paint);
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
		
			
		if(escapePressed){
			escapePressed = false;
			
			KeyPressActions.openMenu(fields, paint);
		}
		
		if(enterPressed){
			enterPressed = false;
			
			KeyPressActions.select(fields, paint, scrambler, actions);
		}
		
		if(upPressed){
			upPressed = false;
			
			KeyPressActions.upOne(fields, paint);
		}
		
		if(downPressed){
			downPressed = false;
			
			KeyPressActions.downOne(fields, paint);
		}
		
	}
	
}
