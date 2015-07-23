package cubetimer;

public class Fields{
	
	public DisplayedDada displayedDada;
	public TimerStatus timerStatus;
	public WindowSize windowSize;
	public Penalty penalty;
	
	public boolean close;
	
	public MenuItems menuItems;

	public TwistyPuzzleType twistyPuzzleType;
	public DisplayState displayState;
	public UserAction userAction;

	public boolean greenText;

	public boolean ignoreNextRelese;

	public boolean paintComponentDone;

	public Fields() {
		
		displayedDada = new DisplayedDada();
		timerStatus = new TimerStatus();
		windowSize = new WindowSize();
		penalty = new Penalty();
		
		menuItems = new MenuItems();
		
		paintComponentDone = false;

		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
		displayState = DisplayState.timer;
	}

	public void setScreenSize(int windowWidth, int windowHeight) {

		windowSize.setSize(windowWidth, windowHeight);
	}
}