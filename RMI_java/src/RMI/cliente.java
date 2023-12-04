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

        int opcion = 1;
        double a = 1;
        double b = 1;

        while(opcion != 0){
                opcion = Menu();
            a =  Double.parseDouble( JOptionPane.showInputDialog("Ingrese un número a: ") );
            b =  Double.parseDouble( JOptionPane.showInputDialog("Ingrese un número b: ") );
            switch (opcion){
                case 1:{
                    JOptionPane.showMessageDialog(null, a + " + " + b + " = " + objeto.suma(a,b));
                }
                break;

                case 2:{
                    JOptionPane.showMessageDialog(null, a + " - " + b + " = " + objeto.resta(a,b));
                }
                break;


                case 3:{
                    JOptionPane.showMessageDialog(null, a + " * " + b + " = " + objeto.multiplicar(a,b));
                }
                break;


                case 4:{
                    JOptionPane.showMessageDialog(null, a + " / " + b + " = " + objeto.dividir(a,b));
                }
                break;

                case 0:{
                    JOptionPane.showMessageDialog(null, "Gracias por su preferencia");
                }
                break;

                default:{
                    JOptionPane.showMessageDialog(null, "Esa opción no existe");
                }
                break;
            }
        }







    }

    public static int Menu(){
        int opcion = Integer.parseInt(  JOptionPane.showInputDialog("1) Sumar\n"+
                "2) Restar\n"+
                "3) Multiplicar\n"+
                "4) Dividir\n"+
                "0) Salir") );


        return opcion;
    }


}
