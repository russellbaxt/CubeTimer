package cubetimer;

import java.awt.Frame;

import javax.swing.JFrame;

public class Main{
	
	// TODO maybe fix the warning in all the classes
	// TODO read through every class
	
	public static int width = 800;
	public static int height = 830;
	
	public static Fields f = new Fields();
	public static Paint p = new Paint(f);
	public static TimesTracker tt = new TimesTracker(f, p);
	public static Scrambler s = new Scrambler(f, p);
	public static Timer t = new Timer(f, s, tt, p);
	public static Actions a = new Actions();
	public static KeyPresses kp = new KeyPresses(t, s, tt, a, f, p);
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
			p.repaint();
			f.setScreenSize(width, height);
			kp.trigerActionsForKeyPresses();
			AnotherClass.callMeMany(f, kp, tt, t, p);
		}
	}
}
