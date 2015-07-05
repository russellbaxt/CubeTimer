package cubetimer;

public class Timer{
	
	private Fields fields;
	private Scrambler scrambler;
	private TimesTracker timesTracker;
	
	private long start;
	private long end;
	private double timeSeconds;
	private int timeMinutes;
	private double countDownStart;
	private double countDownEnd;
	private boolean plus2Inspection;
	private int timePenalty;
	
	public Timer(Fields f, Scrambler scramblerIn, TimesTracker timesTrackerIn){
	
		fields = f;
		scrambler = scramblerIn;
		timesTracker = timesTrackerIn;
		
		timeSeconds = 0;
		timeMinutes = 0;
		
	}
	
	public void startStopTimer(){
	
		if(fields.getRunning()){
			
			fields.setRunning(false);
			end = System.currentTimeMillis();
			timeSeconds = (end - start) / 1000.0;
			timeMinutes = 0;
			
			while(timeSeconds >= 60){
				timeMinutes ++;
				timeSeconds = - 60;
			}
			
			String seconds = String.format("%.2f", timeSeconds);
			String minutes = Integer.toString(timeMinutes);
			
			fields.setTime(minutes + ":" + seconds);
		}
		else{
			
			fields.setRunning(true);
			start = System.currentTimeMillis();
			fields.setTime("0:0.0");
		}
	}
	
	public void updateTime(){
	
		if(! fields.getCountDownRunning() && fields.getRunning()){
			end = System.currentTimeMillis();
			timeSeconds = (end - start) / 1000.0;
			timeMinutes = 0;
			
			while(timeSeconds >= 60){
				timeMinutes ++;
				timeSeconds = - 60;
			}
			
			String seconds = String.format("%.2f", timeSeconds);
			String minutes = Integer.toString(timeMinutes);
			
			fields.setTime(minutes + ":" + seconds);
		}
	}
	
	public double getTimeAsDouble(){
	
		int theInt = (int) ((timeSeconds + timeMinutes * 60.0) * 100.0);
		return theInt / 100.0;
	}
	
	public void StartCountDown(){
	
		fields.setTimePenlaty(0);
		fields.setDNF(false);
		
		fields.setCountDownRunning(true);
		countDownStart = (double) System.currentTimeMillis() / 1000.0;
	}
	
	public void updateCountdownTime(){
	
		countDownEnd = (double) System.currentTimeMillis() / 1000.0;
		if(countDownEnd - countDownStart < 15){
			int timeInspected = (int) (countDownEnd - countDownStart);
			String timeLeftOfInspection = Integer.toString(15 - timeInspected);
			fields.setTime(timeLeftOfInspection);
			
		}
		else{
			
			if(! plus2Inspection){
				fields.setTimePenlaty(fields.getTimePenalty() + 2);
				plus2Inspection = true;
			}
			if(countDownEnd - countDownStart < 17){
				fields.setTime("+2");
			}
			else{
				
				fields.setDNF(true);
				
				fields.setTime("DNF");
				fields.setRunning(false);
				fields.setCountDownRunning(false);
				timePenalty = 0;
				plus2Inspection = false;
				timesTracker.addTime(fields.getTwistyPuzzleType(), 0);
				scrambler.randomCorrectScrambleInFieldsUsingFields();
			}
			
		}
		
	}
	
}
