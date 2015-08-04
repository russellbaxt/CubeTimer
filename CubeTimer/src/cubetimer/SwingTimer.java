package cubetimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.Timer;


public class SwingTimer implements ActionListener{
	
	public SwingTimer(){
		Timer timer = new Timer(1000, this);
		timer.setInitialDelay(5000);
	}
	
	public void actionPerformed(ActionEvent e){
		
		System.out.println("Hi");
	}
}
