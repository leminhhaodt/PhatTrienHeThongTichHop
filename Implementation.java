package server;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import flight.Flight;
import rmi.IFlight;
public class Implementation extends UnicastRemoteObject implements IFlight{

		public Implementation() throws RemoteException {
			
		}
		//--------------Data--------------
		public Flight[] Data(){
			File f = new File("F:\\lap5\\src\\server\\lib.txt");
			Scanner c = null;
			try {
				c = new Scanner(f,"UTF-8");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Flight data[] = new Flight[100];
			int i = 0;
			while(c.hasNextLine()) {
				String line = c.nextLine();
				String[] parts = line.split("\t");
				data[i] = new Flight();				
				data[i].setId(parts[0]);
				data[i].setDate(parts[1]);
				data[i].setFrom(parts[2]);
				data[i].setTo(parts[3]);
				data[i].setFlyTime(parts[4]);
				data[i].setTotal(Integer.parseInt(parts[5]));
				data[i].setOdered(Integer.parseInt(parts[6]));
				i++;
				}
			Flight Data[] = new Flight[i];
			for (int j = 0; j < Data.length; j++) {
				Data[j] = data[j];
			}
			return Data;
		}
		
		//------------getFlight = findId------------
		@Override
		public Flight getFlight(String x){
			// TODO Auto-generated method stub
			Flight[] data = Data();
			Flight DataFind = new Flight();
			for (int i = 0; i < data.length; i++) {
				if (data[i].getId().equals(x)) {
					DataFind = data[i];
					break;
				}
			}
			return DataFind;
			
	    }
		//------------Id Flight----------------
		@Override
		public String[] DataId() throws RemoteException {
			// TODO Auto-generated method stub
			Flight[] data = Data();
			String[] id = new String[data.length]; 
			for (int i = 0; i < data.length; i++) {
				id[i] = new String();
				id[i] = data[i].getId();
			}
			return id;
		}	
		//-----------Edit data--------------

		//------------Display Client--------------
		@Override
		public String Display(int x) throws RemoteException {
			// TODO Auto-generated method stub
			String s = new String();
			switch(x) {
			case 0:{
				s ="\n"+"					DANH SÁCH CÁC VÉ     				"
						+"\n"+" Nhập số tương ứng để xem chi tiết vé\t"+"\n"+" Gõ exit để thoát"+"\n\n";
				break;
			}
			case 1:{
				 s ="\n"+"					CHI TIẾT VÉ					"							
							+"\n1.Đặt vé\n"+"2.Trả vé\n"+"3.Thoát"+"\n";
				 break;
			}
			case 2:{
				 s ="aaa";
				 break;
			}
			default:{
				s = "Vui lòng nhập số tương ứng\n\n";
				break;
			}
			}
			return s;
		}
		@Override
		public String Order(String x, int y,String user,String password) throws RemoteException {
			String s = null;
			// TODO Auto-generated method stub
			if(user.equals("leminhhao")&&password.equals("leminhhao")) {
				Flight[] data = Data();
				for (int i = 0; i < data.length; i++) {
					if(data[i].getId().equals(x)) {
						data[i].setOdered(data[i].getOdered()+y);
					}
				}
				try {
					FileWriter writer = new FileWriter("F:\\lap5\\src\\server\\lib.txt");
					for (int i = 0; i < data.length; i++) {
						writer.write(data[i].getId()+"\t"+data[i].getFlydate()+"\t"+data[i].getFrom()+"\t"+data[i].getTo()+"\t"+data[i].getFlyTime()+"\t"+data[i].getTotal()+"\t"+data[i].getOdered()+"\n");
					}
					writer.close();
					s = "Mua vé thành công";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				s = "Sai tên hoặc mật khẩu!";
			}
			return s;
		}
		

}
