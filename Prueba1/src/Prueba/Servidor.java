package Prueba;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {
    private static final int PUERTO = 5000;
    private static final int NUMERO_PREGUNTAS = 3; // Cambia a 10 para incluir 10 preguntas
    private static ArrayList<ManejadorCliente> clientesConectados = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket servidorSocket;

        try {
            servidorSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor listo para aceptar conexiones en el puerto " + PUERTO);

            // Crear preguntas y respuestas
            ArrayList<Pregunta> preguntas = crearPreguntas();

            // Crear un pool de hilos para manejar conexiones simultáneas
            ExecutorService pool = Executors.newFixedThreadPool(10);

            while (true) {
                Socket socketCliente = servidorSocket.accept();
                System.out.println("Cliente conectado desde " + socketCliente.getInetAddress());

                // Crear un nuevo hilo para manejar la conexión con el cliente
                ManejadorCliente manejadorCliente = new ManejadorCliente(socketCliente, preguntas, NUMERO_PREGUNTAS);
                clientesConectados.add(manejadorCliente); // Agregar a la lista de clientes conectados
                pool.execute(manejadorCliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Pregunta> crearPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<>();

        preguntas.add(new Pregunta("¿Cuál es la capital de Francia?", "París"));
        preguntas.add(new Pregunta("¿En qué año se fundó Google?", "1998"));
        preguntas.add(new Pregunta("¿Cuál es el río más largo del mundo?", "Amazonas"));
        preguntas.add(new Pregunta("¿En qué año se fundó la ciudad de Roma?", "753 a.C."));
        preguntas.add(new Pregunta("¿Quién fue el primer emperador romano?", "Augusto"));
        preguntas.add(new Pregunta("¿Qué evento histórico marcó el final de la Edad Media?", "La caída de Constantinopla"));
        preguntas.add(new Pregunta("¿Quién fue el primer presidente de los Estados Unidos?", "George Washington"));
        preguntas.add(new Pregunta("¿Qué evento histórico marcó el inicio de la Revolución Francesa?", "La Toma de la Bastilla"));
        preguntas.add(new Pregunta("¿Quién fue el líder de la Revolución Rusa?", "Vladimir Lenin"));
        preguntas.add(new Pregunta("¿En qué año comenzó la Segunda Guerra Mundial?", "1939"));
        preguntas.add(new Pregunta("¿Quién fue el líder de la Alemania Nazi durante la Segunda Guerra Mundial?", "Adolf Hitler"));
        preguntas.add(new Pregunta("¿En qué año se firmó el Tratado de Versalles?", "1919"));
        preguntas.add(new Pregunta("¿Quién fue el líder de la Unión Soviética durante la Guerra Fría?", "Joseph Stalin"));
        preguntas.add(new Pregunta("¿En qué año se fundó la ciudad de Nueva York?", "1624"));
        preguntas.add(new Pregunta("¿Quién fue el líder de la Revolución Cubana?", "Fidel Castro"));
        preguntas.add(new Pregunta("¿En qué año se fundó la ciudad de Madrid?", "852 d.C."));
        preguntas.add(new Pregunta("¿Quién fue el líder de la Revolución Mexicana?", "Emiliano Zapata"));
        preguntas.add(new Pregunta("¿En qué año se fundó la ciudad de Buenos Aires?", "1536"));
        preguntas.add(new Pregunta("¿Quién fue el líder de la Revolución Boliviana?", "Che Guevara"));
        preguntas.add(new Pregunta("¿En qué año se fundó la ciudad de Lima?", "1535"));
        preguntas.add(new Pregunta("¿Quién fue el líder de la Revolución Sandinista?", "Daniel Ortega"));
        preguntas.add(new Pregunta("¿En qué año se fundó la ciudad de Quito?", "1534"));
        preguntas.add(new Pregunta("¿Quién fue el líder de la Revolución Haitiana?", "Toussaint Louverture"));
        return preguntas;
    }

    // Método para eliminar un cliente desconectado de la lista
    public static synchronized void clienteDesconectado(ManejadorCliente clienteDesconectado) {
        clientesConectados.remove(clienteDesconectado);
        System.out.println("Cliente desconectado desde " + clienteDesconectado.getDireccionCliente());

        if (clientesConectados.isEmpty()) {
            System.out.println("No hay clientes conectados.");
        }
    }
}

class ManejadorCliente implements Runnable {
    private Socket socket;
    private ArrayList<Pregunta> preguntas;
    private String direccionCliente;

    private int numPreg;

    public ManejadorCliente(Socket socket, ArrayList<Pregunta> preguntas, int numPregtunas) {
        this.socket = socket;
        this.preguntas = preguntas;
        this.direccionCliente = socket.getInetAddress().toString();
        this.numPreg = numPregtunas;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            // Envía un mensaje de bienvenida al cliente
            //salida.writeObject("¡Bienvenido al juego de preguntas y respuestas! \n");

            // Lógica del juego
            do {
                salida.writeObject("¡Bienvenido al juego de preguntas y respuestas! \n");
                int puntaje = 0;
                //for (Pregunta pregunta : preguntas) {
                for (int i = 0; i < numPreg ; i++) {
                    //obtener indice de pregunta random
                    Random random = new Random();
                    int indiceRandom = random.nextInt(0,preguntas.size()+1);

                    // Envía la pregunta al cliente
                    salida.writeObject(preguntas.get(indiceRandom).getEnunciado());

                    // Recibir respuesta del cliente
                    String respuestaCliente = (String) entrada.readObject();

                    // Verificar la respuesta y enviar el resultado al cliente
                    if (respuestaCliente.equalsIgnoreCase(preguntas.get(indiceRandom).getRespuestaCorrecta())) {
                        salida.writeObject("\n!Respuesta correcta!\n");
                        puntaje++;
                    } else {
                        salida.writeObject("\n Respuesta incorrecta. La respuesta correcta es: " + preguntas.get(indiceRandom).getRespuestaCorrecta()+ "\n");
                    }
                }

                // Pregunta al cliente si desea jugar de nuevo
                salida.writeObject("Juego terminado. Puntaje obtenido: " + puntaje + "\n¿Desea jugar de nuevo? (si/no) \n");
                String respuestaReinicio = (String) entrada.readObject();

                if (respuestaReinicio.equalsIgnoreCase("no")) {
                    // Cierra la conexión con el cliente
                    socket.close();

                    // Notificar al servidor que el cliente se desconectó
                    Servidor.clienteDesconectado(this);
                    return;
                }
            } while (true);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
