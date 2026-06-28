import java.rmi.*;
import java.rmi.registry.*;

public class RmiServer {
    public static void main(String[] args) throws Exception {
        RemoteMethodImpl obj = new RemoteMethodImpl();
        LocateRegistry.createRegistry(8005);
        Naming.rebind("rmi://localhost:8005/skeleton", obj);
        System.out.println("Server ready...");
    }
}