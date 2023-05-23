import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());
    private final static String message = "First messsage";
    private final static Supplier<String> messageSupplier = () -> "Second message";
    private final  static ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages", Locale.US);

    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("Logger.properties"));
        logger.info(message);
        logger.info(messageSupplier);
        logger.log(Level.INFO,message);
        logger.logp(Level.INFO,"Class: Main","Method: main",message);
        logger.logrb(Level.INFO,"Class: Main","Method: main",resourceBundle,"message id");

    }
}