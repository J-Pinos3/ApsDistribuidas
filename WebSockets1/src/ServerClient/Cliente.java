package ServerClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void main(String[] args) throws IOException {

        int puerto = 5000;
        DatagramSocket socket =  new DatagramSocket();//create udp soclet

        InetAddress ipServidor = InetAddress.getByName("172.31.118.70");//server ip

        byte[] bufferEntrada = new byte[1024];//receive

        String mensaje = "Hola, Soy Byron, manda la tesis";//message to send
        byte[] bufferSalida = mensaje.getBytes();//send

        //datagram the message, create package to send data
        DatagramPacket paqueteEnviar = new DatagramPacket(bufferSalida, 0, bufferSalida.length, ipServidor, puerto);
        socket.send(paqueteEnviar);

        //datagram to get message
        DatagramPacket paqueteRecibir = new DatagramPacket(bufferEntrada, 0, bufferEntrada.length);
        socket.receive(paqueteRecibir);//recieve packet

        String mensajeRecibido = new String( paqueteRecibir.getData() ); //desempaqueto
        System.out.println("Mensaje Recibido: " + mensajeRecibido);
    }

}
