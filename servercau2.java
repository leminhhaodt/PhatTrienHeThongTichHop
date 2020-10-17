package cau22;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class servercau2 {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try {
				ServerSocket server = new ServerSocket(6666);
				System.out.println("Server da duoc tao");
				Socket client = server.accept();
				System.out.println("Client da ket noi den server");
				Scanner inFromClient = new Scanner(client.getInputStream());
				PrintStream outToClient = new PrintStream(client.getOutputStream());
				outToClient.println("nhap ten sach can tim:");
				String name = inFromClient.nextLine();
				System.out.println("client: " +name);
				
				 BufferedReader br = null;
			            br = new BufferedReader(new FileReader("F:\\lib.txt"));       
			            String textInALine = br.readLine();
				if(textInALine.contains(name))
				outToClient.println("sach duoc tim thay ");
				else outToClient.println("Khong tim thay sach ban can tim ");
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}

		}
}
