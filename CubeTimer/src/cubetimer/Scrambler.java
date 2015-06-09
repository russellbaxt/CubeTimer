package cubetimer;

import java.util.Random;

public class Scrambler {
	String randomScramble;
	String randomMove;
	String lastFaceMoved;
	Random random;

	public Scrambler() {
		random = new Random();
	}

	public String GenerateRandomScramble() {
		int randomNumber;
		for (int i = 0; i < 20; i++) {
			randomNumber = random.nextInt(6);
			if (randomNumber == 0) {
				if (lastFaceMoved == "R") {
					i = i - 1;
					lastFaceMoved = null;
				} else {
					randomMove = "R";
					lastFaceMoved = "R";
				}

			} else if (randomNumber == 1) {
				if (lastFaceMoved == "L") {
					i = i - 1;
					lastFaceMoved = null;
				} else {
					randomMove = "L";
					lastFaceMoved = "L";
				}
			} else if (randomNumber == 2) {
				if (lastFaceMoved == "U") {
					i = i - 1;
					lastFaceMoved = null;
				} else {
					randomMove = "U";
					lastFaceMoved = "U";
				}
			} else if (randomNumber == 3) {
				if (lastFaceMoved == "D") {
					i = i - 1;
					lastFaceMoved = null;
				} else {
					randomMove = "D";
					lastFaceMoved = "D";
				}
			} else if (randomNumber == 4) {
				if (lastFaceMoved == "F") {
					i = i - 1;
					lastFaceMoved = null;
				} else {
					randomMove = "F";
					lastFaceMoved = "F";
				}
			} else if (randomNumber == 5) {
				if (lastFaceMoved == "B") {
					i = i - 1;
					lastFaceMoved = null;
				} else {
					randomMove = "B";
					lastFaceMoved = "B";
				}
			}
			if (lastFaceMoved != null) {
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
