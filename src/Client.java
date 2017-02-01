import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Lluís Bayer Soler on 01/02/17.
 */
public class Client {

    public static void main(String[] args) {

        try {
            System.out.println("Creando cliente");
            /* Socket TCP */
            Socket client = new Socket();

            System.out.println("Estableciendo conexión..");
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            client.connect(addr);

            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();

            System.out.println("Enviando mensaje");
            String msg = "Mi primer mensaje";
            outputStream.write(msg.getBytes());
            String msg2 = "Mi segundo mensaje";
            outputStream.write(msg2.getBytes());

            System.out.println("Mensaje enviado");

            System.out.println("Cerrando socket");
            client.close();
            System.out.println("Terminado");
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
