import java.util.logging.Level;
import java.util.logging.Logger;

/* Entry point for Linky
   1. setup application window size.
   2. setup application position.
   3. Setup logging.
 */
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

    Coordinator browser;
    
    public static void main( String args[] )
    {
	 
	 Linky.logger.info("BROWSER CONFIGURATION");

	 browser = new Coordinator( _AppTitle,
				    _WindowXPosition,
				    _WindowYPosition,
				    _WindowWidth,
				    _WindowHeight);
    }
}
