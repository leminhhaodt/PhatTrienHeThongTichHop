package cau11;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverbai1 {
		public static void main(String[] args) throws IOException {
			ServerSocket serverSocket =new ServerSocket(5000);
			System.out.println("Da tao ket noi voi server, dang doi client ket noi");
			Socket socket =serverSocket.accept();
			DataInputStream dataInputStream =new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			String str =dataInputStream.readUTF();
			String str2 ;
			if(str.equals("1"))
			{
				str2="mot";
			}
			else if(str.equals("2"))
			{
				str2="hai";
			}
			else if(str.equals("3"))
			{
				str2="ba";
			}
			else if(str.equals("4"))
			{
				str2="bon";
			}
			else if(str.equals("5"))
			{
				str2="nam";
			}
			else if(str.equals("6"))
			{
				str2="sau";
			}
			else if(str.equals("7"))
			{
				str2="bay";
			}
			else if(str.equals("8"))
			{
				str2="tam";
			}
			else if(str.equals("9"))
			{
				str2="chin";
			}
			else {
				str2="khong la so nguyen";
			}	
			dataOutputStream.writeUTF(str2);
			dataOutputStream.flush();
			dataInputStream.close();
			dataOutputStream.close();
			serverSocket.close();
			socket.close();
		}

}
