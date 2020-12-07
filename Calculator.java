package ccc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
	public int  Dem(String a) throws RemoteException;
	public String DoiChuoi(String a) throws RemoteException;
	public String hienthi() throws RemoteException;

}
