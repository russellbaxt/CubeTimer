package cubetimer;

import java.util.ArrayList;

public class TwistyPuzzle{
	
	private TwistyPuzzleType twistyPuzzleType;
	private ArrayList<Double> times;
	
	public TwistyPuzzle(TwistyPuzzleType twistyPuzzleTypeIn){
	
		twistyPuzzleType = twistyPuzzleTypeIn;
		times = new ArrayList<Double>();
	}
	
	public TwistyPuzzleType getTwistyPuzzleType(){
	
		return twistyPuzzleType;
	}
	
	public ArrayList<Double> getTimes(){
	
		return times;
	}
	
	public Double getTime(int index){
	
		return times.get(index);
	}
	
	public void setTime(int index, double time){
	
		times.set(index, time);
	}
	
	public void addTime(double time){
	
		times.add(time);
		
		while(times.size() > 20){
			times.remove(0);
		}
	}
	
	public void removeFirstElementInTimes(){
	
		times.remove(0);
	}
	
	public void removeTime(double time){
	
		times.remove(time);
	}
	
	public int getSize(){
	
		return times.size();
	}
	
	public ArrayList<Double> getLast5Times(){
	
		ArrayList<Double> last5Times = new ArrayList<Double>();
		int timesSize = times.size();
		
		if(timesSize >= 5){
			
			last5Times.add(times.get(timesSize - 1));
			last5Times.add(times.get(timesSize - 2));
			last5Times.add(times.get(timesSize - 3));
			last5Times.add(times.get(timesSize - 4));
			last5Times.add(times.get(timesSize - 5));
		}
		
		return last5Times;
		
	}
	
	public void removeLastElementInTimes(){
	
		if(times.size() > 0){
			times.remove(times.size() - 1);
		}
		
	}
}
