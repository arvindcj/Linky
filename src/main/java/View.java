import javax.swing.JFrame;
import java.util.Observable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class View
    extends JFrame
    implements java.util.Observer {

    int width;
    int height;
    String appTitle;
    
    View(String appTitle, int width,int height) {
	super(appTitle);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void update(Observable obs, Object obj) {
    }

    //    public void addController(Controller controller) {
	
    //}
}
