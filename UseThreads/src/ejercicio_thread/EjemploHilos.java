package ejercicio_thread;

import java.util.logging.Logger;

public class EjemploHilos {

    public static void main(String[] args) {

        Hilos h1 = new Hilos(1);
        Hilos h2 = new Hilos(2);



        try{
            h1.start();
            h2.start();
            h1.join();
            h2.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
            Logger.getLogger(null);
        }

        //System.out.println("Programa Principal");
    }
}
