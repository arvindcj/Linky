/*
 * This Java source file was generated by the Gradle 'init' task.
 */
/*
public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
*/

/* Browser configuration Setup.

 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Linky
{
    // Logging //
    public static Level defaultLevel = Level.INFO;
    public static String logLevel = System.getProperty("logLevel");
    public static Logger logger = Logger.getLogger(Linky.class.getName());

    private static int _WindowWidth = 800;
    private static int _WindowHeight = 600;
    private static String _AppTitle = "Linky - Text-Browser";
    private static int _WindowXPosition = 100;
    private static int _WindowYPosition = 100;

    public static void main( String args[] )
     {
	 
	 //logger.setLevel(logLevel.isEmpty() ? defaultLevel : Level.parse(logLevel));
	 logger.info("BROWSER CONFIGURATION");

	 Coordinator browser = new Coordinator( _AppTitle,
						_WindowXPosition,
						_WindowYPosition,
						_WindowWidth,
						_WindowHeight);
	 
         browser.addWindowListener(new WindowAdapter() {
                 public void windowClosing( WindowEvent e )
                 {
                     System.exit( 0 );
                 }
             });
	 /*
	 URL url = new URL("http://stackoverflow.com");

	 try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
    for (String line; (line = reader.readLine()) != null;) {
        System.out.println(line);
    }
} 
	 */
     }
 }
