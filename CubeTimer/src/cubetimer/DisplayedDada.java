package cubetimer;

import java.util.ArrayList;


public class DisplayedDada{
	
	public ScrambleDada scrambleDada;
	public String time;
	public ArrayList<Double> last20Solves;
	public String currentUserName;
	public String avarageOf5;
	
	public DisplayedDada(){
		
		scrambleDada = new ScrambleDada();
		time = "0:0.0";
		last20Solves = new ArrayList<Double>();
		avarageOf5 = "No Avarage Of 5 Yet";
	}
}
