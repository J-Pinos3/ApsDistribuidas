package ejercicio_runnable;

public class EjemploRun {
    public static void main(String[] args) {
        HilosRun h1 = new HilosRun(1);
        HilosRun h2 = new HilosRun(2);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);

        t1.start();
        t2.start();
    }
}
