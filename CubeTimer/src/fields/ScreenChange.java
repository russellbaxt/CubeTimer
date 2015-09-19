package fields;

public class ScreenChange{
	
	private boolean screenChange;

	public ScreenChange(){

	}

	public boolean getScreenChange(){
		
		return screenChange;
	}

	public void screenChange(){
	
		screenChange = true;
	}

	public void noScreenChange(){

		screenChange = false;
	}
}
