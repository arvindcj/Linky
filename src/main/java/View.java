
import java.util.Observable;

public class View
    extends JFrame
    implements java.util.Observer {

    View() {
    }

    public void addController(Controller controller){

	//button.addActionListener(controller);	//need controller before adding it as a listener 
    }
    
    public static class CloseListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
	    e.getWindow().setVisible(false);
	    System.exit(0);
	}
    }
}
