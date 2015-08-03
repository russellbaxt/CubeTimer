package fields;

import menus.Menu;
import savedDada.AllUsers;

public class Fields{
	
	public DisplayedDada displayedDada;
	public TimerStatus timerStatus;
	public WindowSize windowSize;
	public Penalty penalty;
	
	public boolean close;
	
	public Menu menu;

	public DisplayState displayState;
	public UserAction userAction;

	public boolean greenText;

	public boolean ignoreNextRelese;

	public boolean paintComponentDone;
	
	public AllUsers allUsers;

	public Fields() {
		
		displayedDada = new DisplayedDada();
		timerStatus = new TimerStatus();
		windowSize = new WindowSize();
		penalty = new Penalty();
		allUsers = new AllUsers();
		
		menu = new Menu();
		
		paintComponentDone = false;

		displayState = DisplayState.timer;
	}

	public void setScreenSize(int windowWidth, int windowHeight) {

		windowSize.setSize(windowWidth, windowHeight);
	}
}