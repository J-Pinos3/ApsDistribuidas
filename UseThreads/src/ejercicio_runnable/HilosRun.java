package ejercicio_runnable;

public class HilosRun implements Runnable{
    private int tipo;

    public HilosRun(int n){
        n = n % 3;
        if( n == 0){
            n = 1;
        }
        tipo = n;
    }

    @Override
    public void run(){
        switch (tipo){
            case 1:{
                for(int i = 1; i < 30; i++)  System.out.println(i);
            }
            break;
            case 2:{
                for(char i = 'a'; i < 'z'; i++) System.out.println(i);
            }
            break;
        }
    }

}//HILOS RUN
