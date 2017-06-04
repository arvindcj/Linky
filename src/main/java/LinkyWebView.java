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


/* Browser View
   1. Mouse event listners.
   2. paint on browser.
   3. read Renderer.
   4. iterate through Render Tree.
   5. read RenderObject and RenderStyle.
 */
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
	    int key = entry.getKey();  
	    RenderObject b = entry.getValue();
	    b.paintObj(graphics01);
	}
	
	e.clear();
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }
 
    public void mouseEntered(MouseEvent e)
    {
    }

    public void actionPerformed(ActionEvent arg0)
    { 
    }
}
