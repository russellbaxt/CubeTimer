package cubetimer;

import java.awt.Frame;

import javax.swing.JFrame;

public class Main{
	
		
	public static int width = 800;
	public static int height = 830;
	
	public static Fields f;
	public static FileWriter fw;
	public static Paint p;
	public static Scrambler s;
	public static Timer t;
	public static Actions a;
	public static KeyPresses kp;
	public static Display d;
	
	public static void main(String args[]){
		
		f = new Fields();
		Actions.callUponOpen(f);
		fw = new FileWriter();
		p = new Paint(f);
		s = new Scrambler(f, p);
		t = new Timer(f, s, p, fw);
		a = new Actions();
		kp = new KeyPresses(t, s, a, f, p);
		d = new Display(kp, p);
		
	
		d.setSize(width, height);
		d.setResizable(true);
		d.setVisible(true);
		d.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		d.setTitle("Cube Timer");
		d.setLocationRelativeTo(null);
		
		while(true){
			width = d.getWidth();
			height = d.getHeight();
			p.repaint();
			f.setScreenSize(width, height);
			kp.trigerActionsForKeyPresses();
			if(f.close){
				d.close();
			}
			AnotherClass.callMeMany(f, kp, t, p);
		}
	}
}
