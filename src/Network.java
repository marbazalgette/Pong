import java.io.IOException;
import java.net.ServerSocket;

public class Network {
	
	private ServerSocket server;
	private int port = 15151;

	
	public Network() {
		try {
			server = new ServerSocket(port);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		}
		
}
