package Prueba;

import java.io.*;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        String servidorIP = "localhost";
        int puerto = 5000;

        try (Socket socket = new Socket(servidorIP, puerto);
             ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream())) {

            while (true) {
                String mensaje = (String) entrada.readObject();
                System.out.println(mensaje);

                if (mensaje.contains("Juego terminado")) {
                    // Pregunta al usuario si desea jugar de nuevo
                    String respuestaReinicio = JOptionPane.showInputDialog(null,
                            "Juego terminado. ¿Desea jugar de nuevo? (si/no)");

                    // Envía la respuesta al servidor
                    salida.writeObject(respuestaReinicio);

                    if (respuestaReinicio.equalsIgnoreCase("no")) {
                        System.out.println("Programa cerrado.");
                        return;
                    }
                }
                // Muestra la pregunta al jugador y espera la respuesta
                JOptionPane.showMessageDialog(null, "Mensaje del servidor: " + mensaje);



                // Muestra la respuesta del servidor
                String respuestaServidor = (String) entrada.readObject();
                System.out.println("mensaje del servidor: " + respuestaServidor);

                String respuesta =JOptionPane.showInputDialog("Pregunta: "+respuestaServidor);
                salida.writeObject(respuesta);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


/*
public class Cliente {
    public static void main(String[] args) {
        String servidorIP = "localhost";
        int puerto = 5000;

        try {
            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));


                Socket socket = new Socket(servidorIP, puerto);
                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());

                // Lee el mensaje de bienvenida del servidor
                System.out.println((String) entrada.readObject());
                while (true) {
                    String preguntaTexto = (String) entrada.readObject();
                    if (preguntaTexto.equals("Juego terminado")) {
                        // Pregunta al usuario si desea jugar de nuevo
                        System.out.println("Juego terminado. ¿Desea jugar de nuevo? (si/no)");
                        String respuestaReinicio = lector.readLine().toLowerCase();

                        // Envía la respuesta al servidor
                        salida.writeObject(respuestaReinicio);

                        if (respuestaReinicio.equalsIgnoreCase("no")) {
                            System.out.println("Programa cerrado.");
                            socket.close();
                            return;
                        } else {
                            break;
                        }
                    }

                    // Muestra la pregunta al jugador y espera la respuesta
                    //System.out.println("Pregunta: " + preguntaTexto);
                    //String respuesta = lector.readLine();
                    String respuesta = JOptionPane.showInputDialog("Pregunta: " + preguntaTexto);
                    salida.writeObject(respuesta);
                    salida.flush(); // Asegura que los datos se envíen inmediatamente


                    String respuestaServidor = (String) entrada.readObject();
                    System.out.println("resp: "+respuestaServidor);
                }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
*/
