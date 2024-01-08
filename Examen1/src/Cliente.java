import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Registry registro = LocateRegistry.getRegistry("localhost",5500);

        SaludoRemoto objeto = (SaludoRemoto) registro.lookup("ClienteRemoto");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");

        String nombre = scanner.nextLine();
        System.out.println("Mensaje del servidor remoto: " + objeto.saludo(nombre) + "\n");
    }
}