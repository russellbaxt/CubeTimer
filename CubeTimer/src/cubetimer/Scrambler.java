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
		return "" + faces.charAt(face) + faces.charAt(symbol);
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
}
