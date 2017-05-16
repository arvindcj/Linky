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
	//urlField.addActionListener(this);
	setSize(width, height);     
	setVisible(true);
    }

    /*
    public void actionPerformed(ActionEvent event) {
	url = event.getActionCommand().toLowerCase();
	Linky.logger.info(url);
    }
    */
    
    public void addController(ActionListener controller) {
	urlField.addActionListener(controller);
    }
}
