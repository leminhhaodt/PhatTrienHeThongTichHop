import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class TinhToanServer {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		try {
			LocateRegistry.createRegistry(3333);
			Naming.rebind("rmi://localhost:3333/TinhToan", new TinhToanIpml());
			System.out.println("Tao cong thanh cong");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
