import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddress {
    public static void main(String[] args) {
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            
            System.out.println("Local Host name: " + localAddress.getHostName());
        
            System.out.println("Local IP address: " + localAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
