import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {

    public static void main(String[] args) throws RemoteException {
        SaludoRemoto objetoRemoto = new SaludoRemotoImpl();

        Registry registro = LocateRegistry.createRegistry(5500);
        registro.rebind("ClienteRemoto", objetoRemoto);

        System.out.println("Servidor remoto iniciado...");
    }
}
