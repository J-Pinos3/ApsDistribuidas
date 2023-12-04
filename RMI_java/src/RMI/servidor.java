package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidor {
    public static void main(String[] args) throws RemoteException, MalformedURLException {

        //ImplementacionInterfaz imp = new ImplementacionInterfaz();
        interfaz objetoRemoto = new ImplementacionInterfaz();
        //Naming.rebind("rmi://localhost:5000/sonoo", objetoRemoto);

        Registry registro = LocateRegistry.createRegistry(5000);
        registro.rebind("ClienteRemoto",objetoRemoto);

        System.out.println("Servidor remoto iniciado...");

    }
}
