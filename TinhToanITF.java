import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TinhToanITF extends Remote{
	public int cong(int a,int b) throws RemoteException;
	public int tru(int a,int b) throws RemoteException;
	public int nhan(int a,int b) throws RemoteException;
	public int chia(int a,int b) throws RemoteException;
}
