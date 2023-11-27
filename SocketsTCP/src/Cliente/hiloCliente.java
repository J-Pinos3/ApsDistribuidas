package Cliente;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class hiloCliente extends Thread{
    private Socket socket_cliente;
    public hiloCliente(Socket socketCliente) { socket_cliente = socketCliente; }

    @Override
    public void run(){

        try {
            //                                                   canal por donde ingresa la info
            while(true){
                BufferedReader entrada = new BufferedReader( new InputStreamReader(socket_cliente.getInputStream()) );
                PrintWriter salida = new PrintWriter( socket_cliente.getOutputStream(), true );

                String datos_recibidos = entrada.readLine();
                System.out.println("Cliente: " + datos_recibidos);

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter response: ");
                String mensaje = scanner.nextLine();

                salida.println(mensaje);
            }
        } catch (IOException e) {

            if( e instanceof SocketException){
              System.out.println("El cliente" + socket_cliente.getInetAddress().getHostAddress() + " cliente se ha desconectado");
            }else{ e.printStackTrace(); }
        }

    }

}//CLASE HILO CLIENTE
