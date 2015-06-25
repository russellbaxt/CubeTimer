package cubetimer;

import java.util.ArrayList;

public class User {
	private String userName;
	private TwistyPuzzle cube2x2x2;
	private TwistyPuzzle cube3x3x3;
	private TwistyPuzzle cube4x4x4;
	private TwistyPuzzle cube5x5x5;
	private TwistyPuzzle megaMinx;
	private TwistyPuzzle curvyCopter;
	private TwistyPuzzle voidChalangeCube;
	private TwistyPuzzle oneHanded3x3x3;
	private TwistyPuzzle anisatropicGearCube;
	private TwistyPuzzle gearCube;
	private ArrayList<Double> copyOfAllTimesOfATwistyPuzzle;
	
	public User(){
		userName = "";
		cube2x2x2 = new TwistyPuzzle(TwistyPuzzleType.cube2x2x2);
		cube3x3x3 = new TwistyPuzzle(TwistyPuzzleType.cube3x3x3);
		cube4x4x4 = new TwistyPuzzle(TwistyPuzzleType.cube4x4x4);
		cube5x5x5 = new TwistyPuzzle(TwistyPuzzleType.cube5x5x5);
		megaMinx = new TwistyPuzzle(TwistyPuzzleType.magaMinx);
		curvyCopter = new TwistyPuzzle(TwistyPuzzleType.curvyCopter);
		anisatropicGearCube = new TwistyPuzzle(TwistyPuzzleType.anisatropicGearCube);
		gearCube = new TwistyPuzzle(TwistyPuzzleType.gearCube);
		voidChalangeCube = new TwistyPuzzle(TwistyPuzzleType.voidChalangeCube);
		oneHanded3x3x3 = new TwistyPuzzle(TwistyPuzzleType.oneHanded3x3x3);
	}
	
	public void setUserName(String userIn){
		userName = userIn;
	}
	public String getUserName(){
		return userName;
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
		else if(twistyPuzzleType == voidChalangeCube.getTwistyPuzzleType()){
			return cube4x4x4;
		}
		else if(twistyPuzzleType == oneHanded3x3x3.getTwistyPuzzleType()){
			return cube4x4x4;
		}
		else{
			System.out.println("error becouse you did not send in a correct twistyPuzzleType");
			return cube3x3x3;
		}
		
	}
	public String getAvarageOf5(TwistyPuzzleType twistyPuzzleType){
		copyOfAllTimesOfATwistyPuzzle = getTwistyPuzzle(twistyPuzzleType).getCloneOfTimes();
		
		double minimum;
		double maximum;
		double sumForAvarageOf5 = 0;
		double avarageOf5Seconds;
		
		while(copyOfAllTimesOfATwistyPuzzle.size() > 5){
			copyOfAllTimesOfATwistyPuzzle.remove(0);
		}
		
		if(copyOfAllTimesOfATwistyPuzzle.size() == 5){
			
			maximum = copyOfAllTimesOfATwistyPuzzle.get(0);
			for(int i = 1; i < copyOfAllTimesOfATwistyPuzzle.size(); i++){
				if(maximum < copyOfAllTimesOfATwistyPuzzle.get(i)){
					maximum = copyOfAllTimesOfATwistyPuzzle.get(i);
				}
			}
			copyOfAllTimesOfATwistyPuzzle.remove(maximum);
			
			minimum = copyOfAllTimesOfATwistyPuzzle.get(0);
			for(int i = 1; i < copyOfAllTimesOfATwistyPuzzle.size(); i++){
				if(minimum > copyOfAllTimesOfATwistyPuzzle.get(i)){
					minimum = copyOfAllTimesOfATwistyPuzzle.get(i);
				}
			}
			copyOfAllTimesOfATwistyPuzzle.remove(maximum);
			
			for(int i = 0; i < copyOfAllTimesOfATwistyPuzzle.size(); i++){
				sumForAvarageOf5 = sumForAvarageOf5 + copyOfAllTimesOfATwistyPuzzle.get(i);
			}
			
			avarageOf5Seconds = sumForAvarageOf5/copyOfAllTimesOfATwistyPuzzle.size();
			
			int timeMinutes = 0;
			while (avarageOf5Seconds > 60){
				timeMinutes++;
				avarageOf5Seconds = avarageOf5Seconds - 60;
			}
			return timeMinutes + ":" + String.format("%.3f", avarageOf5Seconds);
		}
		else{
			return "No Avarage Of 5 Yet";
		}
	}
}
