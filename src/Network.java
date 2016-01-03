import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Network {
	
	private ServerSocket server;
	private Socket player2;
	private int port = 15173;
	private boolean canBeConnected = false;

	
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
			player2 = new Socket(address, 12000);
		}
		catch(IOException e) {
			//
		}
		return player2;
	}
	
	

	
		
}
