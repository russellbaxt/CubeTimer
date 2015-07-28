package cubetimer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JFrame implements WindowListener{
	
	private JPanel gp;
	private KeyBindings kb;
	private JONAHS co;
	
	public Display(JONAHS coIn, KeyPresses kp, Paint p){
	
		co = coIn;
		gp = (JPanel) getGlassPane();
		gp.setVisible(true);
		kb = new KeyBindings(kp);
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

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		co.closeOperation();
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
