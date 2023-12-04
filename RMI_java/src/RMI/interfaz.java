package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaz extends Remote {
    String mensaje() throws RemoteException;

    double suma(double a, double b) throws RemoteException;
    double resta(double a, double b) throws RemoteException;
    double multiplicar(double a, double b) throws RemoteException;
    double dividir(double a, double b) throws RemoteException;



}
