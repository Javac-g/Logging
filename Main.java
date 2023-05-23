import java.util.function.Supplier;
import java.util.logging.Logger;

public class Main {
    private final static Logger log = Logger.getLogger(Main.class.getName());
    private final static String message = "First messsage";
    private final static Supplier<String> messageSupplier = () -> "Second message";

    public static void main(String[] args) {

        System.out.println("Hello world!");
        log.info(message);
        log.info(messageSupplier);

    }
}