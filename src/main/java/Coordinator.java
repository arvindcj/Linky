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


class Coordinator {
    
    private SoupParser soupParser;
    
    Coordinator(String appTitle,
                int windowXPosition,
                int windowYPosition,
                int windowWidth,
                int windowHeight)
    {
	/*
	BrowserUI browserView = new BrowserUI(appTitle,
				      windowWidth,
				      windowHeight,
				      windowXPosition,
				      windowYPosition);
	
	*/
	soupParser = new SoupParser();
	soupParser.parseHTML("sdf");
	/*
	soupParser.addObserver(browserView);

	Controller myController = new Controller();
	myController.addModel(soupParser);
	myController.addView(browserView);
	//myController.initModel(start_value);
	browserView.addController(myController);
	*/

    }
}
