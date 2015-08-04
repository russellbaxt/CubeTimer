package swingTimerActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fields.DisplayState;
import fields.Fields;


public class ChangeUser implements ActionListener{

	Fields fields;
	
	public ChangeUser(Fields f){
		
		fields = f;
	}
	
	public void actionPerformed(ActionEvent e){
	
		fields.displayState = DisplayState.changeUser;
		
	}
	
}
