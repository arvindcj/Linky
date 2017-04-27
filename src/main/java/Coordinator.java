import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
   1. Load the URL
   2. Load the parser
   3. Load and render
 */


class Coordinator
    extends JFrame
    implements ActionListener
{
    private BorderLayout layout;
    private Parser p;
    private String file = "src/test/data/testdata01.html";
    
    Coordinator(String appTitle,
                int windowXPosition,
                int windowYPosition,
                int windowWidth,
                int windowHeight)
    {
	super(appTitle);
		
	Linky.logger.info("Parsed File" + file);
	
	layout = new BorderLayout( windowXPosition,
				   windowYPosition);
	Container c = getContentPane();
	c.setLayout( layout );
	setSize( windowWidth, windowHeight );
	//show();
	p = new Parser(file);
    }

    public void actionPerformed( ActionEvent e )
    {
	System.out.println(e);
    }    
}
