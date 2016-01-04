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
	OutputStream os;
	InputStream is;
	
	public Network() {
		try {
			server = new ServerSocket(port);
			if (Pong.solo) {
				client = server.accept();
				//Pong.solo = false;
				Pong.solo = false;
			}
			//server.setSoTimeout(1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
/*	public InetAddress getConnectedAddress() {
		return tmp.getInetAddress().getHostAddress();
	}*/
	
	public void connection(InetAddress address){
		try{
			client = new Socket(address, port);
			os = client.getOutputStream();
			is = client.getInputStream();
			Pong.solo = false;
			//client.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public InputStream getInputStream () throws IOException{
		return client.getInputStream();
	}
	
	public OutputStream getOutputStream() throws IOException{
	
			return client.getOutputStream();
		
	
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
