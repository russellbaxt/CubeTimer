package cubetimer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fields.Fields;
import keyBindings.KeyBindings;

public class Display extends JFrame implements WindowListener{
	
	private JPanel gp;
	private KeyBindings kb;
	private CloseOperation co;
	
	public Display(CloseOperation coIn, KeyPresses kp, Paint p, Fields f, Stackmat sm, Scrambler s, Actions a){
	
		co = coIn;
		gp = (JPanel) getGlassPane();
		gp.setVisible(true);
		kb = new KeyBindings(kp, f, p, s, a, sm);
		gp.setLayout(new GridLayout(1, 1));
		this.setLayout(new GridLayout(1, 1));
		gp.add(p);
		this.add(kb);

	}
	
	public int getWidth(){
	
		Dimension size = getSize();
		return size.width;
	}
	
	public int getHeight(){
	
		Dimension size = getSize();
		return size.height;
	}
	
	public void close(){
		System.exit(0);
	}

	public void windowActivated(WindowEvent e) {
		
	}

	public void windowClosed(WindowEvent e) {
		
	}

	public void windowClosing(WindowEvent e) {
		co.closeOperation();
		
	}

	public void windowDeactivated(WindowEvent e) {
		
	}

	public void windowDeiconified(WindowEvent e) {
		
	}

	public void windowIconified(WindowEvent e) {
		
	}

	public void windowOpened(WindowEvent e) {
		
	}
}
