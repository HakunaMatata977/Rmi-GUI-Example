import java.rmi.*;

public interface RemoteMethod extends Remote {
    String changeToLowerCase(String s) throws RemoteException;
    String changeToUpperCase(String s) throws RemoteException;
    String palindromeChecker(String s) throws RemoteException;
}