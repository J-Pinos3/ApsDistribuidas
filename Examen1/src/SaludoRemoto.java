import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SaludoRemoto extends Remote {

    String saludo( String nombre) throws RemoteException;

}
