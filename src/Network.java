import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Network {
	
	private ServerSocket server;
	private Socket player2;
	private int port = 15168;
	private boolean isReady = false;

	
	public Network() {
		try {
			server = new ServerSocket(port);
			server.setSoTimeout(1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getPlayer2() {
		return this.player2;
	}
	public boolean canBeConnected() {
		Socket tmp;
		try {
			tmp = server.accept();	
			System.out.println("bite");
			if (tmp != null) 
				isReady = true;
		}
		catch (SocketTimeoutException e) {
			//
		}
		catch (IOException e) {
			//
		}
		System.out.println((player2 == null)+ "\n");
		return isReady || player2 == null;	
	}
	
	public boolean connexion(InetAddress address) {
		try {
			player2 = new Socket(address, 12000);
			return true;
		}
		catch(IOException e) {
			//
		}
		return false;
	}
	
	

	
		
}
