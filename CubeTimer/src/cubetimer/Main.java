package cubetimer;
 
import javax.swing.JFrame;
 
public class Main {
    public static int width = 800;
    public static int height = 830;
    //integers width and height will tell how big the screen is
    public static Timer t = new Timer();
    public static Display f = new Display (t);//creating on object of class Display
    public static void main (String args[]){
        f.setSize(width,height);//sets the size of the screen to the values we set width and height to
        f.setResizable(false);//prevents the user from resizing the screen
        f.setVisible(true);//you want the screen to be viable?
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this is very important it means it will exit the program when you close the window. If you don't have this line it will keep your program running in the background after you close it.
        f.setTitle("Rubik's Cube Timer");//Sets the title of your window to Rubik's Cube Timer
        f.setLocationRelativeTo(null);//keeps the location of your window to move relative to other windows
        while (true){
        	t.keepTime();  
        }
    }
}