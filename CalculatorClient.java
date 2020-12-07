package ccc;

import java.rmi.Naming;
import java.util.Scanner;

import ccc.Calculator;

public class CalculatorClient {
	public static void main(String[] args) {
		 try {
	           
				System.out.println("Finding object...");
	            Calculator c = (Calculator)Naming.lookup("rmi://localhost:1111/MyCalculator");
				//Connect Success
				while(true){
					System.out.println("NHAP CHUOI:");
				    Scanner scan1 = new Scanner(System.in);
				    String a = scan1.nextLine();
				    System.out.println("NHAP LUA CHON:");
				    System.out.println("1. CHON 1 DE IN HOA VA DAO CHUOI\n2.CHON 2 DE DEM SO LUONG TU TRONG CHUOI\n3. NHAP EXIT DE THOAT\n");
				    String so = scan1.nextLine();
				    //String so1 = String.valueOf(so);
					if(so.equals("exit")){
						System.out.println(c.hienthi());
						//c.hienthi();
						break;
					}
					int so1 = Integer.parseInt(so);
					while(so1!=1&&so1!=2)
				    {
				    	System.out.println("LUA CHON CHUA DUNG, MOI NHAP LAI:");
				    	so = scan1.nextLine();
				    }
				    if(so1==1)
			            System.out.println("Chuoi dao:"+c.DoiChuoi(a));
				    else 
				    	 if(so1==2)
					            System.out.println("so luong tu trong cau:"+c.Dem(a));
				    
			        }       
			}
			catch (Exception e) {
	            System.out.println(e);
	        }
   }

}
