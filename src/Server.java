import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Lluís Bayer Soler on 01/02/17.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5555);

            while(true) {
                String mensajeServidor;
                Socket socket = server.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(inputStream));
                while ((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
                {
                    //Se muestra por pantalla el mensaje recibido
                    System.out.println(mensajeServidor);
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
