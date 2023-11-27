package ServerClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class servidorUDP {

    public static void main(String[] args) throws IOException {
        int puerto = 5300;

        //crear socket de datagrama UDP
        DatagramSocket datagramSocket =  new DatagramSocket(puerto);


        //arreglo de bytes para recibir datos
        byte[] bufferEntrada = new byte[1024];

        //aquí está la información del cliente
        DatagramPacket datagramPacket = new DatagramPacket(bufferEntrada, 0, bufferEntrada.length);

        //recibir los datos en un buffer de bytes
        datagramSocket.receive(datagramPacket);


        Thread hiloCliente = new HiloCliente(datagramSocket, datagramPacket);
        hiloCliente.start();
    }



}
