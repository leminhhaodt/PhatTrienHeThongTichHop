package ccc;

import java.rmi.RemoteException;

public class CalculatorImpl implements Calculator {
	public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';
    public String DoiChuoi(String a) throws RemoteException{
        System.out.println("Client request to calculate");
        char[] in = a.toCharArray();
		    int begin=0;
		    int end=in.length-1;
		    char temp;
		    while(end>begin){
		        temp = in[begin];
		        in[begin]=in[end];
		        in[end] = temp;
		        end--;
		        begin++;
		    }

		    String out = new String(in).toUpperCase();
		   return (out);
    }
public int Dem(String a) throws RemoteException{
		int count = 0;
        int size = a.length();
        boolean notCounted = true;
        for (int i = 0; i < size; i++) {
            if (a.charAt(i) != SPACE && a.charAt(i) != TAB 
                    && a.charAt(i) != BREAK_LINE) {
                if(notCounted) {
                    count++;
                    notCounted = false;
                }
            } else {
                notCounted = true;
            }
        }
        return count;
    }
public String hienthi() throws RemoteException{
	String s= "Baiii baiiii";
	return s;
	//System.out.println("Baiiii abiiii");
}

}
