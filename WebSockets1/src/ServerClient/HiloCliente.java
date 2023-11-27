package ServerClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HiloCliente extends Thread{

    private DatagramPacket datagramPacket;
    private DatagramSocket datagramSocket;
    public HiloCliente(DatagramSocket ds, DatagramPacket dp){
        this.datagramSocket = ds;
        this.datagramPacket = dp;
    }

    @Override
    public void run(){
        String mensajeRecibido = new String( datagramPacket.getData() ); //desempaqueto
        System.out.println("Mensaje Recibido: " + mensajeRecibido);

        InetAddress direccionCliente =  datagramPacket.getAddress();
        int puertoCliente = datagramPacket.getPort();

        String respuesta = "Hola, soy el servidor, envíame datos";

        byte[] bufferSalida =  respuesta.getBytes();
        DatagramPacket paqueteRespuesta = new DatagramPacket(bufferSalida, 0, bufferSalida.length, direccionCliente, puertoCliente);

        try {
            datagramSocket.send(paqueteRespuesta);
        } catch (IOException e) {
            System.out.printf("Error al enviar la respuesta: %s", e.getMessage());
        }
    }


}
