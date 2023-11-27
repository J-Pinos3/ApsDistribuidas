package ejercicio_thread;

public class Hilos extends Thread{
    private int tipo;

    public Hilos(int n){
//        n = n % 3;
//        if( n == 0){
//            n = 1;
//        }
        tipo = n;
    }

    @Override
    public void run(){
        switch (tipo){
            case 1:{
                for(int i = 1; i < 30; i++){
                    System.out.println(i);
                }
            }
            break;
            case 2:{
                for(char i = 'a'; i < 'z'; i++){
                    System.out.println(i);
                }
            }
            break;
        }
    }
}//CLASE HILOS
