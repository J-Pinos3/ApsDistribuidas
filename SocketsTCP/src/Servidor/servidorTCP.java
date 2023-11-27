package Servidor;

import Cliente.hiloCliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorTCP {

    public static void main(String[] args) {


        try{
            ServerSocket socket_servidor = new ServerSocket(5500);
            while(true){
                Socket socket_cliente = socket_servidor.accept();


                System.out.println("Servidor\n: Conexión establecida con el cliente: "
                        + socket_cliente.getInetAddress().getHostAddress());


                Thread hilo = new hiloCliente(socket_cliente);
                hilo.start();
            }


            //socket_servidor.close();
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }



    }



}//CLASE SERVIDOR TCP
