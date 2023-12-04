package RMI;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class cliente {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        //https://www.javatpoint.com/RMI

        Registry registro = LocateRegistry.getRegistry("localhost",5000);

        interfaz objeto = (interfaz) registro.lookup("ClienteRemoto");
        System.out.println( objeto.mensaje() + "\n" );

        double a =  Double.parseDouble( JOptionPane.showInputDialog("Ingrese un número a: ") );
        double b =  Double.parseDouble( JOptionPane.showInputDialog("Ingrese un número b: ") );

        System.out.printf( "%f + %f = %f %n",a,b,objeto.suma(a,b) );
        System.out.printf( "%f - %f = %f %n",a,b,objeto.resta(a,b) );
        System.out.printf( "%f * %f = %f %n",a,b,objeto.multiplicar(a,b) );
        System.out.printf( "%f / %f = %f",a,b,objeto.dividir(a,b) );

    }
}
