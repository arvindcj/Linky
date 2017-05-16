import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LinkyWebView
    extends JPanel
    implements MouseListener {

    Image img;      // Contains the image to draw on MyCanvas
    int i;
    public LinkyWebView()
    {
        // Initialize img here.
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g)
    {
        // Draws the image to the canvas
	g.drawString("sdf : " + i, 10, 10);
        //g.drawImage(img, 0, 0, null);
	i++;
    }

    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();

        Graphics g = img.getGraphics();
        g.fillOval(x, y, 3, 3);
        g.dispose();
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e){}

public 	void mouseReleased(MouseEvent e) {}
 
public	void mouseEntered(MouseEvent e) {}
}
