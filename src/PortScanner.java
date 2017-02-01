import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
/**
 * Created by Lluís Bayer Soler on 01/02/17.
 */
public class PortScanner {
    public static void main(String[] args) {

        String direction = "172.31.73.{0}";
        int min_ports = 5555;
        int max_ports = 5556;
        int min = 15;
        int max = 45;

        for(int i = min; i < max; i++){
            System.out.println(i);
            for (int j = min_ports; j < max_ports; j++) {
                String actual = direction.replace("{0}", i+"");
                Socket client = new Socket();
                InetSocketAddress addr = new InetSocketAddress(actual, j);
                //System.out.println("CHECK IP: "+actual+" CHECK PORT: "+j);
                try {
                    client.setSoTimeout(100);
                    client.setTcpNoDelay(false);
                    client.connect(addr);
                    OutputStream outputStream = client.getOutputStream();
                    String msg = "¯\\_(ツ)_/¯";
                    outputStream.write(msg.getBytes());
                    System.out.println("IP: " + actual + " OPEN PORT: " + j);
                    client.close();
                }catch(NoRouteToHostException e){
                    break;
                }catch(IOException e){
                    continue;
                }
            }
        }

    }
}
