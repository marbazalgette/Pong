import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Network {
	
	private ServerSocket server;
	private Socket player2;
	private Communication communication;
	private int port = 15151;

	
	public Network() {
		try {
			server = new ServerSocket(port);
			server.setSoTimeout(1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean canBeConnected() {
		Socket tmp = null;
		try {
			tmp = server.accept();	
		}
		catch (SocketTimeoutException e) {
			//
		}
		catch (IOException e) {
			//
		}
		return (tmp != null) && (player2 == null);	
	}
	
	public void connexion(InetAddress adress) {
		try {
			player2 = new Socket(adress, port);
		}
		catch(IOException e) {
			//
		}
	}
	
	

	
		
}
