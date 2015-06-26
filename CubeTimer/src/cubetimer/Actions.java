package cubetimer;

public class Actions{
	
	private long start;
	private long end;
	private double timeSeconds;
	private int timeMinutes;
	
	public Actions(){
	
		timeSeconds = 0;
		timeMinutes = 0;
	}
	
	public String startTimer(){
	
		start = System.currentTimeMillis();
		return "0:0.0";
	}
	
	public String getTime(int penalty){
	
		end = System.currentTimeMillis();
		timeSeconds = (end - start) / 1000.0 + penalty;
		timeMinutes = 0;
		
		while(timeSeconds >= 60){
			timeMinutes ++;
			timeSeconds = timeSeconds - 60;
		}
		
		String seconds = String.format("%.3f", timeSeconds);
		String minutes = Integer.toString(timeMinutes);
		
		return minutes + ":" + seconds;
	}
	
	public double getTimePreviouslyGotenAsDouble(){
	
		int theInt = (int) ((timeSeconds + timeMinutes * 60.0) * 1000.0);
		return theInt / 1000.0;
	}
}
