import java.rmi.*;
import java.rmi.server.*;

public class RemoteMethodImpl extends UnicastRemoteObject implements RemoteMethod {

    RemoteMethodImpl() throws RemoteException {}

    public String changeToLowerCase(String s) throws RemoteException {
        return s.toLowerCase();
    }

    public String changeToUpperCase(String s) throws RemoteException {
        return s.toUpperCase();
    }

    public String palindromeChecker(String s) throws RemoteException {
        String rev = new StringBuilder(s).reverse().toString();
        if (s.equals(rev))
            return s + " is a Palindrome";
        else
            return s + " is NOT a Palindrome";
    }
}