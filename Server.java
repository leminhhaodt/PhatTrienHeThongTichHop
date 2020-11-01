package server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.IFlight;

public class Server {
    public static void main(String args[]) {

        try {
            LocateRegistry.createRegistry(1999);
            
            // Sign in rmiregistry
            IFlight x = new Implementation();
            Naming.bind("rmi://localhost:1999/in4RMI", x );
            System.out.println("Thông báo: server đã sẵn sàng");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
