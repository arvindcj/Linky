import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Rectangle;
import java.util.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.FontMetrics;
import javax.swing.JTextArea;



class LinkyWebView
    extends JPanel
    implements MouseListener {

    Image img;      // Contains the image to draw on MyCanvas
    int i;
    private Graphics2D drawImage;
    private Renderer render;
    RenderObject node;
    Font font;
    FontMetrics metrics;
    
    public LinkyWebView()
    {
        // Initialize img here.
        this.addMouseListener(this);
	font = new Font("Arial",Font.ITALIC,50);
	//fontMetrics = new FontMetrics(font);
    }

    public void paintComponent(Graphics graphics01)
    {
	Linky.logger.info("inside paint component");
	super.paintComponent(graphics01);
	Graphics2D graphics = (Graphics2D)graphics01;

	Map<Integer, RenderObject> e = Renderer.getInstance().getData();

	for(Map.Entry<Integer, RenderObject> entry : e.entrySet()) {
	    System.out.println("##################");
	    System.out.println("Render node : " +   entry.getValue().getNode());
	    System.out.println("******************");
	    int key = entry.getKey();  
	    RenderObject b = entry.getValue();
	    b.paintObj(graphics01);
	}
	
	e.clear();

	/*	
	FontMetrics metrics = graphics.getFontMetrics(font);
	Map<Integer, RenderObject> e = Renderer.getInstance().getData();
	x = 10;
	y=10;
		for(Map.Entry<Integer, RenderObject> entry: e.entrySet()) {
		    System.out.println("x : y : " + x + " " + y);

	       int key = entry.getKey();  
	    RenderObject b = entry.getValue();
	    
	    if( b.nodeName.matches("#text") && b.stnode.length() > 1) {
		if(b.parent.matches("title")) {
	
		} else 
		if(b.parent.matches("div")) {

		    graphics.drawString(b.stnode, x, y);
		    System.out.println("x : y : " + x + " " + y);
	
		    y = y + paddingY + height;
		} else
		    if( !(b.parent.matches("div")) && !(b.parent.matches("title"))) {
		  graphics.drawString(b.stnode, x, y);
		  width = metrics.stringWidth(b.stnode);
		    x = x + paddingX +width ;
		    System.out.println("x : y : " + x + " " + y);
		}
	    }
	}
		x = 10;
		y = 10;
		e.clear();
	*/
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e){}

public 	void mouseReleased(MouseEvent e) {}
 
public	void mouseEntered(MouseEvent e) {}

     public void actionPerformed(ActionEvent arg0) {
     
    }
}
