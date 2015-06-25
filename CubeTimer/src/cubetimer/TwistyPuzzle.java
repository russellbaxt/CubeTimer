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
	public ArrayList<Double> getCloneOfTimes(){
		return (ArrayList) times.clone();
	}
	public void removeLastElementInTimes(){
		if(times.size() > 0){
			times.remove(times.size() - 1);
		}

	}
}
