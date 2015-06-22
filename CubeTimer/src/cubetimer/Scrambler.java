package cubetimer;

import java.util.ArrayList;
import java.util.Random;

public class Scrambler {
	private String randomScramble;
	private String randomMove;
	private String lastFaceMoved;
	private boolean faceMoving;
	private Random random;
	private int faceMovedInInt;
	private int moveDirectionInInt;
	private int faceDepthInInt;

	public Scrambler() {
		random = new Random();
	}

	public String intTo3x3Turn(int face, int symbol) {
		String faces = "ULFRBD";
		String symbols = " '2";
		return "" + faces.charAt(face) + symbols.charAt(symbol);
		
	}
	public String intTo2x2Turn(int face,int symbol){
		String faces = "RUF";
		String symbols = " '2";
		return "" + faces.charAt(face) + symbols.charAt(symbol);
	}
	public String intTo4x4Or5x5Turn(int face, int faceDepth, int symbol){
		String outerFaces = "ULFRBD";
		String innerFaces = "ulfrbd";
		String symbols = " '2";
		if(faceDepth == 1){
			return outerFaces.charAt(face) + "w" + symbols.charAt(symbol);
		}
		else if(faceDepth == 2){
			return innerFaces.charAt(face) + "" + symbols.charAt(symbol);
		}
		else{
			return outerFaces.charAt(face) + "" + symbols.charAt(symbol);
		}
	}
	public String random3x3Scramble(int scrambleLength){
		for (int i = 0; i<scrambleLength; i++){
			int randomNumber = random.nextInt(6);
			if(faceMovedInInt == randomNumber){
				i--;
			}
			else{
				faceMovedInInt = randomNumber;
				moveDirectionInInt = random.nextInt(3);
				randomMove = intTo3x3Turn(faceMovedInInt, moveDirectionInInt);
				if (i == 0){
					randomScramble = randomMove;
				}
				else{
					randomScramble = randomScramble + " " + randomMove;
				}
				
			}
		}
		return randomScramble;
	}
	public String random2x2Scramble(int scrambleLength){
		for(int i = 0; i < scrambleLength; i++){
			int randomNumber = random.nextInt(3);
			if(faceMovedInInt == randomNumber){
				i--;
			}
			else{
				faceMovedInInt = randomNumber;
				moveDirectionInInt = random.nextInt(3);
				randomMove = intTo2x2Turn(faceMovedInInt, moveDirectionInInt);
				if(i == 0){
					randomScramble = randomMove;
				}
				else{
					randomScramble = randomScramble + " " + randomMove;
				}
			}
		}
		return randomScramble;
	}
	public String random4x4Or5x5Scramble(int scrambleLenght){
		for(int i = 0; i < scrambleLenght; i++){
			int randomNumber = random.nextInt(3);
			if(faceMovedInInt == randomNumber){
				i--;
			}
			else{
				faceMovedInInt = randomNumber;
				faceDepthInInt = random.nextInt(3);
				moveDirectionInInt = random.nextInt(3);
				randomMove = intTo4x4Or5x5Turn(faceMovedInInt,faceDepthInInt,moveDirectionInInt);
				if(i== 0){
					randomScramble = randomMove;
				}
				else{
					randomScramble = randomScramble + " " + randomMove;
				}
			}
		}
		return randomScramble;
	}
	public String curvyCopterScramble(){
		return "No Curvy Copter Scramble Avaliable";
	}
	public String randomMagaMinxScramble(int scrambleLength){
		int j = 1;
		boolean rNext;
		int randomNumber;
		rNext = random.nextBoolean();
		String symbols = "+-";
		String otherSymbols = "' ";
		for(int i = 0; i < scrambleLength; i++){
			if(j  >= 10){
				j = 1;
				randomMove = "U" + otherSymbols.charAt(random.nextInt(2)) + "/n";
			}
			else{
				j++;
				if(rNext){
					randomNumber = random.nextInt(2);
					randomMove = "R" + symbols.charAt(randomNumber) + symbols.charAt(randomNumber);
					rNext = false;
				}
				else{
					rNext = true;
					randomNumber = random.nextInt(2);
					randomMove = "D" + symbols.charAt(randomNumber) + symbols.charAt(randomNumber);
				}
			}
			if(i<1){
				randomScramble = randomMove;
			}
			else{
				randomScramble = randomScramble + " " + randomMove;
			}
		}
		return randomScramble;
	}
	public String randomCorrectScramble(TwistyPuzzleType twistyPuzzleType, int scrambleSize){
		if(twistyPuzzleType == TwistyPuzzleType.twoLayeredCube){
			return random2x2Scramble(scrambleSize);
		}
		else if(twistyPuzzleType == TwistyPuzzleType.fourLayeredCube){
			return random4x4Or5x5Scramble(scrambleSize);
		}
		else if(twistyPuzzleType == TwistyPuzzleType.fiveLayeredCube){
			return random4x4Or5x5Scramble(scrambleSize);
		}
		else if(twistyPuzzleType == TwistyPuzzleType.curvyCopter){
			return curvyCopterScramble();
		}
		else if(twistyPuzzleType == TwistyPuzzleType.magaMinx){
			return randomMagaMinxScramble(scrambleSize);
		}
		else{
			return random3x3Scramble(scrambleSize);
		}
	}
}
