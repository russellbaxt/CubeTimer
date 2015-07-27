package cubetimer;

public class JONAHS{
	
	Fields fields;

	public JONAHS(Fields fieldsIn){
		
		fields = fieldsIn;
	}
	
	public void closeOperation(){
		
		fields.close = true;
	}
}
