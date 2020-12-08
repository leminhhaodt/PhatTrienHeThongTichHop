import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class TinhToanClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TinhToanITF tinhToan =(TinhToanITF)Naming.lookup("rmi://localhost:3333/TinhToan");
			System.out.println("Ket noi voi cong thanh cong");
			Scanner scan= new Scanner(System.in);
			String str=null;
			do
			{
				System.out.println("_____MENU_____");
				System.out.println("1.Cong\n2.Tru\n3.Nhan\n4.Chia");
				str=scan.nextLine();
				if(str.equals("1"))
				{
					System.out.println("Nhap a");
					int a= scan.nextInt();
					System.out.println("Nhap b");
					int b=scan.nextInt();
					System.out.println("Tong la:"+tinhToan.cong(a, b));
				}
				else if(str.equals("2"))
				{
					System.out.println("Nhap a");
					int a=scan.nextInt();
					System.out.println("Nhap b");
					int b=scan.nextInt();
					System.out.println("Hieu la:"+tinhToan.tru(a, b));
				}
				else if(str.equals("3"))
				{
					System.out.println("Nhap a");
					int a=scan.nextInt();
					System.out.println("Nhap b");
					int b=scan.nextInt();
					System.out.println("Tich la:"+tinhToan.nhan(a, b));
				}
				else if(str.equals("4"))
				{
					System.out.println("Nhap a");
					int a=scan.nextInt();
					System.out.println("Nhap b");
					int b=scan.nextInt();
					System.out.println("Thuong la:"+tinhToan.chia(a, b));
				}
				else if(str.equals("exit"))
				{
					System.out.println("Thoat thanh cong");
				}
				else 
				{
					System.out.println("Nhap sai menu");
				}
				scan.nextLine();
			}
				while(!str.equals("exit"));
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
