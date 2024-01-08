import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SaludoRemotoImpl extends UnicastRemoteObject implements SaludoRemoto {

    public SaludoRemotoImpl() throws RemoteException{
        super();
    }

    @Override
    public String saludo( String nombre) throws RemoteException{
        return "Hola " + nombre + " desde el servidor remoto";
    }
}
