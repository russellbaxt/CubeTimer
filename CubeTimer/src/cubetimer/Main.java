package cubetimer;

import java.awt.Frame;

import javax.swing.JFrame;

public class Main{
	
	public static int width = 800;
	public static int height = 830;
	
	public static Paint p = new Paint();
	public static Fields f = new Fields(p);
	public static TimesTracker tt = new TimesTracker(f);
	public static Timer t = new Timer(f);
	public static Scrambler s = new Scrambler(f);
	public static Actions a = new Actions();
	public static KeyPresses kp = new KeyPresses(t, s, tt, a, f);
	public static Display d = new Display(kp, p);
	
	public static void main(String args[]){
	
		d.setSize(width, height);
		d.setResizable(true);
		d.setVisible(true);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setTitle("Rubik's Cube Timer");
		d.setLocationRelativeTo(null);
		
		while(true){
			width = d.getWidth();
			height = d.getHeight();
			kp.trigerActionsForKeyPresses();
			AnotherMethod.callMe(f, kp, tt, t);
		}
	}
}
