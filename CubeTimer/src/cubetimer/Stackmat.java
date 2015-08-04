package cubetimer;

import javax.swing.Timer;

import swingTimerActions.KeepCountDown;
import swingTimerActions.KeepTime;
import fields.Fields;

public class Stackmat{
	
	private Fields fields;
	private Scrambler scrambler;
	private Paint paint;
	private FileWriter fileWriter;
	private Timer countDownTimer;
	private Timer stackmatTimer;
	private KeepCountDown keepCountDown;
	private KeepTime keepTime;
	
	private long start;
	private long end;
	private double timeSeconds;
	private int timeMinutes;
	private double countDownStart;
	private double countDownEnd;
	private boolean plus2Inspection;
	private IntAndDouble minutesAndSeconds;
	
	public Stackmat(Fields f, Scrambler scramblerIn, Paint paintIn, FileWriter fileWriterIn){
	
		fields = f;
		scrambler = scramblerIn;
		paint = paintIn;
		fileWriter = fileWriterIn;
		
		countDownTimer = new Timer(1000, keepCountDown);
		countDownTimer.setInitialDelay(1000);
		stackmatTimer = new Timer(10, keepTime);
		stackmatTimer.setInitialDelay(10);
		
		timeSeconds = 0;
		timeMinutes = 0;
		
	}
	
	public void stopTimer(){
	
		stackmatTimer.stop();
		
		scrambler.randomCorrectScrambleInFieldsUsingFields();
		
		fields.timerStatus.running = false;
		
		minutesAndSeconds = keepTime.getTime();
		timeSeconds = minutesAndSeconds.theDouble;
		timeMinutes = minutesAndSeconds.theInt;
		
		String seconds = Double.toString(timeSeconds);
		String minutes = Integer.toString(timeMinutes);
		
		if(timeMinutes > 0){
			fields.displayedDada.time = minutes + ":" + seconds;
		}
		
		else{
			fields.displayedDada.time = seconds;
		}
		
		Actions.addTime(fields, paint, timeMinutes * 60 + timeSeconds);
		
		paint.repaint();
	}
	
	public void startTimer(){
	
		fields.timerStatus.running = true;
		keepTime = new KeepTime(fields, paint);
		stackmatTimer.start();
		
	}
	
	public void updateTime(){
	
		if(! fields.timerStatus.countDownRunning && fields.timerStatus.running){
			end = System.currentTimeMillis();
			timeSeconds = (end - start) / 1000.0;
			timeMinutes = 0;
			
			while(timeSeconds >= 60){
				timeMinutes ++;
				timeSeconds -= 60;
			}
			
			String seconds = String.format("%.2f", timeSeconds);
			String minutes = Integer.toString(timeMinutes);
			
			fields.displayedDada.time = minutes + ":" + seconds;
		}
		
		paint.repaint();
	}
	
	public void StartCountDown(){
		
		System.out.println("Hello");
	
		fields.penalty.timePenalty = 0;
		fields.penalty.DNF = false;
		
		fields.timerStatus.countDownRunning = true;
		
		keepCountDown = new KeepCountDown(fields, paint, countDownTimer);
		countDownTimer.start();
	}
	
//	public void updateCountdownTime(){
//	
//		countDownEnd = (double) System.currentTimeMillis() / 1000.0;
//		if(countDownEnd - countDownStart < 15){
//			int timeInspected = (int) (countDownEnd - countDownStart);
//			String timeLeftOfInspection = Integer.toString(15 - timeInspected);
//			fields.displayedDada.time = timeLeftOfInspection;
//			
//		}
//		else{
//			
//			if(! plus2Inspection){
//				fields.penalty.timePenalty += 2;
//				plus2Inspection = true;
//			}
//			if(countDownEnd - countDownStart < 17){
//				fields.displayedDada.time = "+2";
//			}
//			else{
//				
//				fields.penalty.DNF = true;
//				
//				fields.displayedDada.time = "DNF";
//				fields.timerStatus.running = false;
//				fields.timerStatus.countDownRunning = false;
//				fields.penalty.DNF = true;
//				fields.penalty.timePenalty = 0;
//				plus2Inspection = false;
//				Actions.addTime(fields, paint, 0.0);
//				scrambler.randomCorrectScrambleInFieldsUsingFields();
//			}
//			
//		}
//		
//		paint.repaint();
//		
//	}
	
	public void stopCountDown(){
	
		fields.timerStatus.countDownRunning = false;
		countDownTimer.stop();
	}
	
}
