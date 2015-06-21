package cubetimer;

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
	public String randomCorrectScramble(ScrambleType scrambleType, int scrambleSize){
		if(scrambleType == ScrambleType.twoLayeredCube){
			return random2x2Scramble(scrambleSize);
		}
		else if(scrambleType == ScrambleType.fourLayeredCube){
			return random4x4Or5x5Scramble(scrambleSize);
		}
		else if(scrambleType == ScrambleType.fiveLayeredCube){
			return random4x4Or5x5Scramble(scrambleSize);
		}
		else{
			return random3x3Scramble(scrambleSize);
		}
	}
}
