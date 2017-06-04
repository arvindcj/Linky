import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.IDN;
import javax.swing.JEditorPane;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.util.Observable;

/* Create Linky Browser GUI
   1. compose the GUI from TextField and WebView.
   2. set application Title.
   3. position the GUI.
   4. set GUI dimensions.
   5. add action listner.
   6. Update GUI when model is altered.
 */
public class BrowserUI
    extends View {
 
    private JTextField urlField;
    private LinkyWebView webView;
    private JPanel urlPanel;
    private String url;
       
    BrowserUI(String appTitle,
	      int width,
	      int height,
	      int Xpos,
	      int Ypos) {

	super(appTitle, width, height);
	urlField = new JTextField("Enter the URL");
	webView = new LinkyWebView();
	urlPanel = new JPanel();
	urlPanel.setLayout(new BorderLayout(Xpos, Ypos));
	urlPanel.add(urlField, BorderLayout.CENTER);
	getContentPane().add(urlPanel, BorderLayout.NORTH);
	getContentPane().add(webView, BorderLayout.CENTER);
	setSize(width, height);     
	setVisible(true);
    }

    public void addController(ActionListener controller) {
	urlField.addActionListener(controller);
    }

    public void update(Observable obs, Object obj) {
	System.out.println("update data");
	webView.repaint();
    }
}
