package cau5;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class server_cau5 {
		public static void main(String[] args) {
			try {
				ServerSocket server = new ServerSocket(1234);
				System.out.println("Server da duoc tao");
				Socket client = server.accept();
				System.out.println("Client da ket noi den server");
				Scanner inFromClient = new Scanner(client.getInputStream());
				PrintStream outToClient = new PrintStream(client.getOutputStream());
				outToClient.println("Nhap chuoi can dao nguoc:");
				String a = inFromClient.nextLine();
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
			    outToClient.println(in);
				} catch (IOException e) {
				e.printStackTrace();
				}
		}
}
