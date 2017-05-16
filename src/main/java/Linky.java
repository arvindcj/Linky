import java.util.logging.Level;
import java.util.logging.Logger;

public class Linky
{

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
	 
	 Linky.logger.info("BROWSER CONFIGURATION");
	 /*
	 logger.info("*********************");
	 logger.info("App Title : " + _AppTitle);
	 logger.info("Window Width : " + _WindowWidth);
	 logger.info("Window Height : " + _WindowHeight);
	 logger.info("Window X Position : " + _WindowXPosition);
	 logger.info("Window Y Position : " + _WindowYPosition);
	 */
	 Coordinator browser = new Coordinator( _AppTitle,
						_WindowXPosition,
						_WindowYPosition,
						_WindowWidth,
						_WindowHeight);
     }
 }
