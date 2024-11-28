package RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PolarConverter extends Remote {

    double[] convertToPolar(double x, double y) throws RemoteException;
    
}
