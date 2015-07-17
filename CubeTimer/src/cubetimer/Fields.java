package cubetimer;

public class Fields{
	
	public DisplayedDada displayedDada;
	public TimerStatus timerStatus;
	public WindowSize windowSize;
	public Penalty penalty;
	
	public MenuItems menuItems;
	public UserActionsMenu userActionsMenu;
	public TwistyPuzzleMenu twistyPuzzleMenu;

	public TwistyPuzzleType twistyPuzzleType;
	public DisplayState displayState;

	public boolean greenText;

	public boolean ignoreNextRelese;

	public boolean consoleRequiresAtention;
	public boolean addNotChangeUser;
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