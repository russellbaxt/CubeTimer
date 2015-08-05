package cubetimer;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import fields.Fields;

public class Main{
	
	public static ArrayList <Integer> screenSize = Actions.getDefaultWindowSize();
	public static int width = screenSize.get(0);
	public static int height = screenSize.get(0);
	
	public static Fields f;
	public static FileWriter fw;
	public static Paint p;
	public static Scrambler s;
	public static Stackmat t;
	public static Actions a;
	public static KeyPresses kp;
	public static CloseOperation co;
	public static Display d;
	public static SwingTimer st;
	
	public static void main(String[] args){
		
		st = new SwingTimer();
		
		f = new Fields();
		Actions.callUponOpen(f);
		fw = new FileWriter();
		p = new Paint(f);
		s = new Scrambler(f, p);
		t = new Stackmat(f, s, p, fw);
		a = new Actions();
		co = new CloseOperation(f);
		d = new Display(co, kp, p, f, t, s, a);
		
	
		d.setSize(width, height);
		d.setResizable(true);
		d.setVisible(true);
		d.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		d.setTitle("Cube Timer");
		d.setLocationRelativeTo(null);
		d.addWindowListener(d);
		
	}

}
