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
	
		if(fields.running){
			
			fields.running = false;
			end = System.currentTimeMillis();
			timeSeconds = (end - start) / 1000.0;
			timeMinutes = 0;
			
			while(timeSeconds >= 60){
				timeMinutes ++;
				timeSeconds -= 60;
			}
			
			String seconds = String.format("%.2f", timeSeconds);
			String minutes = Integer.toString(timeMinutes);
			
			fields.time = minutes + ":" + seconds;
		}
		else{
			
			fields.running = true;
			start = System.currentTimeMillis();
			fields.time = "0:0.0";
		}
		
		paint.repaint();
	}
	
	public void updateTime(){
	
		if(! fields.countDownRunning && fields.running){
			end = System.currentTimeMillis();
			timeSeconds = (end - start) / 1000.0;
			timeMinutes = 0;
			
			while(timeSeconds >= 60){
				timeMinutes ++;
				timeSeconds -= 60;
			}
			
			String seconds = String.format("%.2f", timeSeconds);
			String minutes = Integer.toString(timeMinutes);
			
			fields.time = minutes + ":" + seconds;
		}
		
		paint.repaint();
	}
	
	public double getTimeAsDouble(){
	
		int theInt = (int) ((timeSeconds + timeMinutes * 60.0) * 100.0);
		return theInt / 100.0;
	}
	
	public void StartCountDown(){
	
		fields.timePenalty = 0;
		fields.DNF = false;
		
		fields.countDownRunning = true;
		countDownStart = (double) System.currentTimeMillis() / 1000.0;
		
		paint.repaint();
	}
	
	public void updateCountdownTime(){
	
		countDownEnd = (double) System.currentTimeMillis() / 1000.0;
		if(countDownEnd - countDownStart < 15){
			int timeInspected = (int) (countDownEnd - countDownStart);
			String timeLeftOfInspection = Integer.toString(15 - timeInspected);
			fields.time = timeLeftOfInspection;
			
		}
		else{
			
			if(! plus2Inspection){
				fields.timePenalty += 2;
				plus2Inspection = true;
			}
			if(countDownEnd - countDownStart < 17){
				fields.time = "+2";
			}
			else{
				
				fields.DNF = true;
				
				fields.time = "DNF";
				fields.running = false;
				fields.countDownRunning = false;
				timePenalty = 0;
				plus2Inspection = false;
				timesTracker.addTime(fields.twistyPuzzleType, 0);
				scrambler.randomCorrectScrambleInFieldsUsingFields();
			}
			
		}
		
		paint.repaint();
		
	}
	
}
