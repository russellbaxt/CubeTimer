package cubetimer;

import fields.Fields;

public class CloseOperation{
	
	Fields fields;

	public CloseOperation(Fields fieldsIn){
		
		fields = fieldsIn;
	}
	
	public void closeOperation(){
		
		fields.close = true;
	}
}
