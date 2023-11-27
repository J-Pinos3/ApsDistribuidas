package OtherMachines;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendDavid {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int puerto = 5000;
        DatagramSocket socket =  new DatagramSocket();//create udp soclet

        InetAddress ipServidor = InetAddress.getByName("172.31.118.70");//server ip

        byte[] bufferEntrada = new byte[1024];//receive


        byte[] bufferSalida = null;//send
        while(true){
            String mensaje = sc.nextLine();
            bufferSalida = mensaje.getBytes();
            DatagramPacket paqueteEnviar = new DatagramPacket(bufferSalida, 0, bufferSalida.length, ipServidor, puerto);
            socket.send(paqueteEnviar);

            if(mensaje.equals("bye")){
                break;
            }
        }

        //datagram to get message
        DatagramPacket paqueteRecibir = new DatagramPacket(bufferEntrada, 0, bufferEntrada.length);
        socket.receive(paqueteRecibir);//recieve packet

        String mensajeRecibido = new String( paqueteRecibir.getData() ); //desempaqueto
        System.out.println("Mensaje Recibido: " + mensajeRecibido);
    }


}
