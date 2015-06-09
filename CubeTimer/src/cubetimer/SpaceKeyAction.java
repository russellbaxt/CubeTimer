package cubetimer;
 
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
 
public  class SpaceKeyAction extends AbstractAction{//it extends AbstractAction because then it can be an action in keyBindings
    private Timer timer;//creates object timer of class Timer
     
    public SpaceKeyAction(Timer timerIn){
        timer = timerIn;
    }
     
    public void actionPerformed(ActionEvent e) {//this is an action so it can be assigned to an action name and then to a key on the keyboard
        timer.spacePressed();
    }
 
}