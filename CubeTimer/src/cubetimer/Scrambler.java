package cubetimer;

import java.util.Random;

public class Scrambler {
	String randomScramble;
	String randomMove;
	String lastFaceMoved;
	boolean faceMoving;
	Random random;

	public Scrambler() {
		random = new Random();
	}

	public String GenerateRandomScramble() {
		int randomNumber;
		for (int i = 0; i < 20; i++) {
			randomNumber = random.nextInt(6);
			if (randomNumber == 0) {
				if (lastFaceMoved == "RL") {
					i = i - 1;
					faceMoving = false;
				} else {
					randomMove = "R";
					lastFaceMoved = "RL";
					faceMoving = true;
					
				}

			} else if (randomNumber == 1) {
				if (lastFaceMoved == "RL") {
					i = i - 1;
					faceMoving = false;
				} else {
					randomMove = "L";
					lastFaceMoved = "RL";
					faceMoving = true;
				}
			} else if (randomNumber == 2) {
				if (lastFaceMoved == "UD") {
					i = i - 1;
					faceMoving = false;
				} else {
					randomMove = "U";
					lastFaceMoved = "UD";
					faceMoving = true;
				}
			} else if (randomNumber == 3) {
				if (lastFaceMoved == "UD") {
					i = i - 1;
					faceMoving = false;
				} else {
					randomMove = "D";
					lastFaceMoved = "UD";
					faceMoving = true;
				}
			} else if (randomNumber == 4) {
				if (lastFaceMoved == "FB") {
					i = i - 1;
					faceMoving = false;
				} else {
					randomMove = "F";
					lastFaceMoved = "FB";
					faceMoving = true;
				}
			} else if (randomNumber == 5) {
				if (lastFaceMoved == "FB") {
					i = i - 1;
					faceMoving = false;
				} else {
					randomMove = "B";
					lastFaceMoved = "FB";
					faceMoving = true;
				}
			}
			if (faceMoving) {
				if (i == 0) {
					randomScramble = randomMove;
				} else {
					randomScramble = randomScramble + randomMove;
				}
				if (randomMove == "D" || randomMove == "B") {
					randomMove = "2 ";
				} else {
					randomNumber = random.nextInt(3);
					if (randomNumber == 0) {
						randomMove = " ";
					} else if (randomNumber == 1) {
						randomMove = "' ";
					} else if (randomNumber == 2) {
						randomMove = "2 ";
					}
				}
				randomScramble = randomScramble + randomMove;
			}
		}
		return randomScramble;
	}
}
