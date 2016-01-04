import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Network {
	
	private ServerSocket server;
	private int port = 42420;
	private Socket client;
	OutputStream os;
	InputStream is;
	/* Constructeur de l'objet NetWork */
	public Network() {
		try {
			server = new ServerSocket(port);
			if (Pong.host) {
				client = server.accept(); /* Si l'on choisie d'être host le ServerSocket ce met en écoute */
				Pong.host = false;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*Permet au joueur non host de se connecter au ServerSocket en écoute */
	public void connection(InetAddress address){
		try{
			client = new Socket(address, port);
			os = client.getOutputStream();
			is = client.getInputStream();
			Pong.host = false;		
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
	

		
}
