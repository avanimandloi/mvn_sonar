package sonar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        Logger logger = Logger.getLogger(App.class.getName());
        String str = "Hello World!";
        logger.log(Level.INFO, "Hello World");
    }
}
