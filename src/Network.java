import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Network {
	
	private ServerSocket server;
	private Socket client;
	private Communication communication;
	private int port = 15151;

	
	public Network() {
		try {
			server = new ServerSocket(port);
			client = server.accept();
			communication = new Communication(client);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void connection(String s) {
		try {
			Socket socket = new Socket(s, port);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
		
}
