package cubetimer;

import java.util.ArrayList;

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
	}
	public void addTime(TwistyPuzzleType twistyPuzzleType, double time){
		((ArrayList) masterArrayList.get(twistyPuzzleType.ordinal())).add(time);
//		masterArrayList.set(twistyPuzzleType.ordinal(), ((ArrayList) masterArrayList.get(twistyPuzzleType.ordinal())).add(time));
		System.out.println(twistyPuzzleType.toString() + "  " +  masterArrayList.get(twistyPuzzleType.ordinal()));
	}
	public String getAvarage5Time(){
		return "1:11.111";
	}
	public void deleteLastSolve(){
	}
}
