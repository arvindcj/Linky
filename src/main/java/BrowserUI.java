import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.IDN;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

class BrowserUI extends JFrame  {
    int width;
    int height;
    String appTitle;
    private JTextField txtURL= new JTextField("");
    WebView01 wv = new WebView01();
    
    BrowserUI(String appTitle, int width,int height) {
	this.width = width;
	this.height = height;
	this.appTitle = appTitle;
    }

    public void drawBrowserWindow(int Xpos, int Ypos) {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	JPanel pnlURL = new JPanel();
	pnlURL.setLayout(new BorderLayout(Xpos, Ypos));
	pnlURL.add(txtURL, BorderLayout.CENTER);     
	getContentPane().add(pnlURL, BorderLayout.NORTH);
	getContentPane().add(wv, BorderLayout.CENTER);
	ActionListener al = new ActionListener() {       
          public void actionPerformed(ActionEvent ae) {
	      	Linky.logger.info("action listener 01");

               try {
		   String url = ae.getActionCommand().toLowerCase();           
		   //  SoupParser jsoup = new SoupParser(file);
		   Coordinator.lo();
		   wv.revalidate();
		   wv.repaint();
		   // if (url.startsWith("http://"))             
		   //     url = url.substring(7);           
		    // ep.setPage("http://" + IDN.toASCII(url));         
               } catch (Exception e) {           
                    e.printStackTrace();
                    
               }       
          }     
     };     
 
     txtURL.addActionListener(al);      
     setSize(width, height);     
     setVisible(true);
    }

}
