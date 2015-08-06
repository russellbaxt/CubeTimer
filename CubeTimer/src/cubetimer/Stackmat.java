package cubetimer;

import javax.swing.Timer;

import savedDada.Time;
import swingTimerActions.KeepCountDown;
import swingTimerActions.KeepTime;
import fields.Fields;

public class Stackmat {

	private Fields fields;
	private Scrambler scrambler;
	private Paint paint;
	@SuppressWarnings("unused")
	private FileWriter fileWriter;
	private Timer countDownTimer;
	private Timer stackmatTimer;
	private KeepCountDown keepCountDown;
	private KeepTime keepTime;

	private double timeSeconds;

	public Stackmat(Fields f, Scrambler scramblerIn, Paint paintIn,
			FileWriter fileWriterIn) {

		fields = f;
		scrambler = scramblerIn;
		paint = paintIn;
		fileWriter = fileWriterIn;

		timeSeconds = 0;

	}

	public void stopTimer() {

		stackmatTimer.stop();

		scrambler.randomCorrectScrambleInFieldsUsingFields();
		fields.timerStatus.running = false;
		fields.allUsers
				.getUser()
				.getTwistyPuzzle()
				.addTime(
						new Time(keepTime.getEndTimeResult(), keepCountDown
								.getPenalty(), keepCountDown.getDNF()));
		fields.allUsers.getUser().getTwistyPuzzle().setLastAvarageOf5();

	}

	public void startTimer() {

		fields.timerStatus.running = true;
		keepTime = new KeepTime(fields, paint, keepCountDown);
		stackmatTimer = new Timer(10, keepTime);
		stackmatTimer.start();

	}

	public void StartCountDown() {

		fields.timerStatus.countDownRunning = true;

		keepCountDown = new KeepCountDown(fields, paint);
		countDownTimer = new Timer(1000, keepCountDown);
		countDownTimer.setInitialDelay(1000);
		countDownTimer.start();
	}

	public void stopCountDown() {

		fields.timerStatus.countDownRunning = false;
		countDownTimer.stop();
	}

}
