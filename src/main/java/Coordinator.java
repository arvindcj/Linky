import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/* 
   1. Load the URL
   2. Load the parser
   3. Load and render
 */


class Coordinator
/* extends JFrame
    implements ActionListener
*/
{
    private BorderLayout layout;
    private Parser p;
    private String file = "src/test/data/testcases/testdata01.html";
    
    Coordinator(String appTitle,
                int windowXPosition,
                int windowYPosition,
                int windowWidth,
                int windowHeight)
    {

	BrowserUI bui = new BrowserUI("hello", 800, 600);
	bui.drawBrowserWindow(10, 10);
	//super(appTitle);
		

	//p = new Parser(file);
	//file = "http://127.0.0.1:8080/testdata01.html";
	SoupParser jsoup = new SoupParser(file);
	jsoup.run();
	jsoup.elementsHTML();
	//Renderer renderer = new Renderer(jsoup);
	//renderer.buildRendererTree();
	
	/*	Table<Integer, Character, Integer> edges = HashBasedTable.create();
	edges.put(1,'a', 1);
	       	edges.put(2, 'a', 2);
		edges.put(2, '1', 3);
	edges.put(3, '1', 3);
	
	int [] accepting_states = {1};
	String input_string = "";
	int current_node = 1;
	
	FSM.fsm_run(input_string,
		    current_node,
		    edges,
		    accepting_states);
	*/
    }

    public void actionPerformed( ActionEvent e )
    {
	System.out.println(e);
    }

    public static void lo(){
	Linky.logger.info("MVC design pattern");
    }
}
