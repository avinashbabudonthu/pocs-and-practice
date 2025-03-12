import com.splunk.Service;
import com.splunk.ServiceArgs;

/**
 * Login using username and password
 */
public class SplunkLogin {

    static Service service = null;
    public static void main(String args[]) {
        ServiceArgs loginArgs = new ServiceArgs();
        loginArgs.setPort(8089);
        // loginArgs.setHost("localhost");
//        loginArgs.setScheme("https");
        loginArgs.setScheme("http");

        // Initialize the SDK client
        service = Service.connect(loginArgs);
    }
}