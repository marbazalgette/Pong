import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class Network {
	
	private ServerSocket server;
	private int port = 42420;
	private Socket client;
	
	public Network() {
		try {
			server = new ServerSocket(port);
			server.setSoTimeout(1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void connection(InetAddress address){
		try{
			client = new Socket(address, port);
			OutputStream os = client.getOutputStream();
			InputStream is = client.getInputStream();
			//client.close();
			
		}
		catch(IOException e){
			
		}
	}
/*
	public Socket getPlayer2() {
		return this.player2;
	}
	public boolean canBeConnected() {
		Socket client;
		try {
			client = server.accept();	
			if (tmp != null) 
				canBeConnected = true;
		}
		catch (SocketTimeoutException e) {
			//
		}
		catch (IOException e) {
			//
		}
		return canBeConnected || player2 == null;	
	}
	
	public Socket connection(InetAddress address) {
		try {	
			System.out.println(address);
			player2 = new Socket(address, 12000);
		}
		catch(IOException e) {
			//
		}
		return player2;
	}
	
*/	

	
		
}
