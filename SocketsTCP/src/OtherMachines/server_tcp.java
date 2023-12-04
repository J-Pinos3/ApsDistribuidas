package OtherMachines;

import Cliente.hiloCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class server_tcp {
    public static void main(String[] args) throws IOException {
            ServerSocket socket_servidor = null;
        new MulticastSocket();
        try{
             socket_servidor = new ServerSocket(5500);
            while(true){
                Socket socket_cliente = socket_servidor.accept();


                System.out.println("Servidor\n: Conexión establecida con el cliente: "
                        + socket_cliente.getInetAddress().getHostAddress());


                hiloCliente hilo = new hiloCliente(socket_cliente);
                hilo.start();
            }
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }



    }
}
