package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) throws IOException {

        int puerto = 5500;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket_cliente = new Socket(address, puerto);

        //                                                      canal por donde ingresa la info
        BufferedReader entrada = new BufferedReader( new InputStreamReader(socket_cliente.getInputStream()) );
        PrintWriter salida = new PrintWriter( socket_cliente.getOutputStream(), true );


        String mensaje = "Hola";
        salida.println(mensaje);

        String datos_recibidos = entrada.readLine();
        System.out.println("Client:\n" +
                "Mensaje Recibido: " + datos_recibidos);


        socket_cliente.close();
    }
}
