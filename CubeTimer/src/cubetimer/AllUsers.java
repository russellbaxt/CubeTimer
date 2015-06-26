package cubetimer;

import java.util.ArrayList;

public class AllUsers{
	
	private ArrayList<User> users;
	
	public AllUsers(){
	
		users = new ArrayList<User>();
	}
	
	public void addUser(User user){
	
		users.add(user);
	}
	
	public void setUser(int index, User user){
	
		users.set(index, user);
	}
	
	public User getUser(int index){
	
		return users.get(index);
	}
	
	public int getSize(){
	
		return users.size();
	}
	
	public int getIndexOfUserWithUserName(String userName){
	
		String userNameOfIndexI;
		
		for(int i = 0; i < users.size(); i ++){
			
			userNameOfIndexI = users.get(i).getUserName();
			if(userNameOfIndexI.contentEquals(userName)){
				return i;
			}
		}
		return - 1;
	}
}
