package cubetimer;

import java.awt.Frame;

import javax.swing.JFrame;

public class Main{
	
	public static int width = 800;
	public static int height = 830;
	
	public static Timer t = new Timer();
	public static Display f = new Display(t);
	
	public static void main(String args[]){
	
		f.setSize(width, height);
		f.setResizable(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Rubik's Cube Timer");
		f.setLocationRelativeTo(null);
		
		while(true){
			width = f.getWidth();
			height = f.getHeight();
			t.keepTime(width, height);
		}
	}
}
