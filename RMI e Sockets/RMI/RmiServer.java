package RMI;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class RmiServer extends UnicastRemoteObject implements PolarConverter {
    public RmiServer() throws RemoteException {
        super();
    }

    @Override
    public double[] convertToPolar(double x, double y) throws RemoteException {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        return new double[]{r, theta};
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("PolarConverter", new RmiServer());
            System.out.println("Servidor RMI pronto...");
        } catch (Exception e) {
            System.err.println("Erro no servidor RMI: " + e.getMessage());
        }
    }
}

