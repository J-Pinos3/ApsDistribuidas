package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacionInterfaz extends UnicastRemoteObject implements interfaz {

    public ImplementacionInterfaz() throws RemoteException{
        super();
    }


    @Override
    public String mensaje() throws RemoteException { return "Bienvenido al club calamardo"; }


    @Override
    public double suma(double a, double b) throws RemoteException { return a + b; }

    @Override
    public double resta(double a, double b) throws RemoteException { return a - b; }

    @Override
    public double multiplicar(double a, double b) throws RemoteException { return a * b; }

    @Override
    public double dividir(double a, double b) throws RemoteException {
        double resultado = 1;
        try{
            if(b == 0.0){
                throw new ArithmeticException("No se Puede dividir para 0");
            }else{
                resultado = a / b;
            }
        }catch (ArithmeticException e){
            System.out.println("No se divide para 0");
        }

        return  resultado;
    }

}
