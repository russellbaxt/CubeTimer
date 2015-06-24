package cubetimer;

import java.util.ArrayList;
import java.util.List;

public class DadaTracker {
	ArrayList masterArrayList;
	ArrayList cube2x2x2;
	ArrayList cube3x3x3;
	ArrayList cube4x4x4;
	ArrayList cube5x5x5;
	ArrayList megaMinx;
	ArrayList curvyCopter;
	ArrayList voidChalangeCube;
	ArrayList anisatropicGearCube;
	ArrayList gearCube;
	ArrayList oneHanded3x3x3;
	ArrayList currentArrayList;
	ArrayList currentArrayListClone;
	TwistyPuzzleType twistyPuzzleType;
	public DadaTracker(){
		masterArrayList = new <ArrayList>ArrayList();
		cube2x2x2 = new <Double>ArrayList();
		cube3x3x3 = new <Double>ArrayList();
		cube4x4x4 = new <Double>ArrayList();
		cube5x5x5 = new <Double>ArrayList();
		megaMinx = new <Double>ArrayList();
		curvyCopter = new <Double>ArrayList();
		voidChalangeCube = new <Double>ArrayList();
		anisatropicGearCube = new <Double>ArrayList();
		gearCube = new <Double>ArrayList();
		oneHanded3x3x3 = new <Double>ArrayList();
		masterArrayList.add(cube2x2x2);
		masterArrayList.add(cube3x3x3);
		masterArrayList.add(cube4x4x4);
		masterArrayList.add(cube5x5x5);
		masterArrayList.add(megaMinx);
		masterArrayList.add(curvyCopter);
		masterArrayList.add(voidChalangeCube);
		masterArrayList.add(anisatropicGearCube);
		masterArrayList.add(gearCube);
		masterArrayList.add(oneHanded3x3x3);
		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
	}
	public void addTime(TwistyPuzzleType twistyPuzzleTypeIn, double time){
		twistyPuzzleType = twistyPuzzleTypeIn;
		currentArrayList = (ArrayList) masterArrayList.get(twistyPuzzleType.ordinal());
		currentArrayList.add(time);
		masterArrayList.set(twistyPuzzleType.ordinal(), currentArrayList);
		System.out.println(twistyPuzzleType.toString() + "  " +  masterArrayList.get(twistyPuzzleType.ordinal()));
	}
	public String getAvarage5Time(TwistyPuzzleType twistyPuzzleTypeIn){
		double maximum;
		double minimum;
		double sumForAvarageOf5 = 0;
		double avarageOf5;
		currentArrayList = (ArrayList) masterArrayList.get(twistyPuzzleTypeIn.ordinal());
		currentArrayListClone = (ArrayList) currentArrayList.clone();
		while(currentArrayListClone.size() > 5){
			currentArrayListClone.remove(0);
		}
		if(currentArrayListClone.size() == 5){
			maximum = (double) currentArrayListClone.get(0);
			for(int i = 1; i<currentArrayListClone.size(); i++){
				if((double)(currentArrayListClone.get(i)) > maximum){
					maximum = (double) currentArrayListClone.get(i);
				}
			}
			currentArrayListClone.remove(maximum);
			minimum = (double) currentArrayListClone.get(0);
			for(int i = 1; i < currentArrayListClone.size(); i++){
				if((double)(currentArrayListClone.get(i)) < minimum){
					minimum = (double) currentArrayListClone.get(i);
				}
			}
			currentArrayListClone.remove(minimum);
			for(int i = 0; i < currentArrayListClone.size(); i++){
				sumForAvarageOf5 = sumForAvarageOf5 + (double) currentArrayListClone.get(i);
			}
			avarageOf5 = sumForAvarageOf5/currentArrayListClone.size();
			return String.format("%.3f", avarageOf5);
		}
		else{
			return "no avarage of 5 yet";
		}
	}
	public void deleteLastSolve(){
		currentArrayList = (ArrayList) masterArrayList.get(twistyPuzzleType.ordinal());
		if(!currentArrayList.isEmpty()){
			currentArrayList.remove(currentArrayList.size() - 1);
			masterArrayList.set(twistyPuzzleType.ordinal(), currentArrayList);
		}
	}
	public ArrayList getlast5Solves(TwistyPuzzleType twistyPuzzleTypeIn){
//		List<String> last5Solves = new List<String>();
//		currentArrayList = (ArrayList) masterArrayList.get(twistyPuzzleType.ordinal());
//		currentArrayListClone = (ArrayList) currentArrayList.clone();
//		for(int i = 0; i < currentArrayListClone.size(); i++){
//			last5Solves.add(Double.toString((double) currentArrayListClone.get(i)));
//		}
		return (ArrayList) masterArrayList.get(twistyPuzzleTypeIn.ordinal());
	}
}
