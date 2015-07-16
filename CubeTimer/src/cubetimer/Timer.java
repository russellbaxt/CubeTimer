package cubetimer;

public class Timer{
	
	private Fields fields;
	private Scrambler scrambler;
	private TimesTracker timesTracker;
	private Paint paint;
	
	private long start;
	private long end;
	private double timeSeconds;
	private int timeMinutes;
	private double countDownStart;
	private double countDownEnd;
	private boolean plus2Inspection;
	private int timePenalty;
	
	public Timer(Fields f, Scrambler scramblerIn, TimesTracker timesTrackerIn, Paint paintIn){
	
		fields = f;
		scrambler = scramblerIn;
		timesTracker = timesTrackerIn;
		paint = paintIn;
		
		timeSeconds = 0;
		timeMinutes = 0;
		
	}
	
	public void startStopTimer(){
	
		if(fields.timerStatus.running){
			
			fields.timerStatus.running = false;
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
		else{
			
			fields.timerStatus.running = true;
			start = System.currentTimeMillis();
			fields.displayedDada.time = "0:0.0";
		}
		
		paint.repaint();
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
	
	public double getTimeAsDouble(){
	
		int theInt = (int) ((timeSeconds + timeMinutes * 60.0) * 100.0);
		return theInt / 100.0;
	}
	
	public void StartCountDown(){
	
		fields.penalty.timePenalty = 0;
		fields.penalty.DNF = false;
		
		fields.timerStatus.countDownRunning = true;
		countDownStart = (double) System.currentTimeMillis() / 1000.0;
		
		paint.repaint();
	}
	
	public void updateCountdownTime(){
	
		countDownEnd = (double) System.currentTimeMillis() / 1000.0;
		if(countDownEnd - countDownStart < 15){
			int timeInspected = (int) (countDownEnd - countDownStart);
			String timeLeftOfInspection = Integer.toString(15 - timeInspected);
			fields.displayedDada.time = timeLeftOfInspection;
			
		}
		else{
			
			if(! plus2Inspection){
				fields.penalty.timePenalty += 2;
				plus2Inspection = true;
			}
			if(countDownEnd - countDownStart < 17){
				fields.displayedDada.time = "+2";
			}
			else{
				
				fields.penalty.DNF = true;
				
				fields.displayedDada.time = "DNF";
				fields.timerStatus.running = false;
				fields.timerStatus.countDownRunning = false;
				fields.penalty.DNF = true;
				timePenalty = 0;
				plus2Inspection = false;
				timesTracker.addTime(0.0);
				scrambler.randomCorrectScrambleInFieldsUsingFields();
			}
			
		}
		
		paint.repaint();
		
	}
	
}
