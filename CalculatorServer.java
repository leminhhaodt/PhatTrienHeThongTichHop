package ccc;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

//import com.sun.jdi.Locatable;

public class CalculatorServer {
	
	public static void main(String[] args) {
	    try {
	        int port = 1111;
	        CalculatorImpl c = new CalculatorImpl();
	        System.out.println("Expoting Calculator...");
	        LocateRegistry.createRegistry(port);
	        UnicastRemoteObject.exportObject(c,port);
	        Naming.bind("rmi://localhost:1111/MyCalculator", c);
	        System.out.println("Register Calculator!!");
	    } catch (Exception e) {
	        System.out.println(e);
	    }  
	    

	  }

}
