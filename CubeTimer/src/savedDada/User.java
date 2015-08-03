package savedDada;

import java.util.ArrayList;

import fields.TwistyPuzzleType;

public class User{
	
	private String userName;
	
	private ArrayList<Double> last5SolvesForAvarageOf5;
	
	private TwistyPuzzleType currentTwistyPuzzleType;
	
	private TwistyPuzzle cube2x2x2;
	private TwistyPuzzle cube3x3x3;
	private TwistyPuzzle cube4x4x4;
	private TwistyPuzzle cube5x5x5;
	private TwistyPuzzle megaMinx;
	private TwistyPuzzle curvyCopter;
	private TwistyPuzzle oneHanded3x3x3;
	private TwistyPuzzle anisatropicGearCube;
	private TwistyPuzzle gearCube;
	
	public User(){
	
		userName = "";
		
		currentTwistyPuzzleType = TwistyPuzzleType.cube3x3x3;
		
		cube2x2x2 = new TwistyPuzzle(TwistyPuzzleType.cube2x2x2);
		cube3x3x3 = new TwistyPuzzle(TwistyPuzzleType.cube3x3x3);
		cube4x4x4 = new TwistyPuzzle(TwistyPuzzleType.cube4x4x4);
		cube5x5x5 = new TwistyPuzzle(TwistyPuzzleType.cube5x5x5);
		megaMinx = new TwistyPuzzle(TwistyPuzzleType.megaMinx);
		curvyCopter = new TwistyPuzzle(TwistyPuzzleType.curvyCopter);
		anisatropicGearCube = new TwistyPuzzle(TwistyPuzzleType.anisatropicGearCube);
		gearCube = new TwistyPuzzle(TwistyPuzzleType.gearCube);
		oneHanded3x3x3 = new TwistyPuzzle(TwistyPuzzleType.oneHanded3x3x3);
	}
	
	public void setUserName(String userIn){
	
		userName = userIn;
	}
	
	public String getUserName(){
	
		return userName;
	}
	
	public void setTwistyPuzzleType(TwistyPuzzleType twistyPuzzleType){
		currentTwistyPuzzleType = twistyPuzzleType;
	}
	
	public TwistyPuzzleType getTwistyPuzzleType(){
	
		return currentTwistyPuzzleType;
	}
	
	public TwistyPuzzle getTwistyPuzzle(TwistyPuzzleType twistyPuzzleType){
	
		if(twistyPuzzleType == cube2x2x2.getTwistyPuzzleType()){
			return cube2x2x2;
		}
		else if(twistyPuzzleType == cube3x3x3.getTwistyPuzzleType()){
			return cube3x3x3;
		}
		else if(twistyPuzzleType == cube4x4x4.getTwistyPuzzleType()){
			return cube4x4x4;
		}
		else if(twistyPuzzleType == cube5x5x5.getTwistyPuzzleType()){
			return cube5x5x5;
		}
		else if(twistyPuzzleType == megaMinx.getTwistyPuzzleType()){
			return megaMinx;
		}
		else if(twistyPuzzleType == curvyCopter.getTwistyPuzzleType()){
			return curvyCopter;
		}
		else if(twistyPuzzleType == anisatropicGearCube.getTwistyPuzzleType()){
			return anisatropicGearCube;
		}
		else if(twistyPuzzleType == gearCube.getTwistyPuzzleType()){
			return gearCube;
		}
		else if(twistyPuzzleType == oneHanded3x3x3.getTwistyPuzzleType()){
			return oneHanded3x3x3;
		}
		else{
			System.out.println("error becouse you did not send in a correct twistyPuzzleType");
			return cube3x3x3;
		}
		
	}
	
	public TwistyPuzzle getTwistyPuzzle(){
	
		return getTwistyPuzzle(currentTwistyPuzzleType);
	}
	
	public String getAvarageOf5(){
	
		last5SolvesForAvarageOf5 = getTwistyPuzzle().getLast5Times();
		
		double minimum;
		double maximum;
		double sumForAvarageOf5 = 0.0;
		double avarageOf5Seconds;
		
		if(last5SolvesForAvarageOf5.size() > 0){
			
			if(last5SolvesForAvarageOf5.contains(0.0)){
				maximum = 0.0;
			}
			
			else{
				
				maximum = last5SolvesForAvarageOf5.get(0);
				
				for(int i = 1; i < last5SolvesForAvarageOf5.size(); i ++){
					if(maximum < last5SolvesForAvarageOf5.get(i)){
						maximum = last5SolvesForAvarageOf5.get(i);
					}
				}
			}
			
			last5SolvesForAvarageOf5.remove(maximum);
			
			if(last5SolvesForAvarageOf5.contains(0.0)){
				return "DNF";
			}
			
			minimum = last5SolvesForAvarageOf5.get(0);
			
			for(int i = 1; i < last5SolvesForAvarageOf5.size(); i ++){
				
				if(minimum > last5SolvesForAvarageOf5.get(i)){
					minimum = last5SolvesForAvarageOf5.get(i);
				}
			}
			last5SolvesForAvarageOf5.remove(minimum);
			
			for(int i = 0; i < last5SolvesForAvarageOf5.size(); i ++){
				sumForAvarageOf5 = sumForAvarageOf5 + last5SolvesForAvarageOf5.get(i);
			}
			
			avarageOf5Seconds = sumForAvarageOf5 / 3;
			
			int timeMinutes = 0;
			
			while(avarageOf5Seconds > 60){
				
				timeMinutes ++;
				avarageOf5Seconds = avarageOf5Seconds - 60;
			}
			return timeMinutes + ":" + String.format("%.2f", avarageOf5Seconds);
		}
		else{
			return "No Avarage Of 5 Yet";
		}
	}
	
}
