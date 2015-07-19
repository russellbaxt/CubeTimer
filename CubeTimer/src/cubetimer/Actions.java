package cubetimer;

import java.util.Random;


public class Actions{
	
	Random random;
	
	public Actions(){
		
		random = new Random();
		
	}
	public TwistyPuzzleTypeAndInt randomTwistyPuzzle(){
		int randomNumber = random.nextInt(TwistyPuzzleType.values().length);
		TwistyPuzzleType twistyPuzzleType = TwistyPuzzleType.values()[randomNumber];
		int scrambleLenght;
		
		if(twistyPuzzleType == TwistyPuzzleType.megaMinx){
			scrambleLenght = 40;
		}
		else{
			scrambleLenght = 20;
		}
		
		TwistyPuzzleTypeAndInt twistyPuzzleTypeAndScrambleLength = new TwistyPuzzleTypeAndInt(twistyPuzzleType, scrambleLenght);
		return twistyPuzzleTypeAndScrambleLength;
		
	}
}
