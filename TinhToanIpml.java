import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TinhToanIpml extends UnicastRemoteObject implements TinhToanITF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected TinhToanIpml() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int cong(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int tru(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int nhan(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int chia(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a/b;
	}
		
}
