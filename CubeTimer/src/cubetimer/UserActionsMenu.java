package cubetimer;

public class UserActionsMenu{
	
	private boolean changeUser;
	private boolean addUser;
	private boolean deleteCurrentUser;
	private boolean changeCurrentUserName;
	
	private boolean exit;
	
	public UserActionsMenu(){
	
		addUser = true;
		changeUser = false;
		deleteCurrentUser = false;
		changeCurrentUserName = false;
		exit = false;
	}
	
	public void upOne(){
	
		if(addUser){
			
			addUser = false;
			exit = true;
		}
		
		else if(changeUser){
			
			changeUser = false;
			addUser = true;
		}
		
		else if(deleteCurrentUser){
			
			deleteCurrentUser = false;
			changeUser = true;
		}
		
		else if(changeCurrentUserName){
			
			changeCurrentUserName = false;
			deleteCurrentUser = true;
		}
		
		else{
			
			exit = false;
			changeCurrentUserName = true;
		}
	}
	
	public void downOne(){
	
		if(addUser){
			addUser = false;
			changeUser = true;
		}
		
		else if(changeUser){
			
			changeUser = false;
			deleteCurrentUser = true;
		}
		
		else if(deleteCurrentUser){
			
			deleteCurrentUser = false;
			changeCurrentUserName = true;
		}
		
		else if(changeCurrentUserName){
			
			changeCurrentUserName = false;
			exit = true;
		}
		
		else{
			
			exit = false;
			addUser = true;
		}
		
	}
	
	public boolean getAddUser(){
	
		return addUser;
	}
	
	public boolean getChangeUser(){
	
		return changeUser;
	}
	
	public boolean getDeleteCurrentUser(){
	
		return deleteCurrentUser;
	}
	
	public boolean getChangeCurrentUserName(){
	
		return changeCurrentUserName;
	}
	
	public boolean getExit(){
	
		return exit;
	}
}
