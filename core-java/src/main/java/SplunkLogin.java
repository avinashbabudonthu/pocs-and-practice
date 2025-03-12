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
//        loginArgs.setHost("https://splunkcdl.es.ad.adp.com/en-US/app/myadp_search/search");
        loginArgs.setHost("splunkcdl.es.ad.adp.com");
//        loginArgs.setScheme("https");
        loginArgs.setScheme("http");
        loginArgs.setUsername("donthuav"); // Use your username
        loginArgs.setPassword("Password@01012025"); // Use your password

        // Initialize the SDK client
        service = Service.connect(loginArgs);
    }
}