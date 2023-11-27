package MostrarUnoCero;

public class MostrarNumeros {
    public static void main(String[] args) {
        HiloMostrarCero h0 = new HiloMostrarCero();
        h0.start();


        HiloMostrarUno h1 = new HiloMostrarUno();
        h1.start();

    }
}

class HiloMostrarCero extends Thread {


    @Override
    public void run(){
        for(int f = 1; f  <= 1000; f++){
            System.out.println("0-");
        }
    }

}

class HiloMostrarUno extends Thread {

    @Override
    public void run(){
        for(int f = 1; f  <= 1000; f++){
            System.out.println("1-");
        }
    }

}
