package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import rmi.IFlight;

public class Client {
    public static void main(String args[]) {
        try {
            IFlight iFlight = (IFlight) Naming.lookup("rmi://localhost:1999/in4RMI");
            System.out.println("Kết nối thành công");
            System.out.println(iFlight.Display(0));
            String[] id = iFlight.DataId();
            for (int i = 0; i < id.length; i++) {
            	System.out.println((i+1)+">\tIdFlight: "+id[i]+"\t\tFrom: "+iFlight.getFlight(id[i]).getFrom()+"\t\tTo: "+iFlight.getFlight(id[i]).getTo()+"\t\tDate: "+iFlight.getFlight(id[i]).getFlydate());
			}
        	while(true){
        		System.out.print("Mời bạn chọn:");
        		Scanner scan= new Scanner(System.in);
    			String text = scan.nextLine();
    			//
    			if(text.matches("[0-9]+")) { // [0-9]+ or \\d+
    				int x = Integer.parseInt(text);
    				//
    				if(x <= id.length && x > 0) {
    					System.out.println(iFlight.Display(1));
    					System.out.println("ID :\t"+iFlight.getFlight(id[x-1]).getId());
    					System.out.println("From : "+iFlight.getFlight(id[x-1]).getFrom()+"\t====>\tTo :"+iFlight.getFlight(id[x-1]).getTo());
    					System.out.println("Date :\t"+iFlight.getFlight(id[x-1]).getFlydate());
    					System.out.println("Tổng số vé: :\t"+iFlight.getFlight(id[x-1]).getTotal());
    					do {
    						int sold = iFlight.getFlight(id[x-1]).getOdered();
    						int total = iFlight.getFlight(id[x-1]).getTotal();
    						System.out.print("Mời bạn chọn:");
    						Scanner scan1 = new Scanner(System.in);
    						String txt = scan1.nextLine();
    						if(txt.matches("[0-9]+")) {
    							int x1 = Integer.parseInt(txt);
        						if(x1 == 1) {	
        							//
        							if(sold >= total) {
        								System.out.println("Hết vé");
        								scan1.nextLine();
        							}else {
        								while(true) {
        									System.out.println(" Nhập exit để thoát");
        									System.out.print(" Số vé bạn muốn mua:");
            								scan1 = new Scanner(System.in);
            								String od = scan1.nextLine();
            								//
            								if(od.matches("[0-9]+")){
            									int x2 = Integer.parseInt(od);
            									if(sold+x2 < total) {
            										System.out.print("user : ");
                									String u = scan1.nextLine();
                									System.out.print("password : ");
                									String p = scan1.nextLine();
                									System.out.println(iFlight.Order(id[x-1], x2,u,p));
                									scan1.nextLine();
                									break;
            									}else System.out.println("Số vé mua lớn hơn tổng số vé");
            								}else if(od.equals("exit")) { break; }
            								else System.out.println("Nhập sai vui lòng chọn số tương ứng");
            								//
        								}
        							}
        							//
        							System.out.println(iFlight.Display(0));
        							for (int i = 0; i < id.length; i++) {
        				            	System.out.println((i+1)+">\tIdFlight: "+id[i]+"\t\tFrom: "+iFlight.getFlight(id[i]).getFrom()+"\t\tTo: "+iFlight.getFlight(id[i]).getTo()+"\t\tDate: "+iFlight.getFlight(id[i]).getFlydate());
        							}
        							break;
        							}else 
        							if(x1 == 3) {
        							System.out.println(iFlight.Display(0));
        							for (int i = 0; i < id.length; i++) {
        				            	System.out.println((i+1)+">\tIdFlight: "+id[i]+"\t\tFrom: "+iFlight.getFlight(id[i]).getFrom()+"\t\tTo: "+iFlight.getFlight(id[i]).getTo()+"\t\tDate: "+iFlight.getFlight(id[i]).getFlydate());
        							}
        							break;      							
        						}else
        							//===================
        							if(x1 == 2) {
        								System.out.print("user : ");
    									String u1 = scan1.nextLine();
    									System.out.print("password : ");
    									String p1 = scan1.nextLine();
        								if(u1.equals("leminhhao")&&p1.equals("leminhhao"))
        									{System.out.println("Bạn đã trả vé thành công.");}
        								else
        									{System.out.println("Bạn nhập sai tên hoặc mật khẩu");
        									break;	}
        							}else System.out.println("Vui lòng nhập số tương ứng");
    						}
    					}while(true);	
    					//
    				}else System.out.println("Vui lòng nhập đúng số !!!");
    				//
    			}else if(text.equals("exit")) break;
    					else System.out.println("Bạn cần nhập đúng số");
    			//
        	}
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

